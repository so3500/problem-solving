/*
 * 문제: 1226. 1227 [S/W 문제해결 기본] 7일차 - 미로1,2 / 105 ms, 142ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14wL9KAGkCFAYD
 * 알고리즘: DFS
 * 풀이방법:
 *      간단한 dfs 문제
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *      입력에 따른 시간복잡도의 변화가 없음. 배열 크기 일정
 *      O(1)
 *
 * 공간복잡도(Space Complexity)
 *      입력에 따른 사용메모리 변화가 없음
 *      O(1)
 *
 * */

package swexpert;

import java.util.Scanner;

public class SE_1226 {

    static int rowFrom, colFrom, rowTo, colTo, ans, N;
    static char[][] map;
    static int[] rows = {-1, 0, 1, 0};
    static int[] cols = {0, 1, 0, -1};
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        N = 100;
        for (int t = 1; t <= 10; t++) {
            input();
            ans = 0;
            dfs(rowFrom, colFrom);
            System.out.println("#" + t + " " + ans);
        }
        sc.close();
    }

    static void input() {
        sc.nextLine();
        map = new char[N][N];
        map = new char[N][N];
        String input;
        for (int row = 0; row < N; row++) {
            input = sc.nextLine();
            for (int col = 0; col < N; col++) {
                map[row][col] = input.charAt(col);
                if (map[row][col] == '2') {
                    rowFrom = row;
                    colFrom = col;
                } else if (map[row][col] == '3') {
                    rowTo = row;
                    colTo = col;
                }
            }
        }
    }

    static void dfs(int row, int col) {
        if (row == rowTo && col == colTo) {
            ans = 1;
        } else if (map[row][col] != '1') {
            int rTo, cTo;
            for (int i = 0; i < 4; i++) {
                rTo = row + rows[i];
                cTo = col + cols[i];
                map[row][col] = '1';
                dfs(rTo, cTo);
            }
        }
    }
}
