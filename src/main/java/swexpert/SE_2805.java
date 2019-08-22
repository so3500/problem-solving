/*
 * 문제: 2805. 농작물 수확하기 / 146 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB&categoryId=AV7GLXqKAWYDFAXB&categoryType=CODE
 * 알고리즘: 구현
 * 풀이방법:
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   입력 N일 때 2차원 배열의 N/2 만큼 탐색
 *   O(N^2)
 *
 * 공간복잡도(Space Complexity)
 *   입력 N일 때 2차원 배열 사용
 *   O(N^2)
 *
 * */


package swexpert;

import java.util.Scanner;

public class SE_2805 {

    public static void main(String[] args) {
        int T, t, r, c, N, income, upRow, downRow, col, leftCol, rightCol, q;
        int[][] map = new int[50][50];
        String input;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            N = sc.nextInt();
            for (r = 0; r < N; r++) {
                input = sc.next();
                for (c = 0; c < N; c++) {
                    map[r][c] = input.charAt(c) - 48;
                }
            }
            downRow = 0;
            upRow = N - 1;
            col = N / 2;
            leftCol = col;
            rightCol = col;
            q = N / 2;
            income = 0;
            // 중앙 줄을 제외하고, 맨 윗줄과 아랫줄에서부터 중앙 줄로 오면서 수익값을 더한다.
            // col 값은 1, 3, 5, ... N 까지 증가한다.(홀수)
            while (q-- > 0) {
                for (c = leftCol; c <= rightCol; c++) {
                    income += map[downRow][c];
                    income += map[upRow][c];
                }
                leftCol--;
                rightCol++;
                downRow++;
                upRow--;
            }
            // 마지막 중앙 줄에 있는 농작물의 값을 더한다.
            for (c = leftCol; c <= rightCol; c++) {
                income += map[downRow][c];
            }

            System.out.println("#" + t + " " + income);
        }

    }
}
