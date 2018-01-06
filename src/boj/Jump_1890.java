/*
* 문제: 1890 점프 88MS
* link: https://www.acmicpc.net/problem/1890
* 알고리즘: 다이나믹 프로그래밍
* 풀이방법:
*   dp[row][col]: (row, col) 칸으로 올 수 있는 경로의 개수라 하고
*   row, col 가 0 to N-1 으로 가면서 경로를 구한다.
*
*
* 의사코드(Pseudo Code)
*   input N
*   init dp[N][N]
*   init board[N][N] with N*N numbers
*
*   for row: 0 to N-1
*       for col: 0 to N-1
*           dist <- board[row][col]
*           if no path to (row, col) or dist is 0:
*               continue
*           if row + dist available
*               dp[row+dist][col] <- dp[row+dist][col] + dp[row][col]
*           if col + dist available
*               dp[row][col+dist] <- dp[row][col+dist] + dp[row][col]
*
* 시간복잡도(Time Complexity)
*   2차원 배열을 모두 순회, 각 순회 시 dp값 갱신은 상수
*   O(N^2)
*
* 공간복잡도(Space Complexity)
*   2차원 배열 사용
*   O(N^2)
*
* */

package boj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Jump_1890 {

    private static void print(int[][] matrix){
        StringBuffer sb = new StringBuffer();
        for (int row=0; row<matrix.length; row++){
            for (int col=0; col<matrix.length; col++){
                sb.append(matrix[row][col] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N, row, col, dist;
        long[][] dp;
        int[][] board;

        N = Integer.parseInt(br.readLine());
        dp = new long[N][N];
        board = new int[N][N];

        for (row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[row], 0);
            for (col = 0; col < N; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for (row = 0; row < N; row++) {
            for (col = 0; col < N; col++) {
                dist = board[row][col];
                // 현재(row, col)까지 올 수 있는 경로의 수가 없거나, 점프 값이 0일 경우는 계산하지 않는다.
                if (dp[row][col] == 0 || dist == 0){
                    continue;
                }
                // 갈 수 있는 곳에, 현재(row, col)까지 올 수 있는 경로의 수를 더함
                if (row + dist < N) {
                    dp[row + dist][col] += dp[row][col];
                }
                if (col + dist < N) {
                    dp[row][col + dist] += dp[row][col];
                }
            }
        }
        System.out.println(dp[N - 1][N - 1]);
    }
}
