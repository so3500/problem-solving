package codeground;

/*
* 문제: 38 / 기타대회 / 하노이 타워 / 재귀: 0.10459, 스택: 0.11732
* link: https://www.codeground.org/practice
* 알고리즘: 구현, 재귀
* 풀이방법:
*   N개의 원판 중 N-1개를 중간 지점으로 옮긴다.
*   N번째 원판을 마지막 지점으로 옮긴다.
*   N-1개 원판을 다시 마지막 지점으로 옮긴다.
*
* 의사코드(Pseudo Code)
*   input T
*   each T
*       input N
*       hanoiRecursive(N, start, mid, end)
*
*
*   // hanoiRecursive
*   hanoiRecursive(N, start, mid, end)
*       if N = 1
*           print(start + " -> " + end)
*       else
*           hanoiRecursive(N-1, start, end, mid) // move N-1 disks from "start" to "mid"
*           print(start + " -> " + end)
*           hanoiRecursive(N-1, mid, start, end) // move N-1 disks from "mid" to "end"
*
* 시간복잡도(Time Complexity)
*   입력 N이 주어질 때, N개의 원판을 이동해야 함. 하노이 탑 문제는 an = 2^n + 1 의 점화식을 가짐
*   O(2^N)
*
* 공간복잡도(Space Complexity)
*
*
* */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

//class Solution {
class HanoiTop {
    static class diskMoveInfo {
        int N, start, mid, end;
        boolean move;

        diskMoveInfo(int N, int start, int mid, int end, boolean move) {
            this.N = N;
            this.start = start;
            this.mid = mid;
            this.end = end;
            this.move = move;
        }
    }

    static int Answer;

    private static void hanoiRecursive(int N, int start, int mid, int end) {
        if (N == 1) {
            System.out.println(start + " -> " + end);
        } else {
            hanoiRecursive(N - 1, start, end, mid);
            System.out.println(start + " -> " + end);
            hanoiRecursive(N - 1, mid, start, end);
        }
    }

    private static void hanoiStack(int N_, int start_, int mid_, int end_) {
        Stack<diskMoveInfo> infoStack = new Stack<diskMoveInfo>();
        diskMoveInfo info = new diskMoveInfo(N_, start_, mid_, end_, false);
        infoStack.push(info);

        int N, start, mid, end;
        boolean move;

        while (!infoStack.empty()) {
            diskMoveInfo moveInfo = infoStack.pop();
            N = moveInfo.N;
            start = moveInfo.start;
            mid = moveInfo.mid;
            end = moveInfo.end;
            move = moveInfo.move;

            if (move) {
//                System.out.println(start + " -> " + end);
            } else if (N > 0) {
                infoStack.push(new diskMoveInfo(N - 1, mid, start, end, false));
                infoStack.push(new diskMoveInfo(N, start, mid, end, true));
                infoStack.push(new diskMoveInfo(N - 1, start, end, mid, false));
            }
        }
    }

    public static void main(String args[]) throws Exception {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("input.txt"));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt")); // BufferedReader for file
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader for keyboard

        int T = sc.nextInt();
//        int T = Integer.parseInt(br.readLine()); // br
//        StringTokenizer st = new StringTokenizer(br.readLine()); // line 기준 입력
//        Integer.parseInt(st.nextToken()); // 공백 기준 입력 e.g. 1 2 3 4 5 받을 때
        int N;

        long start, end;

        for (int test_case = 0; test_case < T; test_case++) {
//            start = System.currentTimeMillis();
            N = sc.nextInt();
            System.out.println("Case #" + (test_case + 1));
            hanoiRecursive(N, 1, 2, 3);
//            hanoiStack(N, 1, 2, 3);
//            end = System.currentTimeMillis();
//            System.out.print("Case #" + (test_case + 1));
//            System.out.println(" time: " + (end - start) / 1000.0);
        }
//        System.out.println("====================");
//        for (int test_case = 0; test_case < T; test_case++) {
//            start = System.currentTimeMillis();
//            N = sc.nextInt();
////            System.out.println("Case #" + (test_case + 1));
////            hanoiRecursive(N, 1, 2, 3);
//            hanoiStack(N, 1, 2, 3);
//            end = System.currentTimeMillis();
//            System.out.print("Case #" + (test_case + 1));
//            System.out.println(" time: " + (end - start) / 1000.0);
//        }


    }
}
