package boj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SalesPersion_2098 {
    private static int minCost;
    private static int[][] W;
    private static int[][] dp;
    private static int N;

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = null;

        int N, depth, cost, start, end, target, i;
        boolean[] visited = null;

        // 입력 및 초기화
        N = Integer.parseInt(br.readLine());
        W = new int[N + 1][N + 1];
        dp = new int[N + 1][1 << N];
        for (start = 1; start <= N; start++) {
            Arrays.fill(dp[start], -1);
            st = new StringTokenizer(br.readLine());
            for (end = 1; end <= N; end++) {
                W[start][end] = Integer.parseInt(st.nextToken());
            }
        }
        depth = N;
        start = 1;
        minCost = TSP(start, 1);

        System.out.println(minCost);
    }

    private static int TSP(int start, int visited) {
        int ret = Integer.MAX_VALUE;
        if (visited == (1 << N) - 1) {
            ret = W[start][1];
        } else if (dp[start][visited] >= 0) {
            ret = dp[start][visited];
        } else {
            for (int target = 1; target <= N; target++) {
                if ((visited & (1 << (target - 1))) != 0) {
                    continue;
                } else if (W[start][target] == 0) {
                    continue;
                }
                int temp = W[start][target] + TSP(target, visited + (1 << (target - 1)));
                ret = Math.min(ret, temp);
            }
            dp[start][visited] = ret;
        }
        return ret;
    }
}
