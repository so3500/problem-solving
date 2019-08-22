/*
 * 문제: 4012. [모의 SW 역량테스트] 요리사 / 180 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH
 * 알고리즘: 완전탐색
 * 풀이방법:
 *      A에 식재료 N/2개를 먼저 채운다.
 *      식재료 N/2개를 채우면 A에 없는 식재료를 B에 채운다
 *      이 때 A, B에서 S값을 구한다.
 *      구한 A, B의 S 값들의 차이 중 최소값을 구한다.
 *
 * 의사코드(Pseudo Code)
 *
 *
 * 시간복잡도(Time Complexity)
 *      N개 중 N/2개를 선택하는 경우의 수 (N)Comb(N/2). 조합이므로 2^N
 *      구한 조합에 있는 N/2개를 가지고 2차원 배열을 탐색하므로 N^2
 *      따라서 O(2^N)
 *
 * 공간복잡도(Space Complexity)
 *      입력 N에 대하여 2차원 크기의 배열 사용
 *      O(N^2)
 *
 * */

package swexpert;

import java.util.Scanner;

public class SE_4012 {

    static int[][] table;
    static int[] A, B;
    static int N, sumA, sumB, aIdx, minDiff;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t, i;
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            init(sc);
            solve(0, 0, 0);
            System.out.println("#" + t + " " + minDiff);
        }
        sc.close();
    }

    private static void init(Scanner sc) {
        N = sc.nextInt();
        table = new int[N][N];
        A = new int[N / 2];
        B = new int[N / 2];
        visited = new boolean[N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                table[r][c] = sc.nextInt();
            }
        }
        aIdx = 0;
        minDiff = Integer.MAX_VALUE;
    }

    private static void getSum() {
        sumA = 0;
        sumB = 0;
        for (int i = 0; i < N / 2; i++) {
            for (int j = i + 1; j < N / 2; j++) {
                sumA += table[A[i]][A[j]] + table[A[j]][A[i]];
                sumB += table[B[i]][B[j]] + table[B[j]][B[i]];
            }
        }
    }

    private static void solve(int num, int len, int aIdx) {
        if (len == N / 2) {
            int bIdx = 0;
            // A 에 없는 식재료를 B 의 목록에 추가
            for (int j = 0; j < N; j++) {
                if (!visited[j]) B[bIdx++] = j;
            }
            getSum(); // A, B에 있는 식재료를 가지고 각각의 S값 구하기
            minDiff = Integer.min(minDiff, Math.abs(sumA - sumB));

        } else {
            // A에 식재료를 N/2개 만큼 모으기
            for (int i = num; i < N; i++) {
                if (!visited[i]) {
                    A[aIdx] = i;
                    visited[i] = true;
                    solve(i, len + 1, aIdx + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
