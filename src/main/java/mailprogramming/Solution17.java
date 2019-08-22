/*
 0과 1로 만들어진 2D 정수 배열이 있습니다. 
 0은 장애물이고 1은 도로일때, 두 좌표가 주어지면, 첫번째 좌표에서 두번째 좌표까지 가장 가까운 거리를 구하시오. 
 두 좌표는 모두 도로에서 시작되고 좌, 우, 아래, 위로 움직이며 대각선으로는 움직일 수 없습니다. 
 만약 갈 수 없다면 -1을 리턴하시오.

예제)
Input:
{{1, 0, 0, 1, 1, 0},
{1, 0, 0, 1, 0, 0},
{1, 1, 1, 1, 0, 0},
{1, 0, 0, 0, 0, 1},
{1, 1, 1, 1, 1, 1}}
Start: (0, 0)
Finish: (0, 4)
Output: 8

bfs
#1 8
#2 9
#3 -1
dfs
#1 1
#2 1
#3 -1

3
5 6
1 0 0 1 1 0
1 0 0 1 0 0
1 1 1 1 0 0
1 0 0 0 0 1
1 1 1 1 1 1
0 0 0 4
5 6
1 0 0 1 1 0
1 0 0 1 0 0
1 1 1 1 0 0
1 0 0 0 0 1
1 1 1 1 1 1
0 0 4 5
5 6
1 0 0 1 1 0
1 0 0 1 0 0
1 1 1 1 0 0
1 0 0 0 0 1
1 1 1 1 1 1
0 0 0 5
 * */

package mailprogramming;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution17 {

    private static boolean[][] map, visited;
    private static boolean enable;
    private static int[] rows = {-1, 0, 1, 0}, cols = {0, 1, 0, -1};
    private static int N, M, fromRow, fromCol, toRow, toCol, minDist;

    static class Point {
        int row, col, dist;

        public Point(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t;
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            init(sc);
            // bfs();
            dfs(fromRow, fromCol);
            System.out.println("#" + t + " " + minDist);
        }
        sc.close();
    }

    private static void init(Scanner sc) {
        int row, col;
        N = sc.nextInt();
        M = sc.nextInt();
        map = new boolean[N][M];
        visited = new boolean[N][M];
        for (row = 0; row < N; row++) {
            for (col = 0; col < M; col++) {
                if (sc.nextInt() == 1) {
                    map[row][col] = true;
                } else {
                    map[row][col] = false;
                }
            }
        }
        minDist = -1;
        fromRow = sc.nextInt();
        fromCol = sc.nextInt();
        toRow = sc.nextInt();
        toCol = sc.nextInt();
    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(fromRow, fromCol, 0));
        int toR, toC;
        while (!q.isEmpty()) {
            Point p = q.poll();
            visited[p.row][p.col] = true;
            if (p.row == toRow && p.col == toCol) {
                q.clear();
                minDist = p.dist;
            } else {
                for (int i = 0; i < 4; i++) {
                    toR = p.row + rows[i];
                    toC = p.col + cols[i];
                    if (toR < 0 || toC < 0 || N <= toR || M <= toC || visited[toR][toC] || !map[toR][toC]) {
                        continue;
                    }
                    q.add(new Point(toR, toC, p.dist + 1));
                }
            }
        }
    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;
        if (r == toRow && c == toCol) {
            minDist = 1;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int toR, toC;
            toR = r + rows[i];
            toC = c + cols[i];
            if (toR < 0 || toC < 0 || N <= toR || M <= toC || visited[toR][toC] || !map[toR][toC]) {
                continue;
            }
            dfs(toR, toC);
        }

    }

}
