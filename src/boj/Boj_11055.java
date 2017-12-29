package boj;

import java.util.Scanner;

public class Boj_11055 {
        /*
    * 최대 부분 증가 수열
    *
    * */

    private static int[] S;
    private static int[] cache;
    private static int len;

    private static int max(int a, int b){
        return (a >= b ? a : b);
    }

    private static int lis2(int start){
        int ret = cache[start];
        // cache[start]의 값이 -1이 아니다 == start에서 시작해서 나오는 큰 부분수열 값이다.
        if(ret != -1) return ret;
        // 시작값은 S[start]
        ret = S[start];
        cache[start] = ret;
        for(int next = start+1; next < len; next++){
            // S[next]가 더 클 경우, next에서 시작하여 나오는 부분합의 최대와 S[start]비교
            // 큰 값을 cache[start]로 업데이트
            if(S[start] < S[next]){
                // 1 100 2 50 60 3 5 6 에서 1 100 2 까지 감
                ret = max(ret, lis2(next) + S[start]);
                cache[start] = ret;
            }
        }
        return ret;
    }

    private static void input(){
        Scanner s = new Scanner(System.in);
        len = s.nextInt();
        S = new int[len];
        cache = new int[len];
        for (int i=0; i<len; i++){
            S[i] = s.nextInt();
            cache[i] = -1;
        }
    }

    public static void main(String[] args) {
        input();
//      dp[i]: i에서 시작한 부분합 중 가장 큰 값
        int maxSum = -1;
        // begin에서 시작하여 나올 수 있는 가장 큰 부분 합
        for (int begin = 0; begin<len; begin++){
            maxSum = max(maxSum, lis2(begin));
        }
//        for(int i=0; i<len; i++){
//            System.out.print(cache[i] + " ");
//        }
        System.out.print(maxSum);
    }
}
