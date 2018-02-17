package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Knignt_7562 {
    static Queue<Point> q;
    static int currentRow, currentCol, cnt, toRow, toCol;


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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase, I, row, col, i;
        int[][] map = new int[300][300];
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
            q.add(p);
            bfs();
        }
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Point p = q.poll();
            currentRow = p.getRow();
            currentCol = p.getCol();
            cnt = p.getCnt();
            if (currentRow == toRow && currentCol == toCol){
                break;
            }
            

        }
    }
}
