/*
 * 문제: 3307 최장 증가 부분 수열 / 167 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBOKg-a6l0DFAWr
 * 알고리즘: DP
 * 풀이방법:
 *      dp[i]: arr index 0 부터 i 까지일때 최장 증가 부분 수열의 길이
 *      index i 일때 0 ~ i-1 에 있는 최장 증가 부분 수열의 길이 중 최대값+1 을 dp[i]에 저장한다.
 *      그리고 이 중 최대값을 출력한다.
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   입력 N일 때 1차원 배열을 모두 탐색하는 경우
 *   i: 0 -> N-1
 *      j: 0 -> i-1
 *   이므로 연산은 1+2+3+...+N 과같이 증가
 *   총 시간복잡도는 O(N^2)
 *
 * 공간복잡도(Space Complexity)
 *   입력 N일 때 1차원 배열 사용
 *   O(N)
 *
 * */

package swexpert;

import java.util.Scanner;

public class SE_3307 {

    static int N, K;
    static int[] arr, dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, i, t, j, k, len;
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            N = sc.nextInt();
            arr = new int[N];
            dp = new int[N];
            for (i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            K = 0;
            // dp[i]: arr 에서 index 0 부터 i 까지일때 최장 증가 부분 수열의 길이
            for (j = 0; j < N; j++) {
                len = 1;
                for (k = 0; k < j; k++) {
                    if (arr[k] <= arr[j]) {
                        len = Integer.max(len, dp[k] + 1);
                    }
                }
                dp[j] = len;
                K = Integer.max(K, dp[j]);
            }
            System.out.println("#" + t + " " + K);
        }
    }
}
