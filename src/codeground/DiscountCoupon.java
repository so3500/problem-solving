package codeground;

/*
* 문제: 55 / SCPC 연습문제 / 할인권 / 0.12479
* link: https://www.codeground.org/practice
* 알고리즘: 동적 계획법(플로이드 워셜 알고리즘: 그래프에서 모든 vertex 사이의 최단경로 & 경로를 구하는 알고리즘)
* 풀이방법:
*   그래프 G는 2차원 배열로 구현
*   플로이스 워셜 알고리즘을 이용하여 node A 에서 B로 가는 데 소요되는 최단 비용 minCost 계산. G[A][B] <- minCost
*
* 의사코드(Pseudo Code)
*   input T
*   each T
*       answer <- 0
*       input N, M, K
*       init G[N+1][N+1] with 10001
*       for i: 1 to M
*           input A, B, C
*           G[A][B] <- C
*           G[B][A] <- C
*           G[i][i] <- 0
*
*       // Floyd-Warshall Algorithm
*
*       input P
*       for i: 1 to P
*           input S, E
*           if G[S][E] > K
*               answer++*
*
* 시간복잡도(Time Complexity)
*   입력 N에 대하여 2차원 배열을 사용하고 플로이드 워셜 알고리즘을 사용하므로
*   O(N^3)
*
* 공간복잡도(Space Complexity)
*   입력 N에 대하여 2차원 배열을 사용
*   O(N^2)
*
* */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

//class Solution {
class DiscountCoupon {
    static int Answer;

    public static void main(String args[]) throws Exception {
//        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new FileReader("input.txt")); // BufferedReader for file
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader for keyboard

//        int T = sc.nextInt();
        int T = Integer.parseInt(br.readLine()); // br

        StringTokenizer st;
        int N, M, K, A, B, C, P, S, E;
        int start, mid, end, i, couponCount;
        int[][] G = null;

//        StringTokenizer st = new StringTokenizer(br.readLine()); // line 기준 입력
//        Integer.parseInt(st.nextToken()); // 공백 기준 입력 e.g. 1 2 3 4 5 받을 때
        for (int test_case = 0; test_case < T; test_case++) {
            Answer = 0;
            /////////////////////////////////////////////////////////////////////////////////////////////
            /*
               Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            couponCount = 0;

            // init G
            G = new int[N + 1][N + 1];
            for (i = 0; i <= N; i++) {
                Arrays.fill(G[i], 10000 + 1);
                G[i][i] = 0;
            }
            for (i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                A = Integer.parseInt(st.nextToken());
                B = Integer.parseInt(st.nextToken());
                C = Integer.parseInt(st.nextToken());
                G[A][B] = C;
                G[B][A] = C;
            }

            // Floyd-Warshall
            for (mid = 1; mid <= N; mid++) {
                for (start = 1; start <= N; start++) {
                    for (end = 1; end <= N; end++) {
                        G[start][end] = Integer.min(G[start][mid] + G[mid][end], G[start][end]);
                    }
                }
            }
            // get coupon count
            st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            for (i = 1; i <= P; i++) {
                st = new StringTokenizer(br.readLine());
                S = Integer.parseInt(st.nextToken());
                E = Integer.parseInt(st.nextToken());
                if (G[S][E] > K) {
                    couponCount++;
                }
            }
            Answer = couponCount;
            /////////////////////////////////////////////////////////////////////////////////////////////
            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.println(Answer);
        }
    }
}
