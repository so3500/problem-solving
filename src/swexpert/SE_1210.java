/*
 * 문제: 1210 Ladder1 / 264 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh&categoryId=AV14ABYKADACFAYh&categoryType=CODE
 * 알고리즘: DFS
 * 풀이방법:
 *      시작점을 X로 하고 X의 좌표(row, col)을 구한다.
 *      X에서 DFS를 시작한다.
 *      DFS는 좌, 우 -> 위 순서로 탐색한다.
 *      row = 0 으로 도달하면 그때 col 값이 정답
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *
 * 공간복잡도(Space Complexity)
 *   입력에 상관없이 일정한 크기의 2차원 배열 사용
 *   O(1)
 *
 * */

package swexpert;

import java.util.Scanner;

public class SE_1210 {

    static int[][] map = new int[100][102];
    static int endRow, endCol, startRow, startCol;
    static int[] rows = {0, 0, -1};
    static int[] cols = {-1, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t;
        startRow = 99;
        for (t = 1; t <= 10; t++) {
            T = sc.nextInt();
            init(sc);
            solve(startRow, startCol);
            System.out.println("#" + t + " " + endCol);
        }
        sc.close();
    }

    private static void init(Scanner sc) {
        for (int row = 0; row < 100; row++) {
            for (int col = 1; col <= 100; col++) {
                map[row][col] = sc.nextInt();
            }
        }
        // 출발할 지점(X) 의 col 값
        for (int col = 1; col <= 100; col++) {
            if (map[startRow][col] == 2) {
                startCol = col;
            }
        }
    }

    private static void solve(int row, int col) {
        if (row == 0) {
            endCol = col - 1;
        } else {
            for (int i = 0; i < 2; i++) {
                if (map[row][col + cols[i]] != 0) {
                    map[row - 1][col] = 0; // 이미 방향을 꺾었으므로 위로 가지 않도록 체크
                    map[row][col] = 0;     // 해당 점을 다시 방문하지 않도록 체크
                    solve(row, col + cols[i]);
                }
            }
            // 좌우에 길이 없고 위에 길이 있으면 위로진행
            if (map[row - 1][col] != 0) {
                map[row][col] = 0;
                solve(row - 1, col);
            }
        }
    }
}
