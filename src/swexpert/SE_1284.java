/*
 * 문제: 1284 수도 요금 경쟁 / 92 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV189xUaI8UCFAZN
 * 알고리즘: 구현
 * 풀이방법:
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   입력과 상관없이
 *   O(1)
 *
 * 공간복잡도(Space Complexity)
 *   입력과 상관없이
 *   O(1)
 *
 * */

package swexpert;

import java.util.Scanner;

public class SE_1284 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t, P, Q, R, S, W, price;
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            P = sc.nextInt();
            Q = sc.nextInt();
            R = sc.nextInt();
            S = sc.nextInt();
            W = sc.nextInt();
            price = P * W;
            if (W >= R) price = Integer.min(price, Q + (W - R) * S);
            else price = Integer.min(price, Q);
            System.out.println("#" + t + " " + price);
        }
    }
}
