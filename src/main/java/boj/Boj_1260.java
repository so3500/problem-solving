/*
 * 문제: 1260 DFS와 BFS / 432 ms
 * link: https://www.acmicpc.net/problem/1260
 * 알고리즘: BFS, DFS
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
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1260 {

    static class Vertex {
        int vertexNo, dist;

        public Vertex(int vertexNo, int dist) {
            this.vertexNo = vertexNo;
            this.dist = dist;
        }
    }

    static int N, M, startV;
    static boolean[][] map;
    static boolean[] visited;
    static StringBuilder out;

    public static void main(String[] args) {
        init();
        solve();
        System.out.println(out);
    }

    static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        startV = sc.nextInt();
        map = new boolean[N + 1][N + 1];
        int r, c;
        for (int i = 0; i < M; i++) {
            r = sc.nextInt();
            c = sc.nextInt();
            map[r][c] = true;
            map[c][r] = true;
        }
        out = new StringBuilder();
        sc.close();
    }

    static void solve() {
        visited = new boolean[N + 1];
        dfs(startV);
//		out.deleteCharAt(out.length() - 1); // dfs 결과에서 맨 뒤 공백 삭제
        Arrays.fill(visited, false);
        out.append("\n");
        bfs(startV);
        out.deleteCharAt(out.length() - 1); // bfs 결과에서 맨 뒤 공백 삭제
    }

    static void dfs(int vertex) {
        visited[vertex] = true;
        out.append(vertex).append(" ");
        for (int toVertex = 1; toVertex <= N; toVertex++) {
            if (map[vertex][toVertex] && !visited[toVertex]) {
                dfs(toVertex);
            }
        }
    }

    static void bfs(int vertex) {
//		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>((o1, o2) -> {
//			if (o1.dist == o2.dist) { // 거리가 같을 시 정점의 번호 오름차순
//				return o1.vertexNo - o2.vertexNo;
//			} else { // 거리 오름차순
//				return o1.dist - o2.dist;
//			}
//		});
        Queue<Vertex> q = new LinkedList<>();
        q.add(new Vertex(vertex, 0));
        visited[vertex] = true;
        int toVertex;
        Vertex v;
        while (!q.isEmpty()) {
            v = q.remove();
            out.append(v.vertexNo).append(" ");

            for (toVertex = 1; toVertex <= N; toVertex++) {
                if (map[v.vertexNo][toVertex] && !visited[toVertex]) {
                    visited[toVertex] = true;
                    q.add(new Vertex(toVertex, v.dist + 1));
                }
            }
        }
    }
}
