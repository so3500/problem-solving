/*
 * 문제: 1182 부분집합의 합 / 132ms
 * 알고리즘: 완전 탐색
 * 풀이방법:
 *   입력받은 숫자 N개 중, 임의의 개(1개 ~ N개)에 이르기까지 모두 선택하여 그 합을 구한뒤
 *   그 합이 S일 경우 count 한다.
 *   N개가 최대 20개 이므로,
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

public class SumOfSubset_1182 {

    static int N, S, i, cnt, sumOfSubset;
    static int[] seq;
    static boolean[] seqUse;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();
        seq = new int[N];
        seqUse = new boolean[N];
        for (i = 0; i < N; i++) {
            seq[i] = sc.nextInt();
            seqUse[i] = false;
        }

        for (i = 0; i < N; i++) {
            sumOfSubset = 0;
            solve(i);
        }

        System.out.println(cnt);
    }

    static void solve(int start) {
        if (start >= N) return;

//        seqUse[start] = true;
        sumOfSubset += seq[start];
        if (sumOfSubset == S) cnt++;
        for (int j = start; j < N; j++) {
            solve(j + 1);
        }
//        seqUse[start] = false;
        sumOfSubset -= seq[start];
    }

    static void printSeq() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (seqUse[i]) {
                sb.append(seq[i]).append(" ");
            }
        }
        System.out.println(sb);
    }
}
