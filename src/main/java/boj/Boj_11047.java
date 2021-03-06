package boj;// 동전0

import java.util.Scanner;
import java.util.Stack;

;

public class Boj_11047 {

    private static int solve(int[] coin, int N, int K) {
        int cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (coin[i] <= K) {
                cnt += (K / coin[i]);
                K %= coin[i];
            }
        }
        return cnt;
    }

    Stack<Integer> d = new Stack<Integer>();

    public static void main(String args[]) throws Exception {
//        File f = new File("input.txt");
//        Scanner scanner = new Scanner(f);
        Scanner scanner = new Scanner(System.in);
        int N, K;
        int[] coin = null;
        N = scanner.nextInt();
        K = scanner.nextInt();
        coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = scanner.nextInt();
        }
        System.out.println(solve(coin, N, K));

    }
}
