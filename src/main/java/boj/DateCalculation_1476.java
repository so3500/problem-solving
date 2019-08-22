/*
 * 문제: 1476 날짜계산 / 100ms
 * link: https://www.acmicpc.net/problem/1476
 * 알고리즘: 구현, 수학, 완전 탐색
 * 풀이방법:
 *
 * 의사코드(Pseudo Code)
 *   input E, S, M
 *   init cnt, e, s, m with 1
 *   while
 *      counting until E=e, S=s, M=m
 *      cnt++
 *
 * 시간복잡도(Time Complexity)
 *
 * 공간복잡도(Space Complexity)
 *   자료구조를 사용하지 않음. O(1)
 *
 * */

package boj;

import java.util.Scanner;

public class DateCalculation_1476 {

    static int E, S, M, cnt, e, s, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        E = sc.nextInt();
        S = sc.nextInt();
        M = sc.nextInt();

        e = 1;
        s = 1;
        m = 1;
        cnt = 1;

        while (E != e || S != s || M != m) {
            e = (e % 15) + 1;
            s = (s % 28) + 1;
            m = (m % 19) + 1;
            cnt++;
        }

        System.out.println(cnt);
    }
}
