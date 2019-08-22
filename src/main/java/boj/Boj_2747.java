/*
 * 문제: 2747 피보나치 수 104ms
 * link: https://www.acmicpc.net/problem/2747
 * 알고리즘: DP
 * 풀이방법:
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *  메모이제이션: O(N)
 *  일반적인 재귀로 풀 경우: O(2^N)
 *
 * 공간복잡도(Space Complexity)
 *  배열
 *  O(N)
 *
 * */

package boj;

import java.util.Scanner;

public class Boj_2747 {

    static int[] DP;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, ans;
        N = sc.nextInt();
        DP = new int[N + 1];
//        Arrays.fill(DP, -1);
        DP[0] = 1;
        DP[1] = 1;
        ans = fib(N);
        System.out.println(ans);
    }

    static int fib(int n) {
        if (n < 2) return n;
        if (DP[n] != 0) return DP[n];
        DP[n] = fib(n - 1) + fib(n - 2);
        return DP[n];
    }
}
