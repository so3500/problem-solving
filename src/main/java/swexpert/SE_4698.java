/*
 * 문제: 4698 테네스의 특별한 소수
 * link: https://www.swexpertacademy.com/main/talk/codeBattle/problemDetail.do?contestProbId=AWRuoqCKkE0DFAXt&categoryId=AWRiniKqTU0DFAXt&categoryType=BATTLE
 * 알고리즘: 에라토스테네스의 체, 구현
 * 풀이방법:
 *	에라토스테네스의 체 알고리즘을 통해 10^6까지의 소수를 구한다.
 *	A, B 사이의 숫자 중 D를 포함하는 수의 개수를 구한 뒤 출력한다.
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *
 * 공간복잡도(Space Complexity)
 */

package swexpert;

import java.util.Scanner;

public class SE_4698 {

    private static boolean[] isNotPrime;
    private static int A, B, D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t, ans;
        getPrime();
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            init(sc);
            ans = solve(A, B, D);
            System.out.println("#" + t + " " + ans);
        }
        sc.close();
    }

    private static void getPrime() {
        isNotPrime = new boolean[1000001];
        isNotPrime[1] = true;
        int num = 2;
        while (num <= 1000000) {
            if (isNotPrime[num]) {
                num++;
                continue;
            }
            for (int i = num * 2; i <= 1000000; i += num) {
                isNotPrime[i] = true;
            }
            num++;
        }
    }

    private static void init(Scanner sc) {
        D = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
    }

    private static int solve(int A, int B, int D) {
        int ret = 0;
        for (int i = A; i <= B; i++) {
            int num = i;
            if (isNotPrime[num]) {
                continue;
            }
            while (num > 0) {
                if (num % 10 == D) {
                    ret++;
                    break;
                }
                num /= 10;
            }
        }
        return ret;
    }
}
