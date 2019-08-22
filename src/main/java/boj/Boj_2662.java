/*
 * 문제: 2662 기업투자 / 236 ms
 * link: https://www.acmicpc.net/problem/2662
 * 알고리즘: DP, tracking?
 * 풀이방법:
 *  최대금액 구하기
 *      DP[money][comNo]: money 원을 가지고 comNo 까지 투자했을 때 최대 수익
 *      comNo-1 까지 0 투자 + comNo 에 money 투자
 *      comNo-1 까지 1 투자 + comNo 에 money-1 투자
 *      ...
 *      comNo-1 까지 k 투자 + comNo 에 money-k 투자
 *
 *  회사 당 투자금액 구하기
 *      추적, 어려움, skip
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   입력 N일 때 2차원 배열을 채우는 연산, 총 3중 반복문
 *   O(N^3)
 *
 * 공간복잡도(Space Complexity)
 *   입력 N일 때 2차원 배열 사용
 *   O(N^2)
 *
 * */

package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj_2662 {


    static int[][] track = new int[301][21];
    static int[][] DP = new int[301][21];
    static int[][] M = new int[301][21];
    static int allInput, numOfCom;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new File("input.txt"));
        allInput = sc.nextInt();
        numOfCom = sc.nextInt();
        for (int money = 1; money <= allInput; money++) { // input: 투자금액
            sc.nextInt();
            for (int comNo = 1; comNo <= numOfCom; comNo++) { // comNo: 회사 번호
                M[money][comNo] = sc.nextInt(); // 각 회사마다 투자금액에 따른 수익
            }
        }
        solve();
        sc.close();
    }

    static void solve() {
        int max, no;
        for (int comNo = 1; comNo <= numOfCom; comNo++) {
            for (int money = 1; money <= allInput; money++) {
                max = Integer.MIN_VALUE;
                no = 0;
                for (int k = 0; k <= money; k++) {
                    // comNo-1 까지 k 투자 + comNo 에 money-k 투자
                    if (DP[k][comNo - 1] + M[money - k][comNo] > max) {
                        max = DP[k][comNo - 1] + M[money - k][comNo];
                        no = money - k;
                    }
                }
                DP[money][comNo] = max;
                track[money][comNo] = no;
            }

        }

        // 최대 금액
        System.out.println(DP[allInput][numOfCom]);

        // 각 회사당 투자 금액
        List<Integer> list = new ArrayList<>();
        int b = allInput;
        for (int i = numOfCom; i >= 1; i--) {
            list.add(track[b][i]);
            b -= track[b][i];
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}