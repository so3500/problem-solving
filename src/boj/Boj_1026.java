/*
 * 문제: 1026 보물 / 264 ms
 * link: https://www.acmicpc.net/problem/1026
 * 알고리즘: 정렬
 * 풀이방법:
 *      두 입력 시퀀스 배열이 주어졌을 때 S의 최소값을 구하는 방법은
 *      하나의 배열은 내림차순, 하나의 배열은 오름차순으로 정렬한 뒤
 *      S = A[0]*B[0] + ... + A[N-1]*B[N-1] 값을 구하는 것이다.
 *      정렬은 우선순위 큐를 이용하여 해결한다.
 *      우선순위 큐는 기본적으로 오름차순으로 정렬한다. 따라서 다른 하나의 우선순위 큐를 생성할 때
 *      Comparable 을 따로 선언한다.
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   입력 N에 대하여 우선순위 큐를 정렬 (heap으로 구현 시)
 *   O(NlogN)
 *
 * 공간복잡도(Space Complexity)
 *   입력 N일 때 1차원 배열 사용
 *   O(N)
 *
 * */

package boj;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj_1026 {

    static PriorityQueue<Integer> PA, PB;
    static int N, ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        // defalut: 오름차순 정렬
        PA = new PriorityQueue<>(N);
        // 내림차순 정렬
        PB = new PriorityQueue<>(N, (a, b) -> {
            return a >= b ? -1 : 1;
        });
        for (int i = 1; i <= N; i++) {
            PA.add(sc.nextInt());
        }
        for (int i = 1; i <= N; i++) {
            PB.add(sc.nextInt());
        }
        solve();
    }

    static void solve() {
        int n = N;
        while (n-- > 0) {
            ans += PA.poll() * PB.poll();
        }
        System.out.println(ans);
    }
}
