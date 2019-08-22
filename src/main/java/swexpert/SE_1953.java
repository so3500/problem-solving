/*
 * 문제: 1953 [삼성 모의 SW 역량테스트] 탈주범 검거 / 166 ms
 * link: https://www.acmicpc.net/problem/11933
 * 알고리즘: BFS
 * 풀이방법:
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   입력 N일 때 2차원 배열을 모두 탐색하는 경우
 *   각 elm 을 탐색하는 경우 소요되는 시간은 상수이므로
 *   O(N^2)
 *
 * 공간복잡도(Space Complexity)
 *   입력 N일 때 2차원 배열 사용
 *   O(N^2)
 *
 * */

package swexpert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SE_1953 {

    static class Point {
        int row, col, time;

        public Point(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    static int[][] map;
    static boolean[][] visited;
    static int N, M, R, C, L, ans;
    static Queue<Point> q = new LinkedList<>();
    static int[][] checkList = {{-1, -1, -1},
            {3, 4, 7},
            {3, 5, 6},
            {2, 6, 7},
            {2, 4, 5}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t, i, row, col;
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            N = sc.nextInt(); // 세로
            M = sc.nextInt(); // 가로
            R = sc.nextInt(); // 맨홀 뚜껑 세로 위치
            C = sc.nextInt(); // 맨홀 뚜껑 가로 위치
            L = sc.nextInt(); // 탈출 후 소요시간
            map = new int[N][M];
            visited = new boolean[N][M];
            for (row = 0; row < N; row++) {
                for (col = 0; col < M; col++) {
                    map[row][col] = sc.nextInt();
                }
            }
            ans = 0;
            q.clear();
            bfs();
            System.out.println("#" + t + " " + ans);
        }
    }

    static void bfs() {
        q.add(new Point(R, C, L - 1));
        ans++;
        visited[R][C] = true;
        int row, col, time;
        while (!q.isEmpty()) {
            Point p = q.poll();
            row = p.row;
            col = p.col;
            time = p.time;
            if (time == 0) break; // 시간 부족으로 더 이상 갈 수 있는 터널이 아닐 경우

            // 각 터널애 대해서 그 방향에 따라 다른 터널로의 이동 여부를 검사
            // check 1: 3, 4, 7 못감
            // check 2: 3, 5, 6 못감
            // check 3: 2, 6, 7 못감
            // check 4: 2, 4, 5 못감
            switch (map[row][col]) {
                case 1:
                    connectRoute(row - 1, col, time, 1);
                    connectRoute(row, col + 1, time, 4);
                    connectRoute(row + 1, col, time, 2);
                    connectRoute(row, col - 1, time, 3);
                    break;
                case 2:
                    connectRoute(row - 1, col, time, 1); // 3 4 7 / 1
                    connectRoute(row + 1, col, time, 2); // 3 5 6 / 2
                    break;
                case 3:
                    connectRoute(row, col - 1, time, 3); // 2 6 7 / 3
                    connectRoute(row, col + 1, time, 4); // 2 4 5 / 4
                    break;
                case 4:
                    connectRoute(row - 1, col, time, 1); // 3 4 7 / 1
                    connectRoute(row, col + 1, time, 4); // 2 4 5 /4
                    break;
                case 5:
                    connectRoute(row, col + 1, time, 4); // 2 4 5 /4
                    connectRoute(row + 1, col, time, 2); // 3 5 6 /2
                    break;
                case 6:
                    connectRoute(row + 1, col, time, 2); // 3 5 6 / 2
                    connectRoute(row, col - 1, time, 3); // 2 6 7 /3
                    break;
                case 7:
                    connectRoute(row - 1, col, time, 1); // 3, 4, 7 / 1
                    connectRoute(row, col - 1, time, 3); // 2, 6, 7 / 3
                    break;
            }
        }
    }

    static void connectRoute(int row, int col, int time, int check) {
        // 해당 row, col 이 범위가 유효한지, 이미 방문하지 않았는지 여부를 조사
        if (row < 0 || N <= row || col < 0 || M <= col || visited[row][col] || map[row][col] == 0) return;
        // 갈 수 없는 터널인지 여부 검사
        for (int i = 0; i < 3; i++) {
            if (map[row][col] == checkList[check][i]) return;
        }
        // 큐에 추가
        q.add(new Point(row, col, time - 1));
        ans++;
        visited[row][col] = true;
        L--;
    }
}