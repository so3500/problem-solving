package boj;// 가장 큰 정사각형
//
// 다이나믹 프로그래밍, 동적 계획법
//
//
/*
* 가장 큰 정사각형
* https://www.acmicpc.net/problem/1915
* 알고리즘: 다이나믹 프로그래밍(동적 계획법)
* 풀이방법: matrix[row][col]은 해당 정사각형의 맨 오른쪽 아래이며 길이 정보를 저장한다.
* 의사코드:
*   input n, m
*   declare matrix[n][m]
*   for row 0 to n-1
*       find maxValue(1) in matrix[row][0]
*   for col 0 to m-1
*       find maxValue(1) in matrix[0][col]
*   for row 1 to n-1
*       for col 1 to m-1
*           if matrix[row][col] = 1
*               matrix[row][col] <- min(matrix[row-1, col-1], matrix[row, col-1], matrix[row-1, col]) + 1
*               answer <- max(answer, matrix[row][col])
*
*   return answer^2
*
* 시간복잡도(Time Complexity)
*   입력 n,m 에 대하여 m*n matrix 연산 O(n*m)
*
* 공간복잡도(Space Complexity)
*   입력 n,m 에 대하여 m*n matrix 사용 O(n*m)
* */


import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class Boj_1915 {

    private static int getMin(int a, int b, int c){
        return Integer.min(Integer.min(a, b), Integer.min(b, c));
    }

    private static int solve(int[][] matrix){
        int answer = 0;
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int row, col;
        for (row = 0; row < rowLength; row++){
            if (answer == 1) break;
            answer = Integer.max(answer, matrix[row][0]);
        }
        for (col = 0; col < colLength; col++){
            if (answer == 1) break;
            answer = Integer.max(answer, matrix[0][col]);
        }
        for (row = 1; row < rowLength; row++){
            for (col = 1; col <colLength; col++){
                if (matrix[row][col] == 1) {
                    matrix[row][col] = getMin(matrix[row - 1][col - 1], matrix[row - 1][col], matrix[row][col - 1]) + 1;
                    answer = Integer.max(answer, matrix[row][col]);
                }
            }
        }
        return answer*answer;
    }

    public static void main(String args[]) throws Exception{
//        File f = new File("input.txt");
//        Scanner scanner = new Scanner(f);
        Scanner scanner = new Scanner(System.in);
        int n, m;
        int[][] matrix;
        String numberString;
        n = scanner.nextInt();
        m = scanner.nextInt();
        matrix = new int[n][m];
        for (int row=0; row<n; row++) {
            numberString = scanner.next();
            for (int col = 0; col < m; col++) {
                matrix[row][col] = (int)numberString.charAt(col) - 48;
            }
        }
        System.out.println(solve(matrix));
    }
}

