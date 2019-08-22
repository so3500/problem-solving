package swexpert;

import java.util.Scanner;

public class SE_2070 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, i, a, b;
        String op;
        T = sc.nextInt();
        for (i = 1; i <= T; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            if (a > b) op = ">";
            else if (a == b) op = "=";
            else op = "<";
            System.out.println("#" + i + " " + op);
        }
    }
}
