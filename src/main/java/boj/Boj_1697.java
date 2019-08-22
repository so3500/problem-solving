/*
 * 문제: 숨바꼭질
 * link: https://www.acmicpc.net/problem/1697
 * 알고리즘:
 *  큐를 이용한 bfs 구현

 * 풀이방법:
 *  위치 X에서 bfs 탐색 시작(-1, +1, *2 인덱스를 큐에 저장)
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *  최악의 경우 N에서 0으로 갈때 -1씩만 이동 가능하므로
 *  O(N)
 *
 * 공간복잡도(Space Complexity)
 *  크기 N 입력에 대해 큐, 스택 사용 시 최대 N만큼 저장함
 *  O(N)
 * */

package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1697 {

    static int N, K, minDist;
    static boolean[] visited;
    static int SIZE = 100000;

    static class Point {
        int x, dist;

        public Point(int x, int dist) {
            this.x = x;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        visited = new boolean[SIZE + 1];
        solve();
        System.out.println(minDist);
        sc.close();
    }

    static void solve() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(N, 0));
        // 출발 위치 N에서 X-1, X+1, 2*X 위치로 bfs 수행
        // 이미 방문한 위치는 최소 탐색 시간을 구했다는 뜻이므로 큐에 추가하지 않음
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.x == K) {
                minDist = p.dist;
                break;
            }
            if (p.x - 1 >= 0 && !visited[p.x - 1]) {
                visited[p.x - 1] = true;
                q.add(new Point(p.x - 1, p.dist + 1));
            }
            if (p.x + 1 <= SIZE && !visited[p.x + 1]) {
                visited[p.x + 1] = true;
                q.add(new Point(p.x + 1, p.dist + 1));
            }
            if (p.x * 2 <= SIZE && !visited[p.x * 2]) {
                visited[p.x * 2] = true;
                q.add(new Point(p.x * 2, p.dist + 1));
            }
        }
    }
}
