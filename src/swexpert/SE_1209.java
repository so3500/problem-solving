/*
 * 문제: 1209. [S/W 문제해결 기본] 2일차 - Sum / 239 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13_BWKACUCFAYh
 * 알고리즘: 구현
 * 풀이방법:
 *   일반적으로 2차원 배열에 데이터를 저장하고 row, col, 대각선 별로 탐색을 하는 방법이 있다.
 *   혹은, 입력을 받으면서 각 row, col, 대각선 별로 합을 구할 수도 있다.
 *   각 행의 합은 입력을 받으면서 rowSum 변수 하나로 구할 수 있다.
 *   각 열의 합은 각 행의 값을 저장할 1차원 배열 하나를 선언하여 입력값을 더한다.
 *   대각선은 행, 열의 조건을 충족할 때마다 cross1, cross2 변수에 입력값을 더한다.
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   입력의 범위는 항상 일정하므로
 *   O(1)
 *
 * 공간복잡도(Space Complexity)
 *   입력의 범위는 항상 일정하므로
 *   O(1)
 *
 *
 * */

package swexpert;

import java.util.Arrays;
import java.util.Scanner;

public class SE_1209 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t, rowSum, row, col, maxSum, cross1, cross2, input;
        int[] colSum = new int[100];
        for (T = 1; T <= 10; T++) {
            t = sc.nextInt();
            for (row = 0; row < 100; row++) {
                Arrays.fill(colSum, 0);
            }
            maxSum = 0;
            cross1 = 0;
            cross2 = 0;
            for (row = 0; row < 100; row++) {
                rowSum=0;
                for (col = 0; col < 100; col++) {
                    input = sc.nextInt();
                    if (row == col) cross1 += input;
                    if (row + col == 99) cross2 += input;
                    rowSum += input;
                    colSum[col] += input;
                }
                maxSum = Integer.max(maxSum, rowSum);
            }
            maxSum=Integer.max(maxSum, cross1);
            maxSum=Integer.max(maxSum, cross2);
            for (col=0; col<100; col++) {
                maxSum = Integer.max(maxSum, colSum[col]);
            }
            System.out.println("#" + t + " " + maxSum);
        }
    }
}
