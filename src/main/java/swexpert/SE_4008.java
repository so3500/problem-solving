/*
 * 문제: 4008. [모의 SW 역량테스트] 숫자 만들기 / 141 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeRZV6kBUDFAVH
 * 알고리즘: 완전 탐색
 * 풀이방법:
 *      연산자를 넣을 수 있는 경우의 수를 모두 구한다.
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *
 * 공간복잡도(Space Complexity)
 *
 * */

package swexpert;

import java.util.Scanner;

public class SE_4008 {

    static int N, minResult, maxResult;
    static int[] num, op;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t;
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            init(sc);
            solve(num[0], 1);
            System.out.println("#" + t + " " + (maxResult - minResult));
        }
    }

    private static void init(Scanner sc) {
        N = sc.nextInt();
        num = new int[N];
        op = new int[4];
        int i;
        for (i = 0; i < 4; i++) {
            op[i] = sc.nextInt();
        }
        for (i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        minResult = Integer.MAX_VALUE;
        maxResult = Integer.MIN_VALUE;
    }

    private static void solve(int result, int numIdx) {
        if (numIdx == N) {
            minResult = Integer.min(minResult, result);
            maxResult = Integer.max(maxResult, result);
        } else {
            if (op[0] > 0) {
                op[0]--;
                solve(result + num[numIdx], numIdx + 1);
                op[0]++;
            }
            if (op[1] > 0) {
                op[1]--;
                solve(result - num[numIdx], numIdx + 1);
                op[1]++;
            }
            if (op[2] > 0) {
                op[2]--;
                solve(result * num[numIdx], numIdx + 1);
                op[2]++;
            }
            if (op[3] > 0) {
                op[3]--;
                solve(result / num[numIdx], numIdx + 1);
                op[3]++;
            }
        }
    }

//    private static void solve(int result, int numIdx, int opIdx, int opLen) {
//        if (opLen == N - 1) {
//            minResult = Integer.min(minResult, result);
//            maxResult = Integer.max(maxResult, result);
//        } else {
//            if (!visited[opIdx]) {
//                int r = 0;
//                visited[opIdx] = true;
//                switch (op[opIdx]) {
//                    case 1:
//                        r = result + num[numIdx];
//                        break;
//                    case 2:
//                        r = result - num[numIdx];
//                        break;
//                    case 3:
//                        r = result * num[numIdx];
//                        break;
//                    case 4:
//                        r = result / num[numIdx];
//                        break;
//                }
//                solve(r, numIdx + 1, opIdx + 1, opLen + 1);
//                visited[opIdx] = false;
//            }
//        }
//    }
}
