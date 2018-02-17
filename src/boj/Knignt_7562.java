/*
 * 문제: 7562 나이트의 이동 / 316 ms
 * link: https://www.acmicpc.net/problem/7562
 * 알고리즘: BFS
 * 풀이방법:
 *   큐에 시작 점 객체 (row, col, cnt:1) 추가
 *   bfs 함수에서 큐에 하나도 남지 않을 때 까지 '시작 점에서 갈 수 있는 점' 추가
 *       '시작 점에서 갈 수 있는 점'의 조건: 배열 범위 내, 이미 지나가지 않은 점
 *       새 점 추가 시 이전 점 cnt+1 값을 초기값으로 줌.
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

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Knignt_7562 {
    static Queue<Point> q;
    static int currentRow, currentCol, toRow, toCol, ans, I;
    static boolean[][] map;

    private static class Point {
        int row;
        int col;
        int cnt;

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

    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("input.txt"));

        int testCase, i, cnt;
        map = new boolean[301][301];
        q = new LinkedList<>();

        testCase = sc.nextInt();
        for (i = 0; i < testCase; i++) {
            I = sc.nextInt();
            currentRow = sc.nextInt();
            currentCol = sc.nextInt();
            toRow = sc.nextInt();
            toCol = sc.nextInt();
            cnt = 0;
            Point p = new Point(currentRow, currentCol, cnt);
            map[currentRow][currentCol] = true;
            q.add(p);
            ans = 0;
            bfs();
            q.clear();
            initMap();
            System.out.println(ans);
        }
    }

    static void initMap() {
        for (int i = 0; i < I; i++) {
            Arrays.fill(map[i], false);
        }
    }

    private static void bfs() {
        int row, col, cnt, targetRow, targetCol;
        int[] rows = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] cols = {-1, 1, -2, 2, -2, 2, -1, 1};
        while (!q.isEmpty()) {
            Point p = q.poll();
            row = p.getRow();
            col = p.getCol();
            cnt = p.getCnt();
            if (row == toRow && col == toCol) {
                ans = cnt;
                break;
            }

            for (int i = 0; i < 8; i++) {
                targetRow = row + rows[i];
                targetCol = col + cols[i];
                if (0 <= targetRow && targetRow < I
                        && 0 <= targetCol && targetCol < I
                        && !map[targetRow][targetCol]) {
                    map[targetRow][targetCol] = true;
                    q.add(new Point(targetRow, targetCol, cnt + 1));
                }
            }
        }
    }
}
