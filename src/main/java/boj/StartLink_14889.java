/*
 * 문제: 14889 스타트와 링크  / 256ms
 * 알고리즘: 완전 탐색
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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StartLink_14889 {

    static int N;
    static int[][] S;
    static boolean[] visited;
    static int ans;

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input;

        N = Integer.parseInt(br.readLine());
        S = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        Arrays.fill(visited, false);
        for (int row = 1; row <= N; row++) {
            input = br.readLine().split(" ");
            for (int col = 1; col <= N; col++) {
                S[row][col] = Integer.parseInt(input[col - 1]);
            }
        }

        ans = Integer.MAX_VALUE;
        solve(0, 0);
        System.out.println(ans);
    }

    static void solve(int visit, int len) {
        if (N / 2 == len) {
            getAbility();
        } else {
            // 두 팀으로 나누어 지지 않은 경우, 한 팀의 수를 50%까지 올리기
            for (int i = visit + 1; i <= N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    solve(i, len + 1);
                }
            }
        }
        visited[visit] = false;
    }

    static void getAbility() {
        int[] a = new int[N / 2 + 1];
        int[] b = new int[N / 2 + 1];

        int aSum, bSum, sumDiff;
        int aIndex = 1;
        int bIndex = 1;
        // visited를 기반으로 팀 나누기
        for (int i = 1; i <= N; i++) {
            if (visited[i]) a[aIndex++] = i;
            else b[bIndex++] = i;
        }

        aSum = 0;
        bSum = 0;
        sumDiff = 0;
        // 각 팀의 능력치 합 구하기
        for (int from = 1; from <= N / 2; from++) {
            for (int to = from + 1; to <= N / 2; to++) {
                aSum += (S[a[from]][a[to]] + S[a[to]][a[from]]);
                bSum += (S[b[from]][b[to]] + S[b[to]][b[from]]);
            }
        }

        sumDiff = Math.abs(aSum - bSum);
        ans = Integer.min(sumDiff, ans);
    }
}
