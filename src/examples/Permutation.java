package examples;

import java.util.Arrays;

public class Permutation {

    static int N = 4;
    static int[] arr = {1, 7, 6, 8};
    static boolean[] visited = new boolean[4];

    public static void main(String[] args) {
        Arrays.fill(visited, false);
        for (int i = 0; i < 4; i++) {
//            allGroup(i);
        }
        for (int i = 0; i < 4; i++) {
//            allGroupByChanging(i, 0);
        }
        perm(0);

        // 사전순으로 순열 생성
//        for (int i=1; i<=N; i++){
//            visited[i]=true;
//            permOrder(i, 1);
//            visited[i]=false;
//        }
    }

    static void allGroup(int idx) {
        visited[idx] = true;
        print();
        for (int i = idx + 1; i < 4; i++) {
            allGroup(i);
        }
        visited[idx] = false;
    }

    static void perm(int k) {
        if (N == k) {
            printArr();
        } else {
            for (int i = k; i < N; i++) {
                swap(arr, k, i);
                perm(k + 1);
                swap(arr, k, i);
            }
        }
    }

//    static void permOrder(int num, int depth) {
//        S[depth] = num;
//        if (depth == N) {
//            print();
//        }
//        for (int i = 1; i <= N; i++) {
//            if (!visited[i]) {
//                visited[i] = true;
//                permOrder(i, depth + 1);
//                visited[i] = false;
//            }
//        }
//    }

    static void swap(int[] arr, int aIdx, int bIdx) {
        int temp = arr[aIdx];
        arr[aIdx] = arr[bIdx];
        arr[bIdx] = temp;
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (visited[i]) sb.append(arr[i] + " ");
        }
        sb.append("\n");
        System.out.println(sb);
    }

    static void printArr() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
    }

}
