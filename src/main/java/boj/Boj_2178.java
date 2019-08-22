/*
 * 문제: 2178 미로탐색 / 152 ms
 * link: https://www.acmicpc.net/problem/2178
 * 알고리즘: BFS
 * 풀이방법:
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *
 * 공간복잡도(Space Complexity)
 * */

package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_2178 {

    static class Point {
        int r, c, moveCnt;

        public Point(int r, int c, int moveCnt) {
            this.r = r;
            this.c = c;
            this.moveCnt = moveCnt;
        }
    }

    static int N, M, minMoveCnt;
    static boolean[][] map;
    static int[] rows = {-1, 0, 1, 0}, cols = {0, 1, 0, -1};

    public static void main(String[] args) {
        init();
        solve(); // bfs
        System.out.println(minMoveCnt);
    }

    static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new boolean[N][M];
        String input;
        int r, c, i;
        for (r = 0; r < N; r++) {
            input = sc.next();
            for (c = 0; c < M; c++) {
                if (input.charAt(c) == '1') {
                    map[r][c] = true;
                } else {
                    map[r][c] = false;
                }
            }
        }
        sc.close();
    }

    static void solve() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1));
        map[0][0] = false;
        int toR, toC;
        Point p;
        while (!q.isEmpty()) {
            p = q.remove();

            if (p.r == N - 1 && p.c == M - 1) {
                minMoveCnt = p.moveCnt;
                break;
            }

            for (int i = 0; i <= 3; i++) {
                toR = p.r + rows[i];
                toC = p.c + cols[i];
                if (toR < 0 || toC < 0 || N <= toR || M <= toC || !map[toR][toC])
                    continue;
                q.add(new Point(toR, toC, p.moveCnt + 1));
                map[toR][toC] = false;
            }
        }
    }

}
