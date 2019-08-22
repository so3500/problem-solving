/*
 * 문제: 2819 격자판의 숫자 이어 붙이기 / 481 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7I5fgqEogDFAXB
 * 알고리즘: 완전탐색, DFS
 * 풀이방법:
 *      map 의 각 (r,c)에서 solve 함수 시작
 *      solve 함수는 현재 위치에서 북, 동, 남, 서 순서로 dfs를 진행하는 함수이며
 *      진행할 때마다 sum 값을 더하고, len 값이 1씩 줄어듬
 *      len이 0일 때 완성된 sum을 check 배열에 방문처리(check 배열 대신 HashSet을 사용할 수도 있다.)
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *
 * 공간복잡도(Space Complexity)
 *   입력에 상관없이 항상 일정한 크기의 배열 사용
 *   O(1)
 *
 * */

package swexpert;

import java.util.Arrays;
import java.util.Scanner;

public class SE_2819 {

    static final int SIZE = 10000000;
    static boolean[] check = new boolean[SIZE];
    static int[][] map = new int[4][4];
    static int[] rows = {-1, 0, 1, 0};
    static int[] cols = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t, r, c, i, cnt;
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            for (r = 0; r < 4; r++) {
                for (c = 0; c < 4; c++) {
                    map[r][c] = sc.nextInt();
                }
            }
            Arrays.fill(check, false);
            for (r = 0; r < 4; r++) {
                for (c = 0; c < 4; c++) {
                    solve(r, c, 7, 0);
                }
            }
            cnt = 0;
            for (i = 0; i < SIZE; i++) {
                if (check[i]) cnt++;
            }
            System.out.println("#" + t + " " + cnt);
        }
    }

    private static void solve(int r, int c, int len, int sum) {
        if (r < 0 || 4 <= r || c < 0 || 4 <= c) return;

        if (len == 0) {
            check[sum] = true;
        } else {
            for (int i = 0; i < 4; i++) {
                solve(r + rows[i], c + cols[i],
                        len - 1, sum + map[r][c] * (int) Math.pow(10, len - 1));
            }
        }
    }
}
