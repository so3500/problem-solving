/*
 * 문제: 10799 쇠막대기
 * problem-link: https://www.acmicpc.net/problem/10799
 * solution-link:
 *
 * 1. '(' 일 경우
 * 	stickCnt++
 * 	바로 다음에 ')'가 올 경우 레이저가 되므로 isStick 플래그 false
 *
 * 2. ')' && isStick
 * 	쇠막대기가 끝나므로 answr++
 * 	stickCnt--;
 *
 * 3. ')'
 * 	레이저이므로 stickCnt만큼 더하기
 * 	stickCnt--;
 * 	바로 다음에 ')'가 올 경우 쇠막대기가 되므로 isStick 플래그 true
 */

package boj;

import java.util.Scanner;

public class BOJ_10799 {

    static class Solution {

        public void solution() {
            Scanner sc = new Scanner(System.in);
            String arrangement = sc.next();
            sc.close();

            int answer = 0;
            int stickCnt = 0;
            boolean isStick = false;
            for (int idx = 0; idx < arrangement.length(); idx++) {
                char chr = arrangement.charAt(idx);
                if (chr == '(') {
                    stickCnt++;
                    isStick = false;
                } else if (chr == ')' && isStick) {
                    answer++;
                    stickCnt--;
                } else if (chr == ')') {
                    stickCnt--;
                    answer += stickCnt;
                    isStick = true;
                }
            }

            System.out.println(answer);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution();
    }

}
