/*
 * 문제: 2806. N-Queen / 141 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GKs06AU0DFAXB
 * 알고리즘: 완전탐색
 * 풀이방법:
 *      row 에서 퀸을 놓고 setVisited 연산 수행
 *      row 에 퀸을 놓았으므로 row+1 의 col: 0 to N-1 탐색
 *      마지막 row 까지 오고 퀸을 놓았다면 ans++
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *
 * 공간복잡도(Space Complexity)
 *
 * */

package swexpert;

import java.util.Arrays;
import java.util.Scanner;

public class SE_2806 {
    static final int SIZE = 10;
    static int[][] visited = new int[SIZE][SIZE];
    static int N, ans;
    static int[] R = new int[4];
    static int[] C = new int[4];
    static int[] rows = {-1, -1, 1, 1};
    static int[] cols = {-1, 1, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t, row, col, i;
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            N = sc.nextInt();
            ans = 0;
            for (i = 0; i < N; i++) Arrays.fill(visited[i], 0);
            solve(0, 0, 0);
            System.out.println("#" + t + " " + ans);
        }
    }

    public static void solve(int row, int col, int cnt) {
        if (cnt == N) ans++;
        else if (N <= row) return;
        else {
            for (int c = 0; c < N; c++) {
                if (visited[row][c] == 0) {
                    // 각 행에는 1개의 퀸만 놓을 수 있으므로 퀸을 놓은다음에는 다음 행으로 간다.
                    setVisited(row, c, 1);
                    solve(row + 1, c, cnt + 1);
                    setVisited(row, c, -1);
                }
            }
        }
    }

    public static void setVisited(int row, int col, int flag) {
        Arrays.fill(R, row);
        Arrays.fill(C, col);
        visited[row][col] -= flag; // 중복 연산 제거
        for (int i = 0; i < N; i++) {
            visited[i][col] += flag;
            visited[row][i] += flag;
            // 대각선 처리
            for (int j = 0; j < 4; j++) {
                R[j] += rows[j];
                C[j] += cols[j];
                if (0 <= R[j] && R[j] < N && 0 <= C[j] && C[j] < N) {
                    visited[R[j]][C[j]] += flag;
                }
            }
        }
    }
}
