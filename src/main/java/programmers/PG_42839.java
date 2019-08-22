/*
 * 문제: 42839 소수찾기
 * link: https://programmers.co.kr/learn/courses/30/lessons/42839
 * 알고리즘: 소수(에라토스테네스의 체), 완전탐색
 * 풀이방법:
 *
 */

package programmers;

import java.util.Arrays;
import java.util.HashSet;

public class PG_42839 {

    static class Solution {
        int maxNum;
        HashSet<Integer> primeSet;
        char[] numbers;
        int numLen;
        boolean[] visited;
        boolean[] isPrime;

        public int solution(String numbers) {
            init(numbers);
            initPrime(numbers.length());
            solve(0, 1);
            int answer = primeSet.size();
            return answer;
        }

        private void init(String numbers) {
            this.numbers = numbers.toCharArray();
            numLen = this.numbers.length;
            visited = new boolean[numLen];
            primeSet = new HashSet<>();
        }

        // 에라토스테네스의 체를 사용하여 소수여부를 판별하는 배열 생성
        private void initPrime(int numLen) {
            maxNum = (int) Math.pow(10, numLen);
            isPrime = new boolean[maxNum];

            Arrays.fill(isPrime, true);
            isPrime[0] = false;
            isPrime[1] = false;
            int startNum = 2;
            while (startNum < maxNum) {
                if (!isPrime[startNum]) {
                    startNum++;
                } else {
                    int num = startNum * 2;
                    while (num < maxNum) {
                        isPrime[num] = false;
                        num += startNum;
                    }
                    startNum++;
                }
            }

        }

        // 종이조각으로 만들 수 있는 모든 숫자의 조합을 생성한 뒤 소수여부 판별
        private void solve(int num, int cipher) {
            // 소수 중복 여부 및 소수 여부 판별
            if (!primeSet.contains(num) && isPrime[num]) {
                primeSet.add(num);
            }

            for (int idx = 0; idx < numLen; idx++) {
                if (!visited[idx]) {
                    visited[idx] = true;
                    int digit = numbers[idx] - '0';
                    solve(num + digit * cipher, cipher * 10);
                    visited[idx] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] numbers = {"17", "011", "0", "11"};
        for (String number : numbers) {
            System.out.println(solution.solution(number));
        }
    }

}
