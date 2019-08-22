package swexpert;

import java.util.Scanner;

//public class Solution {
public class SE_2072 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T, sum, input;
        T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            sum = 0;
            for (int j = 0; j < 10; j++) {
                input = sc.nextInt();
                if (input % 2 == 1) sum += input;
            }
            System.out.println("#" + i + " " + sum);
        }
    }
}
