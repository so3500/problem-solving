/*
 * 문제: 4014. [모의 SW 역량테스트] 활주로 건설 / 149 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeW7FakkUDFAVH
 * 알고리즘: 구현
 * 풀이방법:
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *
 * 공간복잡도(Space Complexity)
 *
 * */

package swexpert;

import java.util.Scanner;

public class SE_4014 {

    static int[][] map;
    static int N, X;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t, i, r, c, ans;
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            init(sc);
            ans = 0;
            for (i = 0; i < N; i++) {
                ans += dfs(i, 0, 1);
            }
            for (i = 0; i < N; i++) {
                ans += dfs(0, i, 2);
            }
            System.out.println("#" + t + " " + ans);
        }
        sc.close();
    }

    private static void init(Scanner sc) {
        N = sc.nextInt();
        X = sc.nextInt();
        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] = sc.nextInt();
            }
        }
    }

    private static int dfs(int r, int c, int direction) {
        int row, col, len, left, right, down, up, exSlopeIdx;
        boolean enable = true;
        len = 1;
        exSlopeIdx = -1;
        // 오른쪽, 밑으로 진행할 때 마지막으로 사용한 경사로 위치 갱신
        // 위, 왼쪽으로 탐색해야 할 경우 마지막으로 사용한 경사로와 겹침 여부 확인
        if (direction == 1) { // 가로 방향 탐색
            for (col = 0; col < N - 1; col++) {
                left = map[r][col];
                right = map[r][col + 1];
                if (left < right) { // 낮은쪽이 left 일 때
                    // 확보된 경사로의 길이가 충분하지 않은 경우
                    // 경사로를 놓았을 때 배열의 범위를 초과하는 경우
                    // 높이 차가 1 초과인 경우
                    // 경사로가 다른 경사로와 겹치는 경우
                    // 리턴
                    if (len < X || (col + 1 - len < 0) || (right - left) > 1 || (col + 1 - len) < exSlopeIdx) {
                        enable = false;
                        break;
                    }
                    len = 1;
                } else if (left > right) { // 낮은쪽이 right 일 때
                    len = getLength(r, col, direction);
                    if (len < X || (N < col + 1 + len) || (left - right) > 1) {
                        enable = false;
                        break;
                    }
                    exSlopeIdx = col + X; // 마지막으로 사용한 경사로의 위치
                    col += len - 1;
                    len -= X; // 확보한 길이에서 X길이 만큼 경사로 사용
                } else {
                    len++;
                }

            }
        } else if (direction == 2) { // 세로 방향 탐색
            for (row = 0; row < N - 1; row++) {
                down = map[row][c];
                up = map[row + 1][c];
                if (down < up) { // 낮은 쪽이 down 일 때
                    if (len < X || (row + 1 - len < 0) || (up - down) > 1 || (row + 1 - len) < exSlopeIdx) {
                        enable = false;
                        break;
                    }
                    len = 1;
                } else if (down > up) { // 낮은 쪽이 up 일 때
                    len = getLength(row, c, direction);
                    if (len < X || (N < len + row + 1) || (down - up) > 1) {
                        enable = false;
                        break;
                    }
                    exSlopeIdx = row + X;
                    row += len - 1;
                    len -= X;
                } else {
                    len++;
                }
            }
        }
        if (enable) return 1;
        else return 0;
    }

    private static int getLength(int r, int c, int direction) {
        int len, idx;
        len = 1;
        if (direction == 1) {
            idx = c + 1;
            while (idx < N - 1) {
                if (map[r][idx] == map[r][idx + 1]) {
                    len++;
                    idx++;
                } else {
                    break;
                }
            }
        } else if (direction == 2) {
            idx = r + 1;
            while (idx < N - 1) {
                if (map[idx][c] == map[idx + 1][c]) {
                    len++;
                    idx++;
                } else {
                    break;
                }
            }
        }
        return len;
    }
}
