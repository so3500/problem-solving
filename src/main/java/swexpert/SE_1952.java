/*
 * 문제: 1952 수영장 / 127 ms
 * link:
 * 알고리즘: dfs, 완전탐색
 * 풀이방법:
 *      최초의 최소비요은 1년치 비용.
 *      1~12 월 사용 계획에서 각 달에 해당하는 1일 or 1달 비용중 최소 비용을 고른다.
 *      e.g.) 1일 1달 1달 0 0 0 1일 1일 ...
 *      3달 이용권을 1 ~ 12 월까지 적용하면서 기존의 값과 비교한다.
 *      3달 이용권을 (1,2,3) (4,5,6) ... (10,11,12)
 *                   (1,2,3) (5,6,7) ... (9,10,11) (12)
 *                   등 모든 경우의 수에 대해 3달 이용권 사용 여부를 체크한다.
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *
 *
 * 공간복잡도(Space Complexity)
 *   상수의 입력(비용정보, 월 사용계획 정보)을 처리할 입력만 들어오므로
 *   상수길이의 1차원배열 사용
 *   O(1)
 *
 * */

package swexpert;

import java.util.Arrays;
import java.util.Scanner;

public class SE_1952 {

    static int[] cost, month, monthCost;
    static int minCost;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        cost = new int[4];
        month = new int[13];
        monthCost = new int[13];
        for (int testCase = 1; testCase <= T; testCase++) {
            for (int i = 0; i < 4; i++) cost[i] = sc.nextInt();
            for (int i = 1; i <= 12; i++) month[i] = sc.nextInt();
            Arrays.fill(monthCost, 0);
            solve();
            System.out.println("#" + testCase + " " + minCost);
        }
    }

    static void solve() {
        int dCost, mCost, costSum;
        costSum = 0;
        minCost = cost[3]; // 1 년 이용권 요금
        for (int i = 1; i <= 12; i++) {
            dCost = cost[0] * month[i]; // 1일 이용권 요금
            mCost = cost[1]; // 1달 이용권 요금
            if (dCost > mCost) monthCost[i] = mCost;
            else monthCost[i] = dCost;
            costSum += monthCost[i];
        }
        minCost = Integer.min(costSum, minCost);
        for (int i = 1; i <= 12; i++) {
            dfs(i, costSum);
        }
    }

    static void dfs(int idx, int costSum) {
        if (idx > 12) {
            minCost = Integer.min(costSum, minCost);
        } else if (idx <= 12) {
            int threeMonthSum = 0;          // idx, idx+1, idx+2 1달 이용권 요금의 합
            int threeMonthCost = cost[2];   // idx 에서 시작하는 3달 이용권 요금
            for (int i = idx; i <= 12 && i < idx + 3; i++) {
                threeMonthSum += monthCost[i];
            }
            if (threeMonthSum > threeMonthCost) {
                // idx, idx+1, idx+2 1달 이용권 요금의 합을 idx 에서 시작하는 3달 이용권 요금으로 변경
                // idx, idx+1, idx+2 를 처리하고 idx+3 을 처리할 수도 있지만
                // idx+4 ... 부터 처리하는 경우도 있으므로 아래와 같이 반복문으로 처리
                for (int i = idx; i <= 12; i++) {
                    dfs(i + 3, costSum - threeMonthSum + threeMonthCost);
                }
            } else {
                dfs(idx + 1, costSum);
            }
        }
    }
}