/*
 * 문제: 12797 지금 밥이 문제냐
 * problem-link: https://www.acmicpc.net/problem/12787
 * solution-link:
 */

package boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_12797 {

    static Scanner sc;
    static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        sc = new Scanner(System.in);
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        int test_case = sc.nextInt();
        for (int tc = 0; tc < test_case; tc++) {
            int mode = sc.nextInt();
            if (mode == 1) {
                addrToNum();
            } else if (mode == 2) {
                numToAddr();
            }
        }
        out.flush();
        out.close();
        sc.close();
    }

    private static void addrToNum() throws IOException {
        String[] addr = sc.next().split("\\.");
        BigInteger num = BigInteger.ZERO;
        long mask = 0xFF;
        for (int idx = 0; idx < addr.length; idx++) {
            long numForAdded = (mask & Long.parseLong(addr[idx]));
            num = num.add(BigInteger.valueOf(numForAdded));
            if (idx < addr.length - 1) {
                num = num.shiftLeft(8);
            }
        }
        out.write(num + "\n");
    }

    private static void numToAddr() throws IOException {
        long input = Long.parseUnsignedLong(sc.next());
        BigInteger num = BigInteger.valueOf(input);
        BigInteger mask = BigInteger.valueOf(0xFF);
        StringBuilder sb = new StringBuilder();
        for (int cnt = 0; cnt < 8; cnt++) {
            BigInteger addr = num.and(mask);
            num = num.shiftRight(8);
            sb.insert(0, addr);
            if (cnt < 7) {
                sb.insert(0, ".");
            }
        }
        sb.append("\n");
        out.write(sb.toString());
    }

}
