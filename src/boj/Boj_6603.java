/*
 * 문제: 로또 / 164 ms
 * link: https://www.acmicpc.net/problem/6603
 * 알고리즘: dfs, combination
 * 풀이방법:
 *
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *
 *
 * 공간복잡도(Space Complexity)
 *
 *
 * */

package boj;

import java.util.Scanner;

public class Boj_6603 {

    static int[] S = new int[13];
    static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        while (k != 0) {
            for (int i = 0; i < k; i++) S[i] = sc.nextInt();
            solve(0, 0, new StringBuilder());
            System.out.println();
            k = sc.nextInt();
        }
    }

    static void solve(int depth, int idx, StringBuilder sb) {
        if (depth == 6) {
            System.out.println(sb);
            return;
        }
        for (int i = idx; i < k; i++) {
            StringBuilder newSb = new StringBuilder();
            newSb.append(sb).append(S[i]).append(" ");
            solve(depth + 1, i + 1, newSb);
        }
    }
}
