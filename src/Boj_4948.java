// 베르트랑 공준

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class Boj_4948 {

    private static int solve(boolean[] prime, int n){
        int cnt=0;
        int end = Integer.min(2*n, prime.length-1);
        for (int i=n+1 ; i<= end ; i++){
            if (prime[i]){
                cnt += 1;
            }
        }
        return cnt;
    }

    private static void getPrime(boolean[] prime){
        int idx;
        for (int i=2; i<prime.length; i++){
            if (prime[i]){
                idx = i*2;
                while (idx < prime.length){
                    prime[idx] = false;
                    idx += i;
                }
            }
        }
    }

    public static void main(String args[]) throws Exception{
        File f = new File("input.txt");
        Scanner scanner = new Scanner(f);
//        Scanner scanner = new Scanner(System.in);
        int n;
        boolean[] prime = new boolean[123456*2];
        Arrays.fill(prime, true);
        getPrime(prime);
        while (true){
            n = scanner.nextInt();
            if (n == 0) break;
            System.out.println(solve(prime, n));
        }
    }
}
