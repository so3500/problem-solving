/*
 * 문제: 1937 욕심쟁이 판다 / 1020 ms
 * link: https://www.acmicpc.net/problem/1937
 * 알고리즘: DP + DFS
 * 풀이방법:
 * 	DP[row][col]: (row, col)에서 시작해서 갈 수 있는 최대 거리
 * 	DFS 만 사용할 경우에는 중복연산이 일어나기 때문에 O(N^4)의 시간복잡도를 가지고 있다.
 * 	DP와 DFS를 같이 사용하면 O(N^2)의 시간복잡도를 가진다.
 * 	row: 0 to N-1
 * 		col: 0 to N-1
 * 			dfs를 수행
 *
 * 	할 때 최악의 경우 N^2에 해당하는 길이를 탐색했다고 가정하면, dfs를 수행하면서 각 (row, col)에서
 * 	출발하여 갈 수 있는 최대 거리가 계산되어 있기 때문이다.
 * 	따라서 그 이후에 남은 N^2-1개의 연산은 모두 상수시간안에 해결할 수 있다.
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   입력 N일 때 2차원 배열을 모두 탐색하는 경우
 *   O(N^2)
 *
 * 공간복잡도(Space Complexity)
 *   입력 N일 때 2차원 배열을 사용하는 경우
 *   O(N^2)
 *
 * */

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1937 {

    static int N, K, MAX_VALUE;
    static int[][] map, DP;
    static int[] rows = {-1, 0, 1, 0};
    static int[] cols = {0, 1, 0, -1};

    public static void main(String[] args) {
        init();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                K = Integer.max(K, dfs(r, c));
            }
        }
        System.out.println(K);
    }

    static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        DP = new int[N][N];
        MAX_VALUE = 3000000;
        for (int r = 0; r < N; r++) {
            Arrays.fill(DP[r], MAX_VALUE);
            for (int c = 0; c < N; c++) {
                map[r][c] = sc.nextInt();
            }
        }
        K = Integer.MIN_VALUE;
        sc.close();
    }

    static int dfs(int r, int c) {
        int toR, toC;

        // (r, c)에서 시작하여 갈 수 있는 최대 거리 정보가 있을 때 해당 값 리턴
        if (DP[r][c] != MAX_VALUE) {
            return DP[r][c];
        }

        // 최대 거리 정보가 아직 없을 때 해당 정보 갱신하기
        DP[r][c] = 1;
        for (int i = 0; i < 4; i++) {
            toR = r + rows[i];
            toC = c + cols[i];
            if (toR < 0 || toC < 0 || N <= toR || N <= toC || map[r][c] >= map[toR][toC])
                continue;
            DP[r][c] = Integer.max(DP[r][c], 1 + dfs(toR, toC));
        }
        return DP[r][c];
    }
}
