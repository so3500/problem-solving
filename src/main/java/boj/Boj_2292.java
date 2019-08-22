package boj;// https://www.acmicpc.net/problem/2292
// 벌집

import java.util.Scanner;

public class Boj_2292 {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int k = 1;
        while (N > 1) {
            N -= 6 * k;
            k += 1;
        }
        System.out.println(k);
    }
}
