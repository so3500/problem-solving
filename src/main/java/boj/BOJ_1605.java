package boj;

import java.util.Scanner;

public class BOJ_1605 {

    static class Solution {
        int strLen;
        int maxPatternLen;
        String str;

        public void solve() {
            init();
            findMaxPatternLen();
            System.out.println(maxPatternLen);
        }

        private void init() {
            Scanner sc = new Scanner(System.in);
            strLen = sc.nextInt();
            str = sc.next();
            maxPatternLen = 0;
            sc.close();
        }

        private void findMaxPatternLen() {
            int startLen = 0;
            int endLen = strLen;
            int patternLen = (startLen + endLen) / 2;
            while (startLen < endLen) {
                boolean find = false;
                for (int fromIdx = 0; fromIdx < strLen - patternLen; fromIdx++) {
                    String pattern = str.substring(fromIdx, fromIdx + patternLen);
                    find = isPatternRepeated(pattern);
                    if (find) {
                        break;
                    }
                }

//				 System.out.println(String.format("patternLen: %d", patternLen));
                // 이분탐색으로 패턴의 길이 수정
                // 반복 부분 문자열을 찾으면 길이 늘려보기, 못찾으면 길이 줄여보기
                if (find) {
                    maxPatternLen = Integer.max(maxPatternLen, patternLen);
                    startLen = patternLen + 1;
                    patternLen = (patternLen + endLen) / 2;
                } else {
                    endLen = patternLen - 1;
                    patternLen = (patternLen + startLen) / 2;
                }


            }
        }

        private boolean isPatternRepeated(String pattern) {
            boolean isRepeated = false;
            int repeatCnt = 0;
            int patternLen = pattern.length();
            int strHash = 0;
            int patternHash = 0;
            int power = 1;

            for (int i = 0; i <= strLen - patternLen; i++) {
                // 최초의 hash값 구하기
                if (i == 0) {
                    for (int j = 0; j < patternLen; j++) {
                        strHash = strHash + str.charAt(patternLen - 1 - j) * power;
                        patternHash = patternHash + pattern.charAt(patternLen - 1 - j) * power;
                        if (j < patternLen - 1) {
                            power *= 2;
                        }
                    }
                } else if (i > 0) {
                    strHash = 2 * (strHash - str.charAt(i - 1) * power) + str.charAt(patternLen - 1 + i);
                }

                // hash값이 동일할 경우 문자열 하나하나 검사
                if (strHash == patternHash) {
                    boolean isMathed = isPatternMatched(pattern, i);
                    if (isMathed) {
                        repeatCnt++;
                    }
                }

                if (repeatCnt > 1) {
                    isRepeated = true;
                    break;
                }
            }
            return isRepeated;
        }

        private boolean isPatternMatched(String pattern, int startIdx) {
            boolean isMatched = true;
            for (int idx = 0; idx < pattern.length(); idx++) {
                if (str.charAt(startIdx + idx) != pattern.charAt(idx)) {
                    isMatched = false;
                    break;
                }
            }
            return isMatched;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

}
