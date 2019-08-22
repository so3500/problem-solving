/*
 * 문제: 1309 동물원 / 136 ms
 * link: https://www.acmicpc.net/problem/1309
 * 알고리즘: 다이나믹 프로그래밍
 * 풀이방법:
 *
 * 	다이나믹 프로그래밍을 1차원 배열이 아닌 2차원 배열에 구현하였음
 *
 * 	DP[i][0]: i번째 줄에 사자를 배치하지 않을 때 경우의 수
 * 	DP[i][1]: i번째줄에서 사자를 왼쪽에 배치할 때의 경우의 수
 * 	DP[i][2]: i번째 줄에서 사자를 오른쪽에 배치할 때의 경우의 수
 *
 * 	i번째 줄에 사자를 배치하지 않을 경우 = i-1번재 줄까지 사자를 배치하지 않거나 배치하는 모든 경우의 수
 * 	DP[i][0] = DP[i - 1][0] + DP[i - 1][1] + DP[i - 1][2];
 *
 * 	i번째 줄의 왼쪽에 사자를 배치할 경우 = i-1번째줄에 사자를 배치하지 않거나 오른쪽에 배치하는 모든 경우의 수
 * 	DP[i][1] = DP[i - 1][0] + DP[i - 1][2];
 *
 * 	i번째 줄의 오른쪽에 사자를 배치할 경우 = i-1번재줄에 사자를 배치하지 않거나 왼쪽에 배치하는 모든 경우의 수
 * 	DP[i][2] = DP[i - 1][0] + DP[i - 1][1];
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

public class Boj_1309 {

    static int[][] DP;
    static int ans, N;

    public static void main(String[] args) {
        init();
        solve();
        System.out.println(ans);
    }

    public static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        DP = new int[N + 1][3];
        DP[1][0] = 1;
        DP[1][1] = 1;
        DP[1][2] = 1;
        sc.close();
    }

    public static void solve() {
        for (int i = 2; i <= N; i++) {
            DP[i][0] = (DP[i - 1][0] + DP[i - 1][1] + DP[i - 1][2]) % 9901;
            DP[i][1] = (DP[i - 1][0] + DP[i - 1][2]) % 9901;
            DP[i][2] = (DP[i - 1][0] + DP[i - 1][1]) % 9901;
        }
        ans = (DP[N][0] + DP[N][1] + DP[N][2]) % 9901;
    }

}
