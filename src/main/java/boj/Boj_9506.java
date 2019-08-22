package boj;

import java.util.Scanner;

public class Boj_9506 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String answer;
        while (n != -1) {
            answer = solve(n);
            System.out.println(answer);
            n = sc.nextInt();
        }
        sc.close();
    }

    private static String solve(int n) {
        int sum, i;
        StringBuilder answer = new StringBuilder();
        answer.append(n).append(" = 1");
        sum = 1;
        for (i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
                answer.append(" + ").append(i);
            }
        }

        if (sum == n) {
            return answer.toString();
        } else {
            return n + " is NOT perfect.";
        }
    }

}
