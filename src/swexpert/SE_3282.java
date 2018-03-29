/*
 * 문제: 3282. 0/1 Knapsack / 143 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBJAVpqrzQDFAWr
 * 알고리즘: 다이나믹 프로그래밍
 * 풀이방법:
 *      완전탐색으로 풀 수 있는 문제인데 N의 크기가 클 경우 아래와 같이 다이나믹 프로그래밍 방법을 사용한다.
 *      주석참고
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   입력 N, K일 때 N*K 크기의 2차원 배열을 모두 탐색하는 경우
 *   O(NK)
 *
 * 공간복잡도(Space Complexity)
 *   입력 N, K일때 N*K 크기의 2차원 배열 사용
 *   O(NK)
 *
 * */
package swexpert;

import java.util.Scanner;

public class SE_3282 {
    static int N, K, maxVal;
    static int[][] DP;
    static int[] volume, cost;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t;
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            init(sc);
            solve();
            System.out.println("#" + t + " " + maxVal);
        }
    }

    private static void init(Scanner sc) {
        N = sc.nextInt();
        K = sc.nextInt();
        volume = new int[N];
        cost = new int[N];
        DP = new int[N][K + 1];
        for (int j = 0; j < N; j++) {
            volume[j] = sc.nextInt(); // V 부피
            cost[j] = sc.nextInt(); // C 가치
        }
        maxVal = Integer.MIN_VALUE;
    }

    private static void solve() {
        for (int k = 1; k <= K; k++) {
            if (volume[0] <= k) DP[0][k] = cost[0];
            else DP[0][k] = 0;
        }
        for (int n = 1; n < N; n++) {
            for (int k = 1; k <= K; k++) {
                // DP[n][k]: 1~n번째 물건중에서 가방의 부피가 k일때 취할 수 있는 최대 가치
                // 가방의 부피가 k이고, n번째 물건을 추가할 수 있으면
                // DP[n][k] = max(n번째 물건을 추가할 때, n번째 물건을 추가하지 않을 때) 값을 구한다.
                // n번째 물건을 추가할 때: n번째 물건의 가치 + k-n번째 물건의 부피 중에서 n-1번째까지 구한 것 중 최대가치
                // n번째 물건을 추가하지 않을 때: 부피 k일때 n-1번째 까지 구한것 중 최대가치
                if (volume[n] <= k) {
                    DP[n][k] = Integer.max(cost[n] + DP[n - 1][k - volume[n]], DP[n - 1][k]);
                } else {
                    DP[n][k] = DP[n - 1][k];
                }
            }
        }
        maxVal = DP[N - 1][K];
    }
}
