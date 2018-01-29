package boj;

import java.util.Scanner;

public class Resignation_14501 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        int N, day, nextDay;
        int[] T, P, DP;

        N = sc.nextInt();
        T = new int[N];
        P = new int[N];
        DP = new int[N + 1];
        DP[N] = 0;

        for (day = 0; day < N; day++) {
            T[day] = sc.nextInt();
            P[day] = sc.nextInt();
        }

        // DP[day]: day 에서 시작하여 얻을 수 있는 최대 이익
        for (day = N - 1; day >= 0; day--) {
            nextDay = day + T[day];
            if (nextDay > N) {
                DP[day] = DP[day + 1];
            } else {
                DP[day] = Integer.max(DP[day + 1], DP[nextDay] + P[day]);
            }
        }
        System.out.println(DP[0]);
    }
}
