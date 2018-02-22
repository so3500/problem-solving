/*
 * 문제: 집합 11723 / 3344 ms
 * link: https://www.acmicpc.net/problem/11723
 * 알고리즘: 비트연산, Buffer 사용
 * 풀이방법:
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *
 * 공간복잡도(Space Complexity)
 *
 * */

package boj;

import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Boj_11723 {
    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(new File("input.txt"));
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M, i, x, S, allS, digit;
        String order;
        M = sc.nextInt();
        S = 0;
        allS = (1 << 20) - 1;
        for (i = 0; i < M; i++) {
            order = sc.next();
            if (order.equals("all")) {
                S = allS;
            } else if (order.equals("empty")) {
                S = 0;
            } else {
                x = sc.nextInt();
                digit = 1 << (x - 1);
                switch (order) {
                    case "add":
                        S = S | digit;
                        break;
                    case "remove":
                        S = S & (allS - digit);
                        break;
                    case "check":
                        if ((S & digit) > 0) bw.write("1\n");
                        else bw.write("0\n");
                        break;
                    case "toggle":
                        if ((S & digit) > 0) S = S & (allS - digit);
                        else S = S | digit;
                        break;
                }
            }
        }
        bw.flush();
        bw.close();
        sc.close();
    }
}
