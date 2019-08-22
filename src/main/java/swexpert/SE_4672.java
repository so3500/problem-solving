// 수진이의 펠린드롬

package swexpert;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SE_4672 {

    private static String W;
    private static char[] word;
    private static boolean[] visited;
    private static int wLen, ans;
    private static boolean[][] isPelindrom;
    private static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        int T, t;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            init(sc);
            wordComb(0, 0);
            System.out.println("#" + t + " " + ans);
        }
        sc.close();
    }

    private static void init(Scanner sc) {
        W = sc.next();
        wLen = W.length();
        word = new char[wLen];
        visited = new boolean[wLen];
        set.clear();
        ans = 0;
    }

    // 문자열의 모든 조합 생성
    private static void wordComb(int idx, int wordCnt) {
        if (wordCnt == wLen) {
            String tempWord = String.copyValueOf(word);
            if (!set.contains(tempWord)) {
                set.add(tempWord);
                isPelindrom = new boolean[wLen][wLen];
                int pCnt = getPelindromCnt();
                ans = Integer.max(ans, pCnt);
            }
            return;
        }

        for (int i = 0; i < wLen; i++) {
            if (!visited[i]) {
                visited[i] = true;
                word[wordCnt] = W.charAt(i);
                wordComb(i, wordCnt + 1);
                visited[i] = false;
            }
        }

    }

    // 생성된 문자열로부터 펠린드롬 개수 구하기
    private static int getPelindromCnt() {
        int ans, left, right, i, len;
        ans = 0;

        len = 1;
        left = 0;
        right = 0;
        for (i = 1; i <= wLen - len + 1; i++) {
            isPelindrom[left][right] = true;
            left++;
            right++;
            ans++;
        }

        len = 2;
        left = 0;
        right = left + 1;
        for (i = 1; i <= wLen - len + 1; i++) {
            if (word[left] == word[right]) {
                isPelindrom[left][right] = true;
                ans++;
            }
            left++;
            right++;
        }

        for (len = 3; len <= wLen; len++) {
            left = 0;
            right = left + len - 1;
            for (i = 1; i <= wLen - len + 1; i++) {
                if (word[left] == word[right] && isPelindrom[left + 1][right - 1]) {
                    isPelindrom[left][right] = true;
                    ans++;
                }
                left++;
                right++;
            }
        }
        return ans;
    }

}
