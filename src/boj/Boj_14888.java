/*
 * 문제: 14888 연산자 끼워넣기 / 372 ms
 * link: https://www.acmicpc.net/problem/14888
 * 알고리즘: 완전탐색
 * 풀이방법:
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

public class Boj_14888 {
    static int N, max, min;
    static int[] op, nums, opOrder;
    static boolean[] opCheck;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j, totalCnt;
        N = sc.nextInt();
        nums = new int[N];
        op = new int[4];
        opOrder = new int[N - 1];
        opCheck = new boolean[N - 1];
        Arrays.fill(opCheck, false);
        for (i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        totalCnt = 0;
        for (i = 0; i < 4; i++) {
            op[i] = sc.nextInt();
            for (j = 0; j < op[i]; j++) {
                // 0: +, 1: -, 2: *, 3: /
                opOrder[totalCnt++] = i;
            }
        }
        // solve
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        solve(0, 1, 0, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void solve(int opIdx, int numIdx, int opCnt, int num) {
        int result = 0;
        if (opCnt == N - 1) {
            if (num < min) min = num;
            if (num > max) max = num;
        } else {
            for (int i = 0; i < N - 1; i++) {
                if (!opCheck[i]) {
                    switch (opOrder[i]) {
                        // 0: +, 1: -, 2: *, 3: /
                        case 0:
                            result = num + nums[numIdx];
                            break;
                        case 1:
                            result = num - nums[numIdx];
                            break;
                        case 2:
                            result = num * nums[numIdx];
                            break;
                        case 3:
                            result = num / nums[numIdx];
                            break;
                    }
                    opCheck[i] = true;
                    solve(i, numIdx + 1, opCnt + 1, result);
                }
            }
        }
        opCheck[opIdx] = false;
    }
}
