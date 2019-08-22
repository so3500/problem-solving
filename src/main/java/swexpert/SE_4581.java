package swexpert;

import java.util.Scanner;

public class SE_4581 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t;
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            String in = sc.next();
            String out = getWord(in);
            System.out.println("#" + t + " " + out);
        }
        sc.close();
    }

    private static String getWord(String word) {
        StringBuilder sb = new StringBuilder();
        int leftIdx, rightIdx, wordLen;
        char left, right, inLeft, inRight; // left inLeft ... inRight right
        wordLen = word.length();

        if (wordLen == 1) {
            return word;
        }

        leftIdx = 0;
        rightIdx = wordLen - 1;
        while (leftIdx <= rightIdx) {
            left = word.charAt(leftIdx);
            right = word.charAt(rightIdx);

            if (right - left <= 1) {
                if (left < right) {
                    sb.append(left);
                    leftIdx++;
                } else {
                    sb.append(right);
                    rightIdx--;
                }
            } else { // left, right 사이에 2개 이상의 문자가 있을 때는 더 안쪽 문자도 검사
                if (left < right) {
                    sb.append(left);
                    leftIdx++;
                } else if (left > right) {
                    sb.append(right);
                    rightIdx--;
                } else {
                    inLeft = word.charAt(left + 1);
                    inRight = word.charAt(right - 1);
                    if (inLeft < inRight) {
                        sb.append(left);
                        leftIdx++;
                    } else {
                        sb.append(right);
                        rightIdx--;
                    }
                }

            }
        }
        return sb.toString();
    }

}
