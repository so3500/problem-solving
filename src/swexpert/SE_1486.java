/*
 * 문제: 1486. 장훈이의 높은 선반 / 109 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV2b7Yf6ABcBBASw&categoryId=AV2b7Yf6ABcBBASw&categoryType=CODE
 * 알고리즘: 완전탐색
 * 풀이방법:
 *      각 점원의 키 중에서 1개, 2개, ... N 개를 고르는 모든 경우를 구현한다.
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *
 * 공간복잡도(Space Complexity)
 *   입력에 상관없이 일정한 크기의 1차원 배열 사용
 *   O(1)
 *
 * */

package swexpert;

import java.util.Arrays;
import java.util.Scanner;

public class SE_1486 {
    static int N, B, hSum;
    static int[] arr = new int[20];
    static boolean[] visited = new boolean[20];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t, i;
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            init(sc);
            solve(0, 0);
            System.out.println("#" + t + " " + (hSum - B));
        }
    }

    public static void init(Scanner sc) {
        N = sc.nextInt();
        B = sc.nextInt();
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.fill(visited, false);
        hSum = Integer.MAX_VALUE;
    }

    public static void solve(int start, int sum) {
        // sum 이 B보다 클 경우 sum 중 최소값을 구하고,
        // 이때, 차이가 더욱 벌어지는 다음 단계로는 가지않는다.
        if (sum >= B) {
            hSum = Integer.min(hSum, sum);
        } else {
            for (int i = start; i < N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    solve(i + 1, sum + arr[i]);
                    visited[i] = false;
                }
            }
        }
    }
}
