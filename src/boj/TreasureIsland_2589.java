/*
 * 문제: 2589 보물섬 / 80 ms
 * link: https://www.acmicpc.net/problem/2589
 * 알고리즘: BFS
 * 풀이방법:
 *  (0,0) to (L-1, W-1) 에서 'L'인 점에 한해서 DFS 시작.
 *      각 dfs가 끝날 때 time 갱신(time: 각 dfs 에서 이동한 가장 긴 거리)
 *  모든 dfs가 끝날 때 maxTime 갱신
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
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
import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland_2589 {

    static int L, W, maxTime;
    static char[][] map, cMap;
    static Queue<Point> Q, Queue;
    static int[] rows = {-1, 0, 1, 0};
    static int[] cols = {0, 1, 0, -1};

    static class Point {
        int row, col, cnt;

        Point(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public int getCnt() {
            return cnt;
        }
    }

    public static void main(String args[]) throws Exception {
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        input = br.readLine().split(" ");
        Q = new LinkedList<>();
        Queue = new LinkedList<>();
        L = Integer.parseInt(input[0]);
        W = Integer.parseInt(input[1]);
        map = new char[L][W];
        cMap = new char[L][W];
        for (int row = 0; row < L; row++) {
            input = br.readLine().split(" ");
            for (int col = 0; col < W; col++) {
                map[row][col] = input[0].charAt(col);
                cMap[row][col] = map[row][col];
            }
        }

        maxTime = 0;
        solve();
        System.out.println(maxTime);
    }

    static void solve() {
        for (int row = 0; row < L; row++) {
            for (int col = 0; col < W; col++) {
                if (map[row][col] == 'L') {
                    Q.add(new Point(row, col, 0));
                    bfs(); // 탐험을 시작할 지점을 찾는 bfs
                    Q.clear();
                }
            }
        }
        copyMap();
        bfs2(); // bfs()에서 구한 지점에서 시작하는 bfs
    }

    static void bfs() {
        int row, col, cnt, toRow, toCol;
        row = 0;
        col = 0;
        while (!Q.isEmpty()) {
            Point p = Q.poll();
            row = p.getRow();
            col = p.getCol();
            cnt = p.getCnt();
            map[row][col] = 'W';

            for (int i = 0; i < 4; i++) {
                toRow = row + rows[i];
                toCol = col + cols[i];
                if (0 <= toRow && toRow < L && 0 <= toCol && toCol < W && map[toRow][toCol] == 'L') {
                    Q.add(new Point(toRow, toCol, cnt + 1));
                }
            }
        }
        Queue.add(new Point(row, col, 0));
    }

    static void bfs2(){
        int row, col, cnt, toRow, toCol, time;
        time = 0;
        row = 0;
        col = 0;
        while (!Queue.isEmpty()) {
            Point p = Queue.poll();
            row = p.getRow();
            col = p.getCol();
            cnt = p.getCnt();
            map[row][col] = 'W';
            time = cnt;

            for (int i = 0; i < 4; i++) {
                toRow = row + rows[i];
                toCol = col + cols[i];
                if (0 <= toRow && toRow < L && 0 <= toCol && toCol < W && map[toRow][toCol] == 'L') {
                    Queue.add(new Point(toRow, toCol, cnt + 1));
                }
            }
        }
        maxTime = Integer.max(maxTime, time);
    }

    static void copyMap() {
        for (int row = 0; row < L; row++) {
            for (int col = 0; col < W; col++) {
                map[row][col] = cMap[row][col];
            }
        }
    }
}
