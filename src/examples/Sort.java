package examples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Random;

public class Sort {

	static int[] arr, sortedArr;
	static int SIZE = 10000;

	public static void main(String[] args) throws Exception {
		long start, end;
		getRandomNumber();
		// bubble sort
		start = System.currentTimeMillis();
		bubbleSort();
		end = System.currentTimeMillis();
		System.out.println("tiem: " + (end - start) / 1000.0);
		printArr("bubbleSort.txt");
		// insertion sort
		// selection sort
		// merge sort
		// quick sort
		// heap sort
		// radix sort
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

	static void bubbleSort() throws Exception {
		// 오름차순 정렬일 때 큰 수를 뒤로 보낸다.
		for (int i = SIZE - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(j, j + 1);
				}
			}
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
		for(int i=0; i<SIZE; i++) {
			sb.append(arr[i]).append("\r\n");
		}
		output.write(sb.toString().getBytes());
		output.close();
	}
}
