package boj;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Boj_2565 {
    /*
     * 전깃줄
     * */

    static int[][] S;
    static int[] cache; // cache[i]: i에서 시작했을 때 최대 전기줄
    static int len;

    private static int max(int a, int b) {
        return (a >= b ? a : b);
    }

    private static void input() {
        try {
            File f = new File("input.txt");
            Scanner s = new Scanner(f);
//            Scanner s = new Scanner(System.in);
            len = s.nextInt();
            S = new int[len][2];
            cache = new int[len];
            for (int i = 0; i < len; i++) {
                S[i][0] = s.nextInt();
                S[i][1] = s.nextInt();
                cache[i] = -1;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void sortArray(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                // 0열을 기준으로 정렬
                int a = arr1[0];
                int b = arr2[0];
                return Integer.compare(a, b);
            }
        });
    }

    private static int lis(int start) {
        int ret = cache[start];
        // cache[start] 값이 -1이 아니다. == start에서 시작해서 나오는 큰 부분수열의 길이가 있다.
        if (ret != -1) return ret;
        // 시작길이는 1
        ret = 1;
        cache[start] = ret;
        for (int next = start + 1; next < len; next++) {
            // next가 클 경우, next에서 시작하여 나오는 부분합의 길이의 최대와 S[start]비교
            // 큰 값을 cache[start]로 업데이트
            if (S[start][1] < S[next][1]) {
                ret = max(ret, lis(next) + 1);
                cache[start] = ret;
            }
        }
        return ret;
    }

    private static void print(int[][] arr) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(S[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        input();
        sortArray(S);
//        print(S);
        int maxLen = -1;
        for (int begin = 0; begin < len; begin++) {
            maxLen = max(maxLen, lis(begin));
        }
        System.out.println(len - maxLen);
    }
}