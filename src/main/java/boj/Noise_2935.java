package boj;

import java.util.Scanner;

public class Noise_2935 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer A = new StringBuffer();
        StringBuffer B = new StringBuffer();
        StringBuffer output;
        String operator;
        int aLen, bLen;

        // 입력
        A.append(sc.nextLine());
        operator = sc.nextLine();
        B.append(sc.nextLine());

        if (A.length() >= B.length()) {
            output = operation(A, B, operator);
        } else {
            output = operation(B, A, operator);
        }
        System.out.println(output);
    }

    private static StringBuffer operation(StringBuffer longerBuffer, StringBuffer shorterBuffer, String operator) {
        int diffLen;
        if (operator.equals("+")) {
            diffLen = longerBuffer.length() - shorterBuffer.length();
            if (diffLen == 0) {
                longerBuffer.replace(0, 1, "2");
            } else if (diffLen > 0) {
                longerBuffer.replace(diffLen, diffLen + 1, "1");
            }
        } else if (operator.equals("*")) {
            longerBuffer.append(shorterBuffer.substring(1));
        }
        return longerBuffer;
    }
}
