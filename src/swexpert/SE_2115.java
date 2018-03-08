/*
 * 문제: 2115 [모의 SW 역량테스트] 벌꿀채취 / 150 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V4A46AdIDFAWu&categoryId=AV5V4A46AdIDFAWu&categoryType=CODE
 * 알고리즘: 완전탐색
 * 풀이방법:
 *      2차원 배열에서 겹치지 않는 두 개의 1차원 배열의 경우의수를 모두 나열
 *      순서는 상관없음.
 *          그 탐색 안에서 M(1<=M<=5) 개의 벌통 중에서 C가 허용하는 범위 내에서 1 or 2 or 3 or 4 or 5 개를 선택하는 경우의 수
 *          이 경우의 수에서 구할 수 있는 이익 중 최대 값 출력
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   입력 N일때 4중 반복문 탐색 O(N^4)
 *   그 탐색 안에서 M(1<=M<=5) 개의 벌통 중에서 C가 허용하는 범위 내에서 1 or 2 or 3 or 4 or 5 개를 선택하는 경우의 수
 *   순서는 상관 없으므로 combination
 *
 *   결론은, O(N^4)??
 *
 * 공간복잡도(Space Complexity)
 *   입력 N일 때 2차원 배열 사용
 *   O(N^2)
 *
 * */

package swexpert;

import java.util.Scanner;

public class SE_2115 {

    static int N, M, C, ans;
    static int[][] map = new int[11][11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, i, testCase, row, col;
        T = sc.nextInt();
        for (testCase = 1; testCase <= T; testCase++) {
            N = sc.nextInt();
            M = sc.nextInt();
            C = sc.nextInt();
            // 꿀 정보 입력
            for (row = 1; row <= N; row++) {
                for (col = 1; col <= N; col++) {
                    map[row][col] = sc.nextInt();
                }
            }

            ans = Integer.MIN_VALUE;
            for (int firstRow = 1; firstRow <= N; firstRow++) {
                for (int firstCol = 1; firstCol + M - 1 <= N; firstCol++) {

                    for (int secondRow = firstRow; secondRow <= N; secondRow++) {
                        for (int secondCol = 1; secondCol + M - 1 <= N; secondCol++) {
                            // 첫번째 꿀통보다 두번째 꿀통이 같은 row 에서 앞에 있거나 겹치는 경우 제외
                            if (firstRow == secondRow && (secondCol <= firstCol + M - 1 || secondCol + M - 1 <= firstCol))
                                continue;

                            ans = Integer.max(ans,
                                    getMaxProfit(firstRow, firstCol, firstCol + M - 1, 0, 0)
                                            + getMaxProfit(secondRow, secondCol, secondCol + M - 1, 0, 0));
//                            System.out.println("(" + firstRow + " " + firstCol + "-" + (firstCol + M - 1) + ")" +
//                                    " (" + secondRow + " " + secondCol + "-" + (secondCol + M - 1) + ")");
                        }
                    }
                }
            }
            System.out.println("#" + testCase + " " + ans);
        }
    }

    // 채취할 수 있는 꿀의 양 한도 내에서 최대이익을 리턴
    static int getMaxProfit(int row, int colFrom, int colTo, int hSum, int hSquareSum) {
        if (hSum > C) return 0;
        int ret = hSquareSum;
        for (int idx = colFrom; idx <= colTo; idx++) {
            ret = Integer.max(ret,
                    getMaxProfit(row, idx + 1, colTo, hSum + map[row][idx], hSquareSum + map[row][idx] * map[row][idx]));
        }
        return ret;
    }
}
