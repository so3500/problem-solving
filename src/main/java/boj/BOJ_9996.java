/*
 * 문제: 9996 한국이 그리울 땐 서버에 접속하지
 * link: https://www.acmicpc.net/problem/9996
 * 알고리즘: 문자열 처리
 * 풀이방법:
 * 	패턴의 * 인덱스를 구한다(pIdx)
 * 	패턴의 인덱스 0 부터 pIdx-1 까지 파일명과의 일치여부 검사
 * 	패턴의 인덱스 pLen-1 부터 pIdx+1까지 파일명과의 일치여부 검사
 *	앞, 뒤 패턴이 모두 일치할 경우 DA 아닐경우 NE
 */

package boj;

import java.util.Scanner;

public class BOJ_9996 {

    static class Solution {
        int N;
        int starIdx;
        int pLen;
        int lastMatchedFileIdx; // 파일명 문자열의 중복검사 방지를 위한 인덱스
        char[] pattern;
        char[] file;

        public void solve() {
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt();
            pattern = sc.next().toCharArray();
            pLen = pattern.length;
            starIdx = getStarIdx();
            lastMatchedFileIdx = 0;

            for (int query = 0; query < N; query++) {
                file = sc.next().toCharArray();
                boolean isMatched = (compareBefore(0, starIdx) && compareAfter(pLen - 1, starIdx));
                if (isMatched) {
                    System.out.println("DA");
                } else {
                    System.out.println("NE");
                }
            }

            sc.close();
        }

        int getStarIdx() {
            int starIdx = 0;
            for (int idx = 0; idx < pLen; idx++) {
                if (pattern[idx] == '*') {
                    starIdx = idx;
                    break;
                }
            }
            return starIdx;
        }

        boolean compareBefore(int fromIdx, int toIdx) {
            boolean isMatched = true;
            int fIdx = 0;
            for (int pIdx = fromIdx; pIdx < toIdx; pIdx++) {
                if (pattern[pIdx] == file[fIdx]) {
                    fIdx++;
                } else {
                    isMatched = false;
                    break;
                }
            }
            lastMatchedFileIdx = fIdx - 1;
            return isMatched;
        }

        boolean compareAfter(int fromIdx, int toIdx) {
            boolean isMatched = true;
            int fIdx = file.length - 1;
            for (int pIdx = fromIdx; pIdx > toIdx; pIdx--) {
                if (pattern[pIdx] == file[fIdx] && fIdx > lastMatchedFileIdx) {
                    fIdx--;
                } else {
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
