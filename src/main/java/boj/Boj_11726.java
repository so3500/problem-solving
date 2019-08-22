/*
 * 문제: 11726 2*n 타일링 / 124 ms
 * link: https://www.acmicpc.net/problem/11726
 * 알고리즘: DP
 * 풀이방법:
 * 	DP[i]: 2*i 직사각형을 2*1, 2*1 타일로 채운 방법의 수
 * 	이때, i번째 타일을 기준으로  (i-2번째 타일  + 1*2 타일 2개) + (i-1번째 타일 + 2*1 타일 1개) 이 i 번째 타일을 완성한다.
 * 	따라서 DP[i] = DP[i-1] + DP[i-2]
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   입력 N일 때 길이가 N인 1차원 배열의 처음부터 끝까지 연산을 수행하므로
 *   O(N)
 *
 * 공간복잡도(Space Complexity)
 * 	입력 N일 때 1차원 배열을 사용하므로
 * 	O(N)
 *
 * */

package boj;

import java.util.Scanner;

public class Boj_11726 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        int[] DP;
        N = sc.nextInt();
        DP = new int[N + 1];
        DP[1] = 1;
        if (N >= 2) DP[2] = 2;
        for (int i = 3; i <= N; i++) {
            DP[i] = (DP[i - 1] + DP[i - 2]) % 10007;
        }
        System.out.println(DP[N]);
        sc.close();
    }
}
