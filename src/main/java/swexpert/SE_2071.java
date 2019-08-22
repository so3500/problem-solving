package swexpert;

import java.util.Scanner;

public class SE_2071 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, sum, i, j, input, avr;
        T = sc.nextInt();
        for (i = 1; i <= T; i++) {
            sum = 0;
            for (j = 0; j < 10; j++) {
                input = sc.nextInt();
                sum += input;
            }
            avr = (int) Math.round(sum / 10.0);
            System.out.println("#" + i + " " + avr);
        }
    }
}
