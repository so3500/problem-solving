/*
 * 문제: 7576 토마토 / 1460 ms
 * link: https://www.acmicpc.net/problem/7576
 * 알고리즘: BFS
 * 풀이방법:
 * 	익지 않은 토마토가 0개 일때까지 BFS를 수행한다.
 * 	만약 그 전에 BFS가 끝난다면 모든 토마토가 익지 않았다는 뜻이므로 -1을 출력한다.
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

public class Boj_7576 {

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int N, M, tomatoCnt, minCnt, startRow, startCol;
    static int[][] map;
    static int[] rows = {-1, 0, 1, 0}, cols = {0, 1, 0, -1};
    static Queue<Point> q;

    public static void main(String[] args) {
        init();
        solve(); // BFS
        System.out.println(minCnt);
    }

    static void init() {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[N][M];
        tomatoCnt = 0;
        q = new LinkedList<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                map[r][c] = sc.nextInt();
                if (map[r][c] == 0) {
                    tomatoCnt++;
                } else if (map[r][c] == 1) { // 탐색을 시작할 지점을 큐에 추가
                    q.add(new Point(r, c, 0));
                }
            }
        }
        minCnt = -1;
        sc.close();
    }

    static void solve() {
        Point p;
        int toR, toC;
        while (!q.isEmpty()) {
            p = q.remove();

            if (tomatoCnt == 0) {
                minCnt = p.cnt;
            }

            // 새롭게 익을 토마토 영역을 구함
            // 해당영역을 토마토 익음 상태(1)로 변경, 남은 토마토 수 차감, 큐에 추가
            for (int i = 0; i <= 3; i++) {
                toR = p.r + rows[i];
                toC = p.c + cols[i];
                if (toR < 0 || toC < 0 || N <= toR || M <= toC || map[toR][toC] != 0)
                    continue;
                q.add(new Point(toR, toC, p.cnt + 1));
                map[toR][toC] = 1;
                tomatoCnt--;
            }

        }
    }
}
