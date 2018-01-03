/*
 * 문제: 10971 / 외판원 순회
 * link: https://www.acmicpc.net/problem/10970
 * 알고리즘: TSP, 해당 문제에서는 모든 점에 대해서 DFS를 수행하는 완전탐색 방식 사용
 * 풀이방법:
 *   최소 비용을 구하는 '경로'를 찾는 문제이므로 최초 시작점은 임의의 어느 점에서 시작해도 같다.
 *   1 -> 2 -> 3 -> 1
 *   2 -> 3 -> 1 -> 2
 *   3 -> 1 -> 2 -> 3 해당 예에서 이 3가지 경로는 모두 같은 순회 비용을 가진다.
 *
 * 의사코드(Pseudo Code)
 *   input N
 *   init W[N][N], visited[N]
 *   input N*N numbers in W
 *   input 'false' in visited
 *
 *   depth <- N
 *   start <- 0
 *   minCost <- INTEGER.MAX_VALUE
 *   TSP(W, visited, start, start, depth, cost, N)
 *   print(minCost)
 *
 *   TSP(int[][] W, boolean[] visited, int first, int start, int depth, int cost, int N)
 *      visited[start] <- true
 *      if depth = 0
 *          minCost <- min(minCost, cost + W[start][first])
 *          visited[start] <- false
 *          return
 *      for target: 0 to N-1
 *          if (edge from start to target exist) and (target node not visited) and (cost <= minCost)
 *              TSP(W, visited, first, target, depth-1, cost + W[start][target], N)
 *      visited[start] <- false
 *
 * 시간복잡도(Time Complexity)
 *   완전탐색 방식을 사용 할 시 N!에 해당하는 경우가 발생한다.
 *
 * 공간복잡도(Space Complexity)
 *   2차원 배열 사용 O(N)
 *
 * */

package boj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SalesPerson_10971 {
    private static int minCost;

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        StringTokenizer st = null;

        int N, depth, cost, start, end, target, i;
        int[][] W = null;
        boolean[] visited = null;

        // 입력 및 초기화
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        visited = new boolean[N];
        Arrays.fill(visited, false);
        for (start = 0; start < N; start++) {
            st = new StringTokenizer(br.readLine());
            for (end = 0; end < N; end++) {
                W[start][end] = Integer.parseInt(st.nextToken());
            }
        }
        depth = N;
        start = 0;
        minCost = Integer.MAX_VALUE;
        TSP(W, visited, start, start, depth - 1, 0, N);

        System.out.println(minCost);
    }

    private static void TSP(int[][] W, boolean[] visited, int first, int start, int depth, int cost, int N) {
        visited[start] = true;
        if (depth == 0 && W[start][first] != 0) {
            minCost = Integer.min(minCost, cost + W[start][first]);
            visited[start] = false;
            return;
        }
        for (int target = 0; target < N; target++) {
            if (W[start][target] != 0 && !visited[target] && cost <= minCost) {
                // 최적화: cost가 minCost보다 작을 시 더 이상 구하지 않음
                TSP(W, visited, first, target, depth - 1, cost + W[start][target], N);
            }
        }
        visited[start] = false;
    }
}