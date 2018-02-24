/*
* D3 3456 직사각형 길이 찾기 / 147ms
* 구현
* */

package swexpert;

import java.util.Scanner;

public class SE_3456 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, a, b, c, ans;
        T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            ans = 0;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            if (a == b && b == c) ans = a;
            else if (a == b && b != c) ans = c;
            else if (a != b && b == c) ans = a;
            else if (a == c && b != c) ans = b;
            System.out.println("#" + i + " " + ans);
        }
    }
}
