package boj;// https://www.acmicpc.net/problem/2839
//
import java.util.Scanner;

public class Boj_2839 {
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int cnt_5 = 0, cnt_3 = 0, output = 0;
        cnt_5 = N / 5;
        N %= 5;
        output = cnt_3 + cnt_5;
        /*
        * 5로 나눈 뒤,
        * 1) 3의 배수이면 3으로 나눔
        * 2) 아니면 5카운트 -1하고, N += 5, 하고 3의 배수여부 확인
        * 만약, 5카운트 다 쓰면(cnt_5 == -1) 결과없으므로 끝
        * */
        while (N != 0) {
            if (N % 2 == 0 || N % 3 != 0){
                cnt_5 -= 1;
                N += 5;

            }
            if (cnt_5 == -1) {
                output = -1;
                break;
            }
            if (N % 3 == 0) {
                cnt_3 = N / 3;
                N %= 3;
                output = cnt_3 + cnt_5;
                break;
            }
        }
        System.out.println(output);
    }
}
