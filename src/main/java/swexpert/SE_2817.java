/*
 * 문제: 2817 부분 수열의 합 / 234 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7IzvG6EksDFAXB
 * 알고리즘: 완전 탐색
 * 풀이방법:
 *      A1, A2, ... AN 의 N 개의 자연수를 1개, 2개, ..., N개 모두 선택하는 경우를 구현하고
 *      이 때 각 수의 합을 구해서 K와 비교한다.
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   입력 N일 때 이 중 1, 2, ... N 개를 선택하는 조합의 합
 *   N개중 k를 선택하는 Combination 은 다음과 같이 구할 수 있다. NCK = N-1CK + N-1CK-1
 *   즉 O(2^N)
 *
 * 공간복잡도(Space Complexity)
 *   입력 N일 때 1차원 배열 사용
 *   O(N)
 *
 * */

package swexpert;

import java.util.Arrays;
import java.util.Scanner;

public class SE_2817 {

    static int N, K, ans;
    static int[] arr = new int[20];
    static boolean[] visited = new boolean[20];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t, i;
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            N = sc.nextInt();
            K = sc.nextInt();
            for (i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.fill(visited, false);
            ans = 0;
            solve(0, 0);
            System.out.println("#" + t + " " + ans);
        }
    }

    public static void solve(int start, int sum) {
        if (sum == K) {
            // 답을 만족하는 경우 이 이후로 탐색할 필요가 없음
            ans++;
        } else {
            for (int i = start; i < N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    solve(i, sum + arr[i]);
                    visited[i] = false;
                }
            }
        }
    }
}
