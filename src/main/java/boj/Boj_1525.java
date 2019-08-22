/*
 * 문제: 1525 퍼즐 / 536 ms
 * link: https://www.acmicpc.net/problem/1525
 * 알고리즘: BFS
 * 풀이방법:
 * 	방문 여부는 표를 9자리 수로 변환하여 해당 숫자가 set에 존재하는지 확인하는 방법으로 알 수 있다.
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *
 * 공간복잡도(Space Complexity)
 * */

package boj;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_1525 {

    static int N, minMoveCnt, startRow, startCol, goal, startState;
    static int[] rows = {-1, 0, 1, 0};
    static int[] cols = {0, 1, 0, -1};
    static HashSet<Integer> set;
    static Queue<Point> q;

    static class Point {
        int r, c, cnt, state;

        public Point(int r, int c, int state, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.state = state;
        }
    }

    public static void main(String[] args) {
        init();
        solve();
        System.out.println(minMoveCnt);
    }

    static void init() {
        Scanner sc = new Scanner(System.in);
        int input;
        N = 3;
        startState = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                input = sc.nextInt();
                startState += input * (int) Math.pow(10, (2 - r) * 3 + (2 - c));
                if (input == 0) {
                    startRow = r;
                    startCol = c;
                }
            }
        }
        q = new LinkedList<>();
        set = new HashSet<>();
        goal = 123456780;
        minMoveCnt = -1;
        sc.close();
    }

    static void solve() {
        Point p;
        int toR, toC, toState;
        q.add(new Point(startRow, startCol, startState, 0));
        set.add(startState);
        while (!q.isEmpty()) {
            p = q.poll();

            // 목표 지점에 도달할 경우 BFS 종료
            if (p.state == goal) {
                minMoveCnt = p.cnt;
                break;
            }

            /*
             * 3*3 표를 9자리 숫자로 변환(getState 함수 사용) -> 변환한 수가 set에 없으면 방문하지 않은 정점이므로 BFS를 위한 큐에 추가
             * p.r, p.c 는 숫자 0이 위치한 (row, col)
             * toR, toC 는 숫자 0과 자리를 바꿀 (row, col)
             *
             * 표에서 각 자릿수에 10^k (k:0 ~ 8) 을 곱하여 변환한다.
             * 10^8 10^7 10^6
             * 10^5 10^4 10^3
             * 10^2 10^1 10^0
             *
             * */

            for (int i = 0; i < 4; i++) {
                toR = p.r + rows[i];
                toC = p.c + cols[i];
                if (toR < 0 || toC < 0 || N <= toR || N <= toC) continue;
                toState = getState(p.state, p.r, p.c, toR, toC);
                if (set.contains(toState)) continue;
                set.add(toState);
                q.add(new Point(toR, toC, toState, p.cnt + 1));
            }
        }
    }

    static int getState(int state, int r, int c, int toR, int toC) {
        int ret, fromExp, toExp, num, digit;
        ret = 0;
        fromExp = (2 - r) * 3 + (2 - c);   // 0의 지수
        toExp = (2 - toR) * 3 + (2 - toC); // 목표 숫자의 지수

        ret = state;
        if (toExp == 0) {
            digit = state % 10;
            num = digit;
        } else {
            // e.g. 876,543,201 -> 43,201 -> 4
            // digit: 4
            // num: 40,000
            digit = state % (int) Math.pow(10, toExp + 1);
            digit = digit / (int) Math.pow(10, toExp);
            num = digit * (int) Math.pow(10, toExp);
        }
        // e.g. 876,543,201
        // -> 876,503,201
        // -> 876,503,241
        ret -= num;
        ret += digit * (int) Math.pow(10, fromExp);

        return ret;
    }

}
