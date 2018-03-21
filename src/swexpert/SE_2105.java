/*
 * 문제: 2105. [모의 SW 역량테스트] 디저트 카페 / 174 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5VwAr6APYDFAWu
 * 알고리즘: DFS, 완전탐색
 * 풀이방법:
 *  우하: dir 0, 좌하: dir 1, 좌상: dir 2, 우상: dir 4
 *  2차원 배열의 각 시작점에서 dfs 시작
 *      현재 위치가 map의 범위를 벗어나거나 && 이미 방문하면 return
 *      현재 위치가 startRow 보다 작으면 return (직사각형 마무리가 안되는 예외 처리)
 *      현재 위치 방문 처리
 *      각 점에서 가던방향, 가던방향+1 만큼만 탐색을 진행(직사각형이 안그려지는 예외처리)
 *      현재 위치 방문 처리취소
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   입력 N일 때 2차원 배열의 각 점에서 탐색을 시작하므로 N^2
 *   각 점에서 직사각형의 최대 대각선의 길이만큼 탐색하므로 N
 *   O(N^3)
 *
 * 공간복잡도(Space Complexity)
 *   입력 N일 때 2차원 배열 사용
 *   O(N^2)
 *
 * */

package swexpert;

import java.util.Scanner;

public class SE_2105 {
    static int[][] map;
    static boolean[] visited;
    static int N, startRow, startCol, maxLen;
    static int[] rows = {1, 1, -1, -1};
    static int[] cols = {1, -1, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t, i, col, row;
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            N = sc.nextInt();
            map = new int[N][N];
            visited = new boolean[101];
            for (row = 0; row < N; row++) {
                for (col = 0; col < N; col++) {
                    map[row][col] = sc.nextInt();
                }
            }
            // solve
            maxLen = -1;
            for (row = 0; row < N - 2; row++) {
                for (col = 1; col < N - 1; col++) {
                    startRow=row;
                    startCol=col;
                    solve(row, col, 0, 0);
                }
            }
            System.out.println("#" + t + " " + maxLen);
        }
    }

    static void solve(int row, int col, int len, int dir) {
        if (row < 0 || N <= row || col < 0 || N <= col) return;
        if (row < startRow) return;
        if (row == startRow && col == startCol && len > 0) {
            maxLen = Integer.max(len, maxLen);
            return;
        }
        if (visited[map[row][col]]) return;

        visited[map[row][col]] = true;
        // 원래 가던 방향, 그 다음 방향으로만 진행할 수 있도록 함
        for (int x = dir; x <= dir + 1 && x < 4; x++) {
            solve(row + rows[x], col + cols[x], len + 1, x);
        }
        visited[map[row][col]] = false;

    }
}
