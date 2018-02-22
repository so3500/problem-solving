/*
 * 문제: 14503 로봇청소기 / 80 ms
 * link: https://www.acmicpc.net/problem/14503
 * 알고리즘: DFS
 * 풀이방법:
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   입력 N일 때 2차원 배열을 모두 탐색하는 경우
 *   O(N^2)
 *
 * 공간복잡도(Space Complexity)
 *   입력 N일 때 2차원 배열 사용
 *   O(N^2)
 *
 * */

package boj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Boj_14503 {

    static int N, M, r, c, d, cnt;
    static int[][] map;
    static int[] rows = {-1, 0, 1, 0};
    static int[] cols = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input;
        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        d = Integer.parseInt(input[2]);
        for (int row = 0; row < N; row++) {
            input = br.readLine().split(" ");
            for (int col = 0; col < M; col++) {
                map[row][col] = Integer.parseInt(input[col]);
            }
        }
        cnt = 0;
        dfs(r, c, d);
        System.out.println(cnt);
    }

    static void dfs(int row, int col, int direction) {
        int noPath = 0;
        int toRow, toCol;
        if (map[row][col] == 0) {
            map[row][col] = -1; // 청소
            cnt++;
        }

        for (int i = direction + 3; i > direction - 1; i--) {
            // 왼쪽 방향
            toRow = row + rows[i % 4];
            toCol = col + cols[i % 4];
            if (0 <= toRow && toRow < N && 0 <= toCol && toCol < M && map[toRow][toCol] == 0) {
                dfs(toRow, toCol, i % 4);
                break;
            } else {
                noPath++;
            }
        }

        if (noPath == 4) {
            // 뒤로 한칸
            toRow = row - rows[direction];
            toCol = col - cols[direction];
            // 뒤 칸이 범위 안이고, 벽이 아닐경우 뒤로 후진
            if (0 <= toRow && toRow < N && 0 <= toCol && toCol < M && map[toRow][toCol] != 1) {
                dfs(toRow, toCol, direction);
            }

        }
    }
}

