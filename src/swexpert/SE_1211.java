/*
 * 문제: 1211 Ladder2 / 248 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14BgD6AEECFAYh&categoryId=AV14BgD6AEECFAYh&categoryType=CODE
 * 알고리즘: DFS
 * 풀이방법:
 *      모든 시작점을 구한다.
 *      시작점에서 DFS를 시작한다.
 *      DFS는 좌, 우 -> 위 순서로 탐색한다.
 *      row = 0 으로 도달했을 때 최소이동 거리를 만족하는 X값을 갱신한다. (같은 최소 이동거리일 경우 X중 최대값으로 갱신)
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

public class SE_1211 {

    static int[][] map = new int[100][102];
    static int endRow, endCol, startRow, startCol, minDist;
    static int[] cols = {-1, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t;
        startRow = 99;
        for (t = 1; t <= 10; t++) {
            T = sc.nextInt();
            init(sc);
            for (int col = 1; col <= 100; col++) {
                if (map[99][col] == 1) {
                    solve(99, col, 0);
                }
            }
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
        minDist = Integer.MAX_VALUE;
        endCol = Integer.MIN_VALUE;
    }

    private static void solve(int row, int col, int dist) {
        if (row == 0) {
            if (minDist > dist) {
                endCol = col - 1; // 최단거리 나올 때 X값(중 가장 큰 값)
                minDist = dist; // 최단거리 갱신
            } else if (minDist == dist) { // 같은 길이의 최단거리 일 경우 큰 X값
                endCol = Integer.max(endCol, col);
            }
        } else {
            boolean up = true;
            for (int i = 0; i < 2; i++) {
                if (map[row][col + cols[i]] == 1) {
                    up = false;
                    map[row][col] = 0;     // 해당 점을 다시 방문하지 않도록 체크
                    solve(row, col + cols[i], dist + 1);
                    map[row][col] = 1;
                }
            }
            // 좌우에 길이 없고 위에 길이 있으면 위로진행
            if (up && map[row - 1][col] == 1) {
                map[row][col] = 0;
                solve(row - 1, col, dist + 1);
                map[row][col] = 1;
            }
        }
    }
}
