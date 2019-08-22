package example;

public class UnionFind {

    static int[] arr, rank;
    static boolean[] visited;

    public static void main(String[] args) {
        final int SIZE = 11;
        int i;
        arr = new int[SIZE];
        rank = new int[SIZE];
        visited = new boolean[SIZE];
        for (i = 0; i < SIZE; i++) {
            arr[i] = i;
        }

        int[] aGroup = {2, 2, 7, 2, 3, 7};
        int[] bGroup = {4, 6, 3, 10, 7, 1};
        for (i = 0; i < aGroup.length; i++) {
            union(aGroup[i], bGroup[i]);
        }
        int cnt = 0;
        int groupCnt = 0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (i = 0; i < SIZE; i++) {
            sb1.append(i + " ");
            sb2.append(arr[i] + " ");
            if (arr[i] == i) {
                cnt++;
                if (visited[i]) groupCnt++;
            }
        }
        System.out.println(cnt + " " + groupCnt);

        System.out.println(sb1);
        System.out.println(sb2);
    }

    static void union(int u, int v) {
        visited[u] = true;
        visited[v] = true;
        u = find(u);
        v = find(v);
        if (u == v) return;

        // u 의 rank 가 더 큰 경우, u 와 v를 자리바꿈
        if (rank[u] > rank[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        arr[u] = v; // v 가 rank 가 더 큰 트리. 작은 트리 u의 루트를 v로 설정
        // 두 트리의 높이가 같은 경우에는 결과 트리(큰 트리)의 rank 를 1높여준다
        if (rank[u] == rank[v]) rank[v]++;

    }

    static int find(int u) {
        // 루트노드를 반환함
        if (u == arr[u]) return u;
        return arr[u] = find(arr[u]);
    }
}