/*
 * 문제: 10819 차이를 최대로 / 140 ms
 * link: https://www.acmicpc.net/problem/10819
 * 알고리즘: 완전탐색
 * 풀이방법:
 * 	1차원 배열이 주어질 경우, 이 배열의 값들을 일정한 순서대로 정렬하는 것 처럼 보이도록 선택하는 경우의 수를 만든다.
 * 	즉, 배열의 값들을 순서를 고려하여 정렬한 것 처럼 보이도록 선택한다.
 * 	index: 0-1-2-3, 0-1-3-2, 0-2-1-3 ...
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 * 	입력 N이 주어질 때 N개의 원소들을 순서를 고려하여 나열하므로 (permutation의 시간복잡도를 참고하면)
 * 	O(N!)
 *
 * 공간복잡도(Space Complexity)
 * 	입력 N이 주어질 때 1차원 배열을 사용하므로
 * 	O(N)
 *
 * */

package boj;

import java.util.Scanner;

public class Boj_10819 {

    static int N, maxSum;
    static int[] A;
    static boolean[] visited;

    public static void main(String[] args) {
        init();
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            solve(i, A[i], 0, 1); // dfs 수행
            visited[i] = false;
        }
        System.out.println(maxSum);
    }

    static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        maxSum = Integer.MIN_VALUE;
        sc.close();
    }

    static void solve(int idx, int elm, int sum, int len) {
        if (len == N) {
            maxSum = Integer.max(maxSum, sum);
        } else {
            visited[idx] = true;
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    solve(i, A[i], sum + Math.abs(elm - A[i]), len + 1);
                }
            }
            visited[idx] = false;
        }
    }
}
