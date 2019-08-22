package swexpert;

import java.util.Scanner;

public class SE_3142 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t, N, M, twin, uni;
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            N = sc.nextInt();
            M = sc.nextInt();
            uni = M;
            twin = 0;
            while (true) {
                if (twin + uni == M && 2 * twin + uni == N) break;
                uni--;
                twin++;
            }

            System.out.println("#" + t + " " + uni + " " + twin);
        }
        sc.close();
    }

}
