/*
 * 문제: 2117.[모의 SW 역량테스트] 홈 방범 서비스 / 2321 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V61LqAf8DFAWu
 * 알고리즘: BFS, DFS
 * 풀이방법:
 *      각 row, col 에서 k 값에 따라 bfs 를 수행하고
 *      그 결과값으로 maxCnt를 구한다.
 *
 *      그런데, 좀 더 효율적인 방법을 찾아보니
 *      각 row, col 에서 k 값을 증가하면서 집의 수를 세는 방법이 있었다.
 *      이 방법을 사용하면
 *
 * 의사코드(Pseudo Code)
 *      for k: 1 to N+1
 *          cost = k*k + (k-1)*(k-1)
 *          for r: 0 to N-1
 *              for c: 0 to N-1
 *                  solve(r, c, k, cost)
 *
 *      solve(r, c, k, cost)
 *          cnt = bfs(r, c, k)
 *          if cost <= benefit
 *              maxCnt = max(maxCnt, cnt)
 *
 *      dfs(r, c, k)
 *          q.add(P(r, c, 0))
 *          history(P(r, c, 0))
 *          while q is not empty:
 *              p = q.poll()
 *              if p.dist < k:
 *                  add new P
 *
 *          while history is not empty:
 *              // init visited[][]
 *
 *
 * 시간복잡도(Time Complexity)
 *   입력 N일 때 2차원 배열을 모두 탐색하는 경우 O(N^2)
 *   각 배열의 요소에서 K가 N만큼 커질 때 까지 탐색하고 이 때 N^2/2 만큼 탐색하므로 O(N^2)
 *   O(N^4)
 *
 * 공간복잡도(Space Complexity)
 *   입력 N일 때 2차원 배열 사용
 *   O(N^2)
 *
 * */


package swexpert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SE_2117 {

    static int N, M, maxCnt;
    static int[] rows = {-1, 0, 1, 0};
    static int[] cols = {0, 1, 0, -1};
    static boolean[][] map, visited;

    static class P {
        int r, c, dist;

        public P(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t, i, r, c, k, cost;
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            init(sc);
            for (k = 1; k <= N + 1; k++) {
                cost = k * k + (k - 1) * (k - 1);
                for (r = 0; r < N; r++) {
                    for (c = 0; c < N; c++) {
                        solve(r, c, k, cost);
                    }
                }
            }
            System.out.println("#" + t + " " + maxCnt);
        }
    }

    static void init(Scanner sc) {
        N = sc.nextInt();
        M = sc.nextInt();
        map = new boolean[N][N];
        visited = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (sc.nextInt() > 0) map[r][c] = true;
            }
        }
        maxCnt = Integer.MIN_VALUE;
    }

    static void solve(int r, int c, int k, int cost) {
        int cnt;
        cnt = bfs(r, c, k);
        if (cnt * M >= cost) {
            maxCnt = Integer.max(maxCnt, cnt);
        }
    }

    static int bfs(int r, int c, int k) {
        Queue<P> q = new LinkedList<>();
        Queue<P> history = new LinkedList<>();
        int toR, toC, cnt;
        q.add(new P(r, c, 0));
        history.add(new P(r, c, 0));
        visited[r][c] = true;
        cnt = 0;
        while (!q.isEmpty()) {
            P p = q.poll();
            if (k <= p.dist) continue;
            if (map[p.r][p.c]) cnt++;
            for (int i = 0; i <= 3; i++) {
                toR = p.r + rows[i];
                toC = p.c + cols[i];
                if (toR < 0 || N <= toR || toC < 0 || N <= toC || visited[toR][toC]) continue;
                visited[toR][toC] = true;
                q.add(new P(toR, toC, p.dist + 1));
                history.add(new P(toR, toC, p.dist + 1));
            }
        }
        // visited 초기화
        while (!history.isEmpty()) {
            P p = history.poll();
            visited[p.r][p.c] = false;
        }
        return cnt;
    }

}
