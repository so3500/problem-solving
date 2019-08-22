/*
 * 문제: 2309 일곱 난쟁이 / 116 ms
 * link: https://www.acmicpc.net/problem/2309
 * 알고리즘: 완전 탐색
 * 풀이방법:
 * 	9명의 난쟁이 중 7명을 선택하는 조합 생성
 * 		1. 조합을 생성하는 도중 키의 합이 100초과 혹은 선택한 난쟁이의 수가 7명 초과일 경우 더 이상 진행하지 않음
 * 		2. 난쟁이 7명을 선택한 키의 합이 100일때 키를 오름차순으로 출력
 *
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *
 * 공간복잡도(Space Complexity)
 *
 * */

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_2309 {

    static int[] P;
    static boolean[] visited;
    static int N;
    static boolean find;

    public static void main(String[] args) {
        init();
        solve(0, 0, 0);
    }

    static void init() {
        Scanner sc = new Scanner(System.in);
        N = 9;
        P = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++)
            P[i] = sc.nextInt();
        Arrays.sort(P);
        find = false;
        sc.close();
    }

    static void solve(int idx, int pNum, int sum) {
        if (pNum == 7 && sum == 100) { // 7명의 난쟁이들의 키의 합이 100일때 정답 출력
            find = true;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                if (visited[i]) sb.append(P[i]).append("\n");
            }
            System.out.println(sb);
        } else if (sum < 100 && !find && pNum < 7) { // 키의 합이 100 초과, 난장이 7명 초과, 조합을 찾은 경우 경우 더 이상 진행하지 않음
            for (int i = idx; i < N; i++) { // 9명의 난쟁이들 중 7명의 조합(combination) 구하기
                if (!visited[i]) {
                    visited[i] = true;
                    solve(i, pNum + 1, sum + P[i]);
                    visited[i] = false;
                }
            }
        }
    }
}
