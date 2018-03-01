/*
 * 문제: 9205 맥주마시면서 걸어가기 / 428ms
 * link: https://www.acmicpc.net/problem/9205
 * 알고리즘: dfs, 플로이드 워셜
 * 풀이방법:
 *  플로이드 워셜 알고리즘을 두번 수행한다.
 *  첫번째 플로이드 워셜
 *      문제의 조건(1000 맨하탄 거리 이하)를 만족하는 점끼리 이어준다
 *  두번째 플로이드 워셜
 *      첫번째 플로이드 워셜 이후, 일반적인 플로이드 워셜 알고리즘 수행
 *
 *  두번째가 필요한 이유는 문제의 조건(1000 맨하탄 거리 이하)이 충족되지 않는 경우
 *  해당되는 두 점이 이어지지 않기 때문
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   플로이드-워셜 반복문 3번 수행
 *   O(N^3)
 *
 * 공간복잡도(Space Complexity)
 *   2차원 배열 사용
 *   O(N^2)
 *
 * */

package boj;

import java.util.Scanner;

public class Boj_9205 {

    static class Point {
        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static boolean[][] map;
    static Point[] point;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t, i, row, col;

        T = sc.nextInt();

        for (t = 0; t < T; t++) {
            n = sc.nextInt();
            point = new Point[n + 2];
            map = new boolean[n + 2][n + 2];
            for (i = 0; i < n + 2; i++) {
                col = sc.nextInt();
                row = sc.nextInt();
                point[i] = new Point(row, col);
            }

            for (int mid = 0; mid < n + 2; mid++) {
                for (int start = 0; start < n + 2; start++) {
                    for (int end = 0; end < n + 2; end++) {
                        if (Math.abs(point[start].col - point[mid].col) + Math.abs(point[start].row - point[mid].row) <= 1000 &&
                                Math.abs(point[mid].col - point[end].col) + Math.abs(point[mid].row - point[end].row) <= 1000) {
                            map[start][end] = true;
                        }
                    }
                }
            }

            for (int mid = 0; mid < n + 2; mid++) {
                for (int start = 0; start < n + 2; start++) {
                    for (int end = 0; end < n + 2; end++) {
                        if (map[start][mid] && map[mid][end]) {
                            map[start][end] = true;
                        }

                    }
                }
            }

            // point[0]: 집, point[n+1]: 락페
            if (map[0][n + 1]) System.out.println("happy");
            else System.out.println("sad");
        }
    }
}

// dfs, 완전탐색 => 시간초과
//package boj;
//
//        import java.util.Scanner;
//
//public class Boj_9205 {
//
//    static class Point {
//        int row, col;
//
//        public Point(int row, int col) {
//            this.row = row;
//            this.col = col;
//        }
//    }
//
//    static Point[] store;
//    static boolean[] visited;
//    static Point start, end;
//    static int n;
//    static boolean success;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T, t, i, row, col;
//
//        T = sc.nextInt();
//
//        for (t = 0; t < T; t++) {
//            n = sc.nextInt();
//            store = new Point[n];
//            visited = new boolean[n];
//            col = sc.nextInt();
//            row = sc.nextInt();
//            start = new Point(row, col); // home
//            for (i = 0; i < n; i++) {
//                col = sc.nextInt();
//                row = sc.nextInt();
//                store[i] = new Point(row, col); // store
//            }
//            col = sc.nextInt();
//            row = sc.nextInt();
//            end = new Point(row, col); // rock
//
//            success = false;
//            // 집에서 바로 갈 수 있는 경우
//            if ((Math.abs(start.row - end.row) + Math.abs(start.col - end.col)) <= 1000) {
//                success = true;
//            } else {
//                // 집에서 바로 갈 수 없는 경우(편의점 경유)
//                for (i = 0; i < n; i++) {
//                    // 집에서 갈 수 있는 편의점에서 출발
//                    if ((Math.abs(start.row - store[i].row)) + (Math.abs((start.col) - store[i].col)) <= 1000) {
//                        visited[i] = true;
//                        solve(0, i, store[i]);
//                        visited[i] = false;
//                    }
//                }
//            }
//            if (success) System.out.println("happy");
//            else System.out.println("sad");
//        }
//    }
//
//    static void solve(int depth, int idx, Point p) {
//        if (depth > n || success) return;
//        int row = p.row;
//        int col = p.col;
//
//        // 편의점에서 락페 도달 여부 검사
//        if (Math.abs(row - end.row) + Math.abs(col - end.col) <= 1000) {
//            success = true;
//        }
//
//        for (int i = 0; i < n; i++) {
//            // 이미 들린 편의점이 아니며 && 편의점에서 다른 편의점으로 거리상 갈 수 있는지 검사
//            if (!visited[i] && (Math.abs(row - store[i].row) + Math.abs(col - store[i].col)) <= 1000) {
//                visited[i] = true;
//                solve(depth + 1, i, store[i]);
//                visited[i] = false;
//            }
//        }
//    }
//}