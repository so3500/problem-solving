/*
 * 문제: 4522 세상의 모든 펠린드롬
 * link: https://www.acmicpc.net/problem/11933
 * 알고리즘 구현
 * 풀이방법:
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   O(N)
 *
 * 공간복잡도(Space Complexity)
 *   O(N)
 *
 * */

package swexpert;

import java.util.Scanner;

public class SE_4522 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t;
        boolean isPelindrom;
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            String word = sc.next();
            isPelindrom = isPelindrom(word);
            if (isPelindrom) {
                System.out.println("#" + t + " Exist");
            } else {
                System.out.println("#" + t + " Not exist");
            }
        }
        sc.close();
    }

    private static boolean isPelindrom(String word) {
        boolean isPelindrom = true;
        int left, right, wordLen;
        wordLen = word.length();
        if (wordLen == 1) {
            return isPelindrom;
        }

        if (wordLen % 2 == 0) {
            left = wordLen / 2 - 1;
            right = wordLen / 2;
        } else {
            left = wordLen / 2 - 1;
            right = wordLen / 2 + 1;
        }

        while (0 <= left && right < wordLen) {
            if (word.charAt(left) == word.charAt(right) ||
                    word.charAt(left) == '?' ||
                    word.charAt(right) == '?') {
                left--;
                right++;
            } else {
                isPelindrom = false;
                break;
            }
        }

        return isPelindrom;
    }

}
