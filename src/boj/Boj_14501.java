package boj;// 퇴사

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class Boj_14501 {
//    private static Scanner scanner;

//    private static int getMax(int[][] table, int[] cache, int start){
//        int ret = cache[start];
//        if (ret != -1) return ret;
//        ret = table[start][1];
//        cache[start] = ret;
//        for (int next = start + table[start][0]; next < table.length; next += table[next][0]){
//            ret = Integer.max(ret, getMax(table, cache, next) + ret);
//            cache[start] = ret;
//        }
//        return ret;
//    }

    private static int solve(int[][] table, int[] cache, int N){
        int maxVal = 0;
        for (int i = N - 1 ; i >= 0 ; i--){
            if (i + table[i][0] > N){
                cache[i] = 0;
            }
            else{
                // 해당 날의 price 와 그 날 이후 최대 price 구하기
                // 해당 날에서 시작하지 않고 이후 날 만 고려한 최대값 구할 수 있음
                cache[i] = Integer.max(maxVal, table[i][1] + cache[i + table[i][0]]);
                maxVal = Integer.max(maxVal, cache[i]);
            }
            // price 중 max_price 구하기
            cache[i] = maxVal;
        }
        return maxVal;
    }

    public static void main(String[] args) {
//        File f = new File("input.txt");
//
//        try {
//            scanner = new Scanner(f);
//        } catch (Exception e){
//            System.out.println(e);
//        }
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int [][] table = new int[N+5][2];
        int [] cache = new int[N+5];
        Arrays.fill(cache, 0);
        for (int i=0; i<N; i++){
            table[i][0] = scanner.nextInt(); // T time
            table[i][1] = scanner.nextInt(); // P pay
        }
        System.out.println(solve(table, cache, N));
    }
}
