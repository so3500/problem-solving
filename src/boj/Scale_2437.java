/*
 * 문제: 2437 저울 / 92 ms
 * link: https://www.acmicpc.net/problem/2437
 * 알고리즘: 그리디 알고리즘
 * 풀이방법:
 *  저울의 값을 오름차순으로 정렬하고 하나씩 늘려가면서 무게를 잰다.
 *  n-i개의 추의 무게 합 < 새로운 추의 무게 이면 그 사이에 존재하는 무게는 잴 수 없다.
 *
 *  n개의 저울을 사용하여 잴 수 있는 무게는 그 이전 무게 또한 부분 개수의 저울을 이용하여 잴 수 있다.
 *  위 조건이 문제에 안적혀 있어서 처음에는 완전 탐색으로 풀어봤는데 런타임 에러 발생
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *  배열 순회
 *  O(N)
 *
 * 공간복잡도(Space Complexity)
 *  배열 사용
 *  O(N)
 *
 * */

package boj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Scale_2437 {

    static int N, wSum;
    static int[] W;
//    static boolean[] S;

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i;
        String[] input;

        N = Integer.parseInt(br.readLine());
        W = new int[N];
//        S = new boolean[1000000001];

        input = br.readLine().split(" ");
        for (i = 0; i < N; i++) {
            W[i] = Integer.parseInt(input[i]);
        }
//        Arrays.fill(S, false);
        Arrays.sort(W);

        wSum = 0;
        for (i = 0; i < N; i++) {
            if (wSum + 1< W[i]) break;
            else wSum += W[i];
        }
        System.out.println(wSum + 1);

//        for (i = 0; i < N; i++) {
//            wSum = 0;
//            solve(i);
//        }
//        printMin();

    }
}

//    static void solve(int start) {
//        wSum += W[start];
//        S[wSum] = true;
//        if (wSum >= W[start]) {
//            for (int j = start + 1; j < N; j++) {
//                solve(j);
//            }
//        }
//        wSum -= W[start];
//    }
//
//    static void printMin() {
//        for (int i=1; i<S.length; i++){
//            if (!S[i]){
//                System.out.println(i);
//                break;
//            }
//        }
//    }
//}
