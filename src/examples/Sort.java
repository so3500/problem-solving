package examples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;

public class Sort {

	static int[] arr, sortedArr;
	static int SIZE = 40000;

	public static void main(String[] args) throws Exception {
		long start, end;
		getRandomNumber();
		start = System.currentTimeMillis();
		// bubble sort (40000, 2.485)
		// bubbleSort();

		// insertion sort (40000, 0.919)
		// insertionSort();

		// selection sort (40000, 0.492)
		// selectionSort();

		// merge sort (40000, 0.015)
		mergeSort(0, 39999);

		// quick sort

		// heap sort

		// radix sort

		end = System.currentTimeMillis();
		System.out.println("time: " + (end - start) / 1000.0);
		// printArr("bubbleSort.txt");
		// printArr("selectionSort.txt");
		printArr("mergeSort.txt");
	}

	static void getRandomNumber() throws Exception {
		// FileOutputStream input = new FileOutputStream("input.txt");
		// FileOutputStream output = new FileOutputStream("output.txt");
		Random r = new Random();
		arr = new int[SIZE]; // 비정렬 배열
		// sortedArr = new int[SIZE]; // 정렬 배열
		int num = 0;
		// 비정렬 배열 생성
		for (int i = 0; i < SIZE; i++) {
			// sortedArr[i] = i;
			boolean isUnique = false;
			// 난수 생성 후, 기존에 생성된 수와 겹치지 않도록 루프
			while (!isUnique) {
				isUnique = true;
				num = r.nextInt(SIZE);
				for (int j = 0; j < i; j++) {
					if (num == arr[j]) {
						isUnique = false;
						break;
					}
				}
			}
			arr[i] = num;
		}
		// 출력
		// StringBuilder sb = new StringBuilder();
		// StringBuilder sb2 = new StringBuilder();
		// for (int i = 0; i < SIZE; i++) {
		// sb.append(arr[i]).append("\r\n");
		// sb2.append(sortedArr[i]).append("\r\n");
		// }
		// output.write(sb2.toString().getBytes());
		// input.write(sb.toString().getBytes());
		// output.close();
		// input.close();
	}

	static void bubbleSort() {
		// 오름차순 정렬일 때 큰 수를 뒤로 보낸다.
		for (int i = SIZE - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(j, j + 1);
				}
			}
		}
	}

	static void selectionSort() {
		// https://en.wikipedia.org/wiki/Selection_sort
		int i, j, minIdx;
		for (i = 0; i < SIZE; i++) {
			minIdx = i;
			for (j = i; j < SIZE; j++) {
				if (arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}
			if (minIdx != i) {
				swap(i, minIdx);
			}
		}
	}

	static void insertionSort() {
		// https://en.wikipedia.org/wiki/Insertion_sort
		int i, j, temp;
		for (i = 0; i < SIZE; i++) {
			temp = arr[i];
			for (j = i; j >= 1; j--) {
				if (arr[j - 1] > arr[j]) {
					arr[j] = arr[j - 1];
				} else {
					break;
				}
			}
			arr[j] = temp; // less number of exchanges, shift
		}
	}

	static void mergeSort(int left, int right) {
		int mid;

		// 더 이상 분할할 수 없을 경우 리턴
		if (left >= right)
			return;

		mid = (left + right) / 2;

		mergeSort(left, mid);
		mergeSort(mid + 1, right);
		merge(left, mid, right);
	}

	static void merge(int left, int mid, int right) {
		int i, j, k, m;

		i = left;
		j = mid + 1;
		k = 0; // 임시 배열의 인덱스

		int[] tmpArr = new int[right - left + 1];

		// left 부터 mid 까지의 블록과 mid+1 부터 right 까지의 블록을 서로 비교
		while (i <= mid && j <= right) {
			if (arr[i] < arr[j]) { // left index 값이 작으면 left index 값을 임시 배열에 복사
				tmpArr[k] = arr[i];
				i++;
			} else { // right index 값이 작으면 right index 값을 임시 배열에 복사
				tmpArr[k] = arr[j];
				j++;
			}
			k++;
		}

		// left 블록의 값은 다 정렬했는데 right 블록에 element가 남아있을 경우
		// right 블록의 남은 element를 순차적으로 임시 배열에 복사
		if (i > mid) {
			for (m = j; m <= right; m++) {
				tmpArr[k] = arr[m];
				k++;
			}
		} else { // left 블록의 element 가 아직 남아있을 경우 남은 element를 순차적으로 임시 배열에 복사
			for (m = i; m <= mid; m++) {
				tmpArr[k] = arr[m];
				k++;
			}
		}

		// 임시배열의 값을 배열에 복사
		k = 0;
		for (m = left; m <= right; m++) {
			arr[m] = tmpArr[k];
			k++;
		}
	}

	static void swap(int idxA, int idxB) {
		int temp = arr[idxA];
		arr[idxA] = arr[idxB];
		arr[idxB] = temp;
	}

	static void printArr(String fileName) throws Exception {
		FileOutputStream output = new FileOutputStream(fileName);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < SIZE; i++) {
			sb.append(arr[i]).append("\r\n");
		}
		output.write(sb.toString().getBytes());
		output.close();
	}

	// 온코더 1문제
	public String decryptSpell(String str) {
		StringBuilder builder = new StringBuilder(str);
		int strLen = builder.length();
		if (strLen >= 3) {
			// 문자열에서 3으로 나누어 떨어지는 순서에 있는 문자만 검사한다.
			for (int idx = 2; idx < strLen; idx += 3) {
			    // 정규식을 사용하여 조건에 해당하는 문자열을 대무자로 변환한다.
				if (Pattern.matches("[a-z]", builder.substring(idx, idx + 1))) {
					builder.replace(idx, idx + 1, builder.substring(idx, idx + 1).toUpperCase());
				} else {
					builder.replace(idx, idx + 1, "!");
				}
			}
		}
		return builder.toString();
	}
}
