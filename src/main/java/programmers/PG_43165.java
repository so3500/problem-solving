/*
 * 문제: 43165 타켓넘버
 * problem-link: https://programmers.co.kr/learn/courses/30/lessons/43165
 * solution-link:
 */

package programmers;

public class PG_43165 {

    static class Solution {
        int size;
        int target;
        int answer;
        int[] numbers;

        public int solution(int[] numbers, int target) {
            init(numbers, target);
            dfs(numbers[0], 1);
            dfs(numbers[0] * -1, 1);
            return answer;
        }

        private void init(int[] numbers, int target) {
            this.numbers = numbers;
            this.target = target;
            this.size = numbers.length;
            this.answer = 0;
        }

        private void dfs(int sum, int idx) {
            if (idx == size && sum == target) {
                answer++;
            } else if (idx < size) {
                dfs(sum + numbers[idx], idx + 1);
                dfs(sum - numbers[idx], idx + 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        solution.solution(numbers, target); // answer: 5
    }

}
