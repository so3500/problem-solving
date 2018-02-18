/*
 * 문제: 2003 수들의 합2 / 120 ms
 * link: https://www.acmicpc.net/problem/2003
 * 알고리즘: 투 포인터
 * 풀이방법:
 *  left, right pointer 유지
 *  right < N 일 때까지 아래 반복
 *      if sum < M
 *          right++
 *          sum += num[right]
 *      if sum == M
 *          right++
 *          cnt++
 *          sum += num[right]
 *      if sum > M
 *          sum -= num[left]
 *          left++
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   입력 N일 때 1차원 배열을 모두 탐색하는 경우
 *   O(N)
 *
 * 공간복잡도(Space Complexity)
 *   입력 N일 때 1차원 배열 사용
 *   O(N)
 *
 * */

package boj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class SumOfNum2_2003 {

    static int N, M, sum, cnt;
    static int[] num;

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        num = new int[N+1];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(input[i]);
        }
        num[N] = 0;
        cnt = 0;
        solve();
        System.out.println(cnt);
    }

    static void solve() {
        int left, right;
        left = 0;
        right = 0;
        sum = num[0];
        while (right < N) {
            if (sum < M) {
                right++;
                sum += num[right];
            } else if (sum == M) {
                right++;
                sum += num[right];
                cnt++;
            } else if (sum > M) {
                sum -= num[left];
                left++;
            }
        }
    }
}
