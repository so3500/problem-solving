/*
 * 10974 모든 순열 752ms
 * 수학
 * https://www.acmicpc.net/problem/10974
 *
 * */

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_10974 {

    static int N;
    static int[] S;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = new int[10];
        visited = new boolean[10];
        Arrays.fill(visited, false);

        // 사전순으로 순열 생성
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            permOrder(i, 1);
            visited[i] = false;
        }
    }

    static void permOrder(int num, int depth) {
        S[depth] = num;
        if (depth == N) {
            print();
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permOrder(i, depth + 1);
                visited[i] = false;
            }
        }
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(S[i]).append(" ");
        }
        System.out.println(sb);
    }
}
