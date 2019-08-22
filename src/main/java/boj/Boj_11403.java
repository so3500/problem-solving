package boj;/*
 * https://www.acmicpc.net/problem/11403
 * 경로 찾기: 가중치 없는 방향 그래프 G가 주어졌을 때, 모든 정점(i, j)에 대해서, i에서 j로 가는 경로 여부 구하기
 * */

import java.util.Scanner;

public class Boj_11403 {

//    private static Scanner scanner;

    private static void printG(int[][] G) {
        for (int row = 0; row < G.length; row++) {
            for (int col = 0; col < G.length; col++) {
                System.out.print(G[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void solve(int[][] G) {
        /*
         * 플로이드 워셜 알고리즘
         * 각 v의 모든 path 구하기
         * 클로져
         * */
        for (int mid = 0; mid < G.length; mid++) {
            for (int start = 0; start < G.length; start++) {
                for (int end = 0; end < G.length; end++) {
                    // start -> mid 로 가는 것 중에서
                    // mid -> end 로 가는 것을
                    if (G[start][mid] == 1 && G[mid][end] == 1) {
                        // start -> end 로 가도록 이어준다
                        G[start][end] = 1;
                    }
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
//        File f = new File("input.txt");
//        scanner = new Scanner(f);
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] G = new int[N][N];
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                G[row][col] = scanner.nextInt();
            }
        }
        solve(G);
        printG(G);
    }
}
