/*
 * 문제: 5585 거스름돈 / 116 ms
 * link: https://www.acmicpc.net/problem/5585
 * 알고리즘: 그리디
 * 풀이방법:
 * 	잔돈이 주어질 때 해당 잔돈을 500, 100, 50, 10, 5, 1엔 순으로 나눈다
 * 	이 방법은 가장 적은 잔돈의 개수를 구하는 것을 보장한다.
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *
 * 공간복잡도(Space Complexity)
 *
 * */

package boj;

import java.util.Scanner;

public class Boj_5585 {

    static int[] coin = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money, changeCnt;
        money = 1000 - sc.nextInt();
        changeCnt = 0;
        for (int i = 0; i < 6; i++) {
            changeCnt += (money / coin[i]);
            money %= coin[i];
        }
        System.out.println(changeCnt);
        sc.close();
    }
}
