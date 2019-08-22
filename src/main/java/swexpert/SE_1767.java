/*
 * 문제: 1767 [SW Test 샘플문제] 프로세서 연결하기 / 147 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV4suNtaXFEDFAUf
 * 알고리즘: DFS
 * 풀이방법:
 *      탐색 방향이 다른 코어에 의해 모두 막힌 코어(제약 사항 3번에 대한 처리), 가장 자리에 위치한 코어
 *      를 제외한 코어를 탐색 리스트에 추가한다.
 *          이 탐색 리스트에 위치한 모든 코어에 전원이 연결 되었을 때
 *              사용한 전선의 길이 합 중 최소값을 구한다.
 *
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   입력 N일 때
 *   N개의 코어 당 2N번의 탐색 수행
 *   + 완전탐색 O(?)
 *
 *   최소 O(N^2)
 *
 * 공간복잡도(Space Complexity)
 *   입력 N일 때 2차원 배열 사용
 *   O(N^2)
 *
 * */


package swexpert;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SE_1767 {

    static class Core {
        int row, col;

        public Core(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int N, ans, numOfCore, maxCore;
    static int[][] map;
    static int[] rows = {-1, 0, 1, 0};
    static int[] cols = {0, 1, 0, -1};
    static List<Core> coreList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t, i, row, col, rowTo, colTo;

        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            N = sc.nextInt();
            numOfCore = 0;
            map = new int[N][N];
            coreList.clear();
            for (row = 0; row < N; row++) {
                for (col = 0; col < N; col++) {
                    map[row][col] = sc.nextInt();
                }
            }
            // 해당 core 가 다른 core 에 둘러싸여 있는지 체크
            int find;
            for (row = 1; row < N - 1; row++) {
                for (col = 1; col < N - 1; col++) {
                    if (map[row][col] == 1) {
                        find = 0;
                        for (int dir = 0; dir < 4; dir++) {
                            rowTo = row + rows[dir];
                            colTo = col + cols[dir];
                            find += dfs(rowTo, colTo, dir);
                        }
                        // 다른 core 에 둘러싸여 있지 않으며, 가장자리에 위치하지 않은 core 만 탐색 리스트에 추가
                        if (find < 4) {
                            numOfCore++;
                            coreList.add(new Core(row, col));
                        }
                    }
                }
            }
            ans = Integer.MAX_VALUE;
            maxCore = 0;
            // solve
            row = coreList.get(0).row;
            col = coreList.get(0).col;
            for (int dir = 0; dir < 4; dir++) {
                rowTo = row + rows[dir];
                colTo = col + cols[dir];
                solve(rowTo, colTo, dir, 0, 1);
            }
            System.out.println("#" + t + " " + ans);
        }
    }

    static void solve(int row, int col, int direction, int lenOfLine, int core) {
        if (row < 0 || N <= row || col < 0 || N <= col) { // 하나의 코어에 대해 전선을 연결한 경우(가장자리 도착)
            if (core == numOfCore) {
//                if (ans > lenOfLine) print();
                ans = Integer.min(ans, lenOfLine);
            }
            // 탐색할 코어가 남았을 때
            else if (core < numOfCore) {
                // 다음에 탐색할 코어 꺼내고, 4방향 분기
                Core c = coreList.get(core);
                for (int dir = 0; dir < 4; dir++) {
                    solve(c.row + rows[dir], c.col + cols[dir], dir, lenOfLine, core + 1);

                }
            }
        } else if (map[row][col] != 1 && map[row][col] != -1) { // 하나의 코어에 대해 전선을 이어나가는 작업
            // 다른 코어, 이미 연결된 전선이 없을 때만 작업
            map[row][col] = -1;
            int rowTo = row + rows[direction];
            int colTo = col + cols[direction];
            solve(rowTo, colTo, direction, lenOfLine + 1, core);
            map[row][col] = 0;
        }
    }

    static int dfs(int row, int col, int direction) {
        if (row < 0 || N <= row || col < 0 || N <= col) return 0;
        if (map[row][col] == 1 || map[row][col] == -1) return 1;

        int find = 0;
        switch (direction) {
            case 0:
                find = dfs(row - 1, col, 0);
                break;
            case 1:
                find = dfs(row, col + 1, 1);
                break;
            case 2:
                find = dfs(row + 1, col, 2);
                break;
            case 3:
                find = dfs(row, col - 1, 3);
                break;
        }
        return find;
    }

    static void print() {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (map[row][col] != -1) System.out.print(" " + map[row][col] + " ");
                else System.out.print(map[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println("========");
    }
}
