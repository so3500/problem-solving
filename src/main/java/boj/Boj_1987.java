/*
 * 문제: 1987 알파벳 / 860 ms
 * link: https://www.acmicpc.net/problem/1987
 * 알고리즘: DFS
 * 풀이방법:
 * 	보드에서 알파벳 정보를 나타내는 map, 알파벳 방문여부를 나타내는 visited 배열 이용
 * 	(0, 0)에서 시작하여 상, 하, 좌, 우로 dfs 수행
 * 	dfs 수행 시 이미 지난 알파벳은 제외
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *
 * 공간복잡도(Space Complexity)
 *
 * */

package boj;

import java.util.Scanner;

public class Boj_1987 {

    static int R, C, maxLen;
    static int[][] map;
    static boolean[] visited;
    static int[] rows = {-1, 0, 1, 0};
    static int[] cols = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        init(sc);
        dfs(0, 0, 1);
        System.out.println(maxLen);
    }

    static void init(Scanner sc) {
        String input;
        R = sc.nextInt();
        C = sc.nextInt();
        map = new int[R][C];
        visited = new boolean[26]; // A:0, B:1, ... Z:25
        for (int r = 0; r < R; r++) {
            input = sc.next();
            for (int c = 0; c < C; c++) {
                map[r][c] = input.charAt(c) - 'A';
            }
        }
        maxLen = Integer.MIN_VALUE;
    }

    static void dfs(int r, int c, int len) {
        int toR, toC;
        maxLen = Integer.max(maxLen, len);
        visited[map[r][c]] = true;
        for (int i = 0; i < 4; i++) {
            toR = r + rows[i];
            toC = c + cols[i];
            // 유효 범위를 초과하거나 이미 방문한 알파벳인 경우 continue
            if (toR < 0 || toC < 0 || R <= toR || C <= toC || visited[map[toR][toC]]) continue;
            dfs(toR, toC, len + 1);
        }
        visited[map[r][c]] = false;
    }
}
