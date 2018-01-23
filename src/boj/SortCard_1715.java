/*
 * 문제: 카드 정렬하기
 * 알고리즘:
 *  우선순위 큐, 힙을 직접 구현 or 우선순위 큐 stl 사용
 * 풀이방법:
 *  우선순위 큐 자료구조를 이용하여, 우선순위가 큰 카드뭉치를 합한다. 그리고 합한 비용을 누적한다.
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *  우선순위 큐를 힙으로 구현할 경우 크기 N 입력에 대해 삽입(logN), 삭제(logN) 연산은 총
 *  O(NlogN)
 *
 * 공간복잡도(Space Complexity)
 *  크기 N 입력에 대해 1차원 배열을 이용하여 구현
 *  O(N)
 * */

package boj;

import java.io.File;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SortCard_1715 {

    static int[] heap;
    static int N, sum, size;
    static Scanner sc;

    public static void main(String[] args) throws Exception {
//        sc = new Scanner(System.in);
        sc = new Scanner(new File("input.txt"));

        N = sc.nextInt();
        size = N;
        heap = new int[N + 1];
        sum = 0;

        heapSort();
        solve();
//        solve2();
        sc.close();
    }

    public static void solve2() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            priorityQueue.add(sc.nextInt());
        }
        int card = 0;
        sum = 0;
        while (priorityQueue.size() > 1) {
            card = priorityQueue.poll() + priorityQueue.poll();
            sum += card;
            priorityQueue.add(card);
        }
        System.out.println(sum);
    }

    public static void solve() {
        // 카드 한장일 경우 합치는 비용 없음
        // size 가 0이 될 때 까지
        // extractMin 으로 2개 꺼내고 합친 뒤
        // 합친 비용은 sum 에 더하고
        // 다시 insert
        int card;
        while (size > 1) {
            card = extractMin() + extractMin();
            sum += card;
            insert(card);
        }
        System.out.println(sum);
    }

    public static void heapSort() {
        buildHeap();
        // 원래는 여기서 하나씩 꺼냄
    }

    public static void buildHeap() {
        // heap shape property 만족
        for (int i = 1; i <= N; i++) {
            heap[i] = sc.nextInt();
        }
        // heap partial order property 만족(부모는 자식보다 작다)
        partialOrder(1);
    }

    public static void partialOrder(int rootIndex) {
        int leftIndex = rootIndex * 2;
        int rightIndex = rootIndex * 2 + 1;
        if (rightIndex <= N) {
            partialOrder(leftIndex);
            partialOrder(rightIndex);
            // 두 자식 중 작은 자식 구하기
            // 작은 자식이 부모보다 더 작으면 부모는 해당 자리에서 downHeap
            if (heap[leftIndex] >= heap[rightIndex]) {
                if (heap[rootIndex] >= heap[rightIndex]) {
                    downHeap(rootIndex);
                }
            } else {
                if (heap[rootIndex] >= heap[leftIndex]) {
                    downHeap(rootIndex);
                }
            }
        } else if (leftIndex <= N) {
            partialOrder(leftIndex);
            if (heap[rootIndex] >= heap[leftIndex]) {
                downHeap(rootIndex);
            }
        }
    }

    public static void downHeap(int rootIndex) {
        int leftIndex = rootIndex * 2;
        int rightIndex = rootIndex * 2 + 1;
        if (rightIndex <= size) {
            // 자식이 2개일 경우
            // 두 자식 중 작은 자식 구하기
            // 작은 자식이 부모보다 더 작으면 부모와 swap
            // 이후 swap 한 자리로 내려감
            // 내려간 자리에서 재귀적으로 downHeap
            if (heap[leftIndex] >= heap[rightIndex]) {
                if (heap[rootIndex] >= heap[rightIndex]) {
                    swap(rootIndex, rightIndex);
                    downHeap(rightIndex);
                }
            } else {
                if (heap[rootIndex] >= heap[leftIndex]) {
                    swap(rootIndex, leftIndex);
                    downHeap(leftIndex);
                }
            }
        } else if (leftIndex <= size) {
            // 자식이 1개일 경우
            if (heap[rootIndex] > heap[leftIndex]) {
                swap(rootIndex, leftIndex);
            }
        }
    }

    public static int extractMin() {
        // 맨 위에꺼 꺼낸다음
        int minElm = heap[1];
        // 맨 마지막 요소를 rootIndex 에 넣고
        heap[1] = heap[size];
        heap[size] = 0;
        // size 1 줄이고
        size--;
        // rootIndex 가 제자리로 가도록 재귀적으로 내려감. 자식보다 작을 경우 자식과 swap
        downHeap(1);
        return minElm;
    }

    public static void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public static void upHeap(int index) {
        // 부모보다 작을 경우 rootIndex 가 1이 될 때 까지  재귀적으로 올라감
        // 부모가 반대쪽 자식보다 작은 것이 보장되어 있으므로 부모와만 비교
        if (index > 1) {
            int parentIndex = index / 2;
            if (heap[parentIndex] > heap[index]) {
                swap(parentIndex, index);
                upHeap(parentIndex);
            }
        }
    }

    public static void insert(int elm) {
        // size+1 index 에 element 추가
        heap[size + 1] = elm;
        size++;
        // 추가한 element 를 upheap 을 통해 제자리 찾기
        upHeap(size);
    }
}