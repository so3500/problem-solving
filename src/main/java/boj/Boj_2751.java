/*
 * 문제: 2751 수 정렬하기2 / 2620 ms
 * link: https://www.acmicpc.net/problem/2751
 * 알고리즘: 정렬
 * 풀이방법:
 *  우선순위 큐에 입력받은 숫자를 추가한다.
 *  우선순위 큐는 기본적으로 오름차순 정렬이므로 poll을 이용하여 root elm 을 빼서 출력한다.
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   입력 N에 대하여 우선순위 큐를 정렬 (heap으로 구현 시)
 *   O(NlogN)
 *
 * 공간복잡도(Space Complexity)
 *   입력 N일 때 선형으로 증가
 *   O(N)
 * */

package boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj_2751 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N;
        N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(N); // 기본 오름차순 정렬
        for (int i = 0; i < N; i++) {
            pq.add(sc.nextInt());
        }
        while (!pq.isEmpty()) {
            bw.write(pq.poll() + "\n");
        }
        bw.flush();
        bw.close();
    }
}
