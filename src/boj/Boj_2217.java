package boj;// 베르트랑 공준

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class Boj_2217 {

    private static int solve(int[] rope, int N){
        int maxWeight = Integer.MIN_VALUE;
        for (int i=N-1; i>=0 ; i--){
            maxWeight = Integer.max(maxWeight, rope[i] * (N - i));
        }
        return maxWeight;
    }

    public static void main(String args[]) throws Exception{
//        File f = new File("input.txt");
//        Scanner scanner = new Scanner(f);
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] rope = new int[N];
        for (int i=0; i<N; i++){
            rope[i] = scanner.nextInt();
        }
        Arrays.sort(rope);
        System.out.println(solve(rope, N));
    }
}
