/*
 * 문제: 3805 사탕게임
 * link: https://www.acmicpc.net/problem/3805
 * 알고리즘: 브루트포스
 * 풀이방법:
 *
 */

package boj;

import java.util.Scanner;

class Solution {

    char[][] map;
    int N;
    int maxCandy;
    int[] rows = {-1, 0, 1, 0};
    int[] cols = {0, 1, 0, -1};

    void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];
        for (int r = 0; r < N; r++) {
            String input = sc.next();
            for (int c = 0; c < N; c++) {
                map[r][c] = input.charAt(c);
            }
        }
        sc.close();
    }

    void solve() {
        maxCandy = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                changeAndFind(row, col);
            }
        }
        System.out.println(maxCandy);
    }

    // 인접한 나머지 한칸을 고른 뒤, swap 한 후 최대 사탕개수 구하기
    void changeAndFind(int fromRow, int fromCol) {
        for (int dir = 0; dir < 4; dir++) {
            int toRow = rows[dir] + fromRow;
            int toCol = cols[dir] + fromCol;
            if (isValid(toRow, toCol)) {
                swap(fromRow, fromCol, toRow, toCol);
                findMaxCandy(fromRow, fromCol, toRow, toCol);
                swap(toRow, toCol, fromRow, fromCol);
            }
        }
    }

    boolean isValid(int row, int col) {
        if (row >= 0 && col >= 0 && row < N && col < N) {
            return true;
        } else {
            return false;
        }
    }

    void swap(int fromRow, int fromCol, int toRow, int toCol) {
        char tmp = map[fromRow][fromCol];
        map[fromRow][fromCol] = map[toRow][toCol];
        map[toRow][toCol] = tmp;
    }

    // 변화가 일어난 row, col에 한해서 최대 사탕개수 구하기
    void findMaxCandy(int rowA, int colA, int rowB, int colB) {
        findMaxCandyInRow(colA);
        findMaxCandyInRow(colB);
        findMaxCandyInCol(rowA);
        findMaxCandyInCol(rowB);
    }

    void findMaxCandyInRow(int col) {
        int candyCnt = 1;
        char candy = map[0][col];
        for (int row = 1; row < N; row++) {
            if (candy == map[row][col]) {
                candyCnt++;
            } else {
                maxCandy = Integer.max(maxCandy, candyCnt);
                candyCnt = 1;
                candy = map[row][col];
            }
        }
        maxCandy = Integer.max(maxCandy, candyCnt);
    }

    void findMaxCandyInCol(int row) {
        int candyCnt = 1;
        char candy = map[row][0];
        for (int col = 1; col < N; col++) {
            if (candy == map[row][col]) {
                candyCnt++;
            } else {
                maxCandy = Integer.max(maxCandy, candyCnt);
                candyCnt = 1;
                candy = map[row][col];
            }
        }
        maxCandy = Integer.max(maxCandy, candyCnt);
    }

}

public class BOJ_3805 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.init();
        solution.solve();
    }

}
