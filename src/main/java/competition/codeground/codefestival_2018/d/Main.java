package competition.codeground.codefestival_2018.d;

import java.util.*;

public class Main {

    static class Point {
        int x, y, no;

        public Point(int no, int x, int y) {
            this.no = no;
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, Q;
    static List<Point> points;
    static boolean[] visited;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        init(sc);

        StringBuilder sb = new StringBuilder(Q * 3);
        for (int idx = 0; idx < Q; idx++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int hp = sc.nextInt();
            boolean ans = bfs(a, b, hp);
            if (ans) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
        sc.close();
    }

    static void init(Scanner sc) {
        N = sc.nextInt();
        Q = sc.nextInt();
        points = new ArrayList<>(N);
        for (int no = 1; no <= N; no++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points.add(new Point(no, x, y));
        }
    }

    static boolean bfs(int start, int end, int hp) {
        boolean ans = false;
        Queue<Point> q = new LinkedList<>();
        visited = new boolean[N + 1];
        q.add(points.get(start - 1));

        while (q.isEmpty() == false) {
            Point p = q.poll();
            visited[p.no] = true;

            if (p.no == end) {
                ans = true;
                break;
            }

            for (Point toP : points) {
                if (!visited[toP.no] && isReachable(p, toP, hp)) {
                    q.add(toP);
                }
            }
        }
        return ans;
    }

    static boolean isReachable(Point p, Point toP, int hp) {
        if (p.x == toP.x || p.y == toP.y || Math.abs(p.x - toP.x) <= hp || Math.abs(p.y - toP.y) <= hp) {
            return true;
        } else {
            return false;
        }
    }
}