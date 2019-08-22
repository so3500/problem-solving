/*
 * 문제: 1759 암호 만들기 / 144 ms
 * link: https://www.acmicpc.net/problem/1759
 * 알고리즘: 완전 탐색, 조합(combination)
 * 풀이방법:
 * 	L, C, C개의 문자 입력
 * 	문자 배열을 사전순으로 정렬
 * 	문자 배열에서 L개를 선택
 * 	선택한 L개의 문자들이 조건(최소 1개의 모음, 최소2개의 자음)을 만족 시 출력
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   입력 L, C 일 때 C개의 문자 중에서 L개를 조합하므로 O(C^2)
 *   O(C^2)
 *
 * 공간복잡도(Space Complexity)
 *   입력 L, C 일때 C 길이 만큼의 1차원 배열을 사용하므로
 *   O(C)
 *
 * */

package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1759 {

    static int L, C;
    static char[] S;
    static boolean[] visited;

    public static void main(String[] args) {
        init();
        solve(0, 0, 0, 0, new StringBuilder());
    }

    static void init() {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        S = new char[C];
        visited = new boolean[C];
        for (int i = 0; i < C; i++) {
            S[i] = sc.next().charAt(0);
        }
        Arrays.sort(S); // 사전순으로 정렬
        sc.close();
    }

    static void solve(int idx, int len, int vCnt, int cCnt, StringBuilder out) {
        if (len == L && vCnt >= 1 && cCnt >= 2) {
            // 길이가 L 이면서 최소 한개의 모음, 최소 2개의 자음으로 구성될 때 출력
            System.out.println(out);
        } else if (len < L) {
            // 길이가 L 미만일 때만 새로운 조합 생성 시도
            for (int i = idx; i < C; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    StringBuilder sb = new StringBuilder();
                    sb.append(out).append(S[i]);
                    if (S[i] == 'a' || S[i] == 'e' || S[i] == 'i' || S[i] == 'o' || S[i] == 'u') {
                        solve(i, len + 1, vCnt + 1, cCnt, sb);
                    } else {
                        solve(i, len + 1, vCnt, cCnt + 1, sb);
                    }
                    visited[i] = false;
                }
            }
        }
    }
}
