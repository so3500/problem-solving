/*
 * 문제: 1963 소수경우 / 136 ms
 * link: https://www.acmicpc.net/problem/1963
 * 알고리즘: BFS, 에라토스테네스의 체(소수)
 * 풀이방법:
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *
 * 공간복잡도(Space Complexity)
 *
 * */

package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1963 {

    static int from, to;
    static boolean[] prime, visited;
    static Queue<Number> q;

    static class Number {
        int num, cnt;

        public Number(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        int T, t, minCnt;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        prime = new boolean[10000];
        Arrays.fill(prime, true);
        getPrime();
        for (t = 1; t <= T; t++) {
            init(sc);
            minCnt = bfs();
            System.out.println(minCnt);
        }
        sc.close();
    }

    static void init(Scanner sc) {
        from = sc.nextInt();
        to = sc.nextInt();
        q = new LinkedList<>();
        q.add(new Number(from, 0));
        visited = new boolean[10000];
        visited[from] = true;
    }

    static int bfs() {
        int minCnt, num, toNum, toDigit, digit, cnt, a;
        minCnt = -1;
        Number n;
        while (!q.isEmpty()) {
            n = q.poll();
            num = n.num;
            cnt = n.cnt;
            if (num == to) {
                minCnt = cnt;
                break;
            }

            // 천의 자리수를 1~9로 변경
            // 변경한 숫자가 소수이면서 방문하지 않은 숫자인 경우 큐에 추가
            for (a = 1; a <= 9; a++) {
                toNum = num;
                digit = toNum / 1000;
                toNum -= digit * 1000;
                toNum += a * 1000;
                if (prime[toNum] && !visited[toNum]) {
                    q.add(new Number(toNum, cnt + 1));
                    visited[toNum] = true;
                }
            }
            // 백, 십, 일의 자리수를 0~9로 변경
            // 변경한 숫자가 소수이면서 방문하지 않는 경우 큐에 추가
            for (toDigit = 1; toDigit <= 100; toDigit *= 10) {
                for (a = 0; a <= 9; a++) {
                    toNum = num;
                    digit = (toNum / toDigit) % 10;
                    toNum -= digit * toDigit;
                    toNum += a * toDigit;
                    if (prime[toNum] && !visited[toNum]) {
                        q.add(new Number(toNum, cnt + 1));
                        visited[toNum] = true;
                    }
                }
            }
        }
        return minCnt;
    }

    static void getPrime() {
        for (int start = 2; start <= 9999; start++) {
            for (int num = start * start; num <= 9999; num += start) {
                if (!prime[num]) // 4의 경우, 4의배수는 이미 모두 소수가 아님으로 체크됬으므로 pass
                    continue;
                prime[num] = false;
            }
        }
    }
}
