package swexpert;

import java.util.Scanner;

public class SE_4674 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t, n, ans;
        long[] factorial = new long[21];
        int[] zeroEvenCnt = new int[21];
        setCache(factorial, zeroEvenCnt);
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            n = sc.nextInt();
            ans = zeroEvenCnt[n];
            System.out.println("#" + t + " " + ans);
        }

        sc.close();
    }

    private static void setCache(long[] factorial, int[] zeroEvenCnt) {
        long sum = 1;
        factorial[0] = sum;
        zeroEvenCnt[0] = 0;
        for (int i = 1; i <= 20; i++) {
            sum *= i;
            zeroEvenCnt[i] = getEvenCnt(sum);
        }
    }

    private static int getEvenCnt(long num) {
        int cnt = 0;
        long tempNum = num;
        while (tempNum > 0) {
            if (tempNum % 10 == 0) {
                cnt++;
            }
            tempNum /= 10;
        }
        return cnt;
    }

}
