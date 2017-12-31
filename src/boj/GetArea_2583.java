
/* 영역구하기
* https://www.acmicpc.net/problem/2583
* 알고리즘: DFS
* 풀이방법:
*   matrix[row][col]에 직사각형 정보를 저장한다. true: 직사각형 칠함.
*   DFS 알고리즘(해당 cell 의 Up, Right, Down, Left 가 false 여부인지 살핌)을 위해 위아래, 오른쪽왼쪽 한줄 씩 더 추가
*
* 의사코드:
*   static area <- 0
*   input M, N, K
*   init matrix[M+2][N+2] with false
*   Outside rectangle of matrix <- false
*   for i:0 to K-1
*       input x1, y1, x2, y2 and plus 1
*       for row: y1 to y1-1
*           for col: x1 to x1-1
*               matrix[row][col] <- true
*
*    for row: 1 to M
*       for col: 1 to N
*           if matrix[row][col] not true
*               area <- 1
*               DFS(matrix, row, col)
*
*   // 정보 출력
*
*   DFS(matrix, row, col)
*       matrix[row][col] <- true
*       if up of matrix[row][col] not true
*           ret <- ret + 1
*           DFS(matrix, row-1, col)
*       if right of matrix[row][col] not true
*            ret <- ret + 1
*            DFS(matrix, row, col+1)
*       if down of matrix[row][col] not true
*            ret <- ret + 1
*            DFS(matrix, row+1, col)
*       if left of matrix[row][col] not true
*            ret <- ret + 1
*            DFS(matrix, row, col-1)
*
* 시간복잡도(Time Complexity)
*   row M, col N 인 2차원 배열 초기화
*   최악의 경우 DFS 에서 M*N 개의 cell 탐색
*   O(MN)
*
* 공간복잡도(Space Complexity)
*   row M, col N 인 2차원 배열 초기화
*   O(MN)
*
* */

package boj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//public class Main {
public class GetArea_2583 {
    //    static int numberOfArea;
    static int ret = 0;

    private static void printMatrix(boolean[][] matrix) {
        int row, col;
        for (row=0; row<matrix.length; row++){
            for (col=0; col<matrix[0].length; col++) {
                System.out.print(matrix[row][col] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("input.txt"));

        int M, N, K;
        int row, col, i, x1, x2, y1, y2;
        boolean[][] matrix = null;
        int numberOfArea;
        int[] area = new int[10000];

        // 변수 입력 및 초기화
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        matrix = new boolean[M + 2][N + 2];
        numberOfArea = 0;
        Arrays.fill(area, 0);
        for (row = 0; row <= M + 1; row++) {
            Arrays.fill(matrix[row], false);
        }
//        printMatrix(matrix);
        // 바깥 네 변에 대해서 true(visited)로 초기화
        for (col = 0; col <= N + 1; col++) {
            matrix[0][col] = true;
            matrix[M + 1][col] = true;
        }
        for (row = 0; row <= M + 1; row++) {
            matrix[row][0] = true;
            matrix[row][N + 1] = true;
        }
//        printMatrix(matrix);
//        System.out.println();

        // (x1, y1) 부터 (x2, y2)까지 true(visited)로 초기화, 실제 연산 순서는 (x1, y2) to (x2, y1)
        for (i = 0; i < K; i++) {
            x1 = sc.nextInt() + 1;
            y1 = sc.nextInt() + 1;
            x2 = sc.nextInt() + 1;
            y2 = sc.nextInt() + 1;
            for (row = y1; row < y2; row++) {
                for (col = x1; col < x2; col++) {
                    matrix[row][col] = true;
                }
            }
        }
//        printMatrix(matrix);

        // DFS
        for (row = 1; row <= M; row++) {
            for (col = 1; col <= N; col++) {
                if (!matrix[row][col]) {
                    ret = 1;
                    DFS(matrix, row, col);
                    area[numberOfArea] = ret;
                    numberOfArea += 1;
                }
            }
        }

        Arrays.sort(area, 0, numberOfArea);

        // 결과 출력
        StringBuffer sb = new StringBuffer();
        sb.append(numberOfArea + "\n");
//        System.out.print(numberOfArea);
        for (i = 0; i <= numberOfArea - 1; i++) {
            sb.append(area[i] + " ");
        }

        System.out.println(sb);
    }

    private static void DFS(boolean[][] matrix, int row, int col) {
        matrix[row][col] = true;
        if (!matrix[row - 1][col]) {
            ret += 1;
            DFS(matrix, row - 1, col);
        }
        if (!matrix[row][col + 1]) {
            ret += 1;
            DFS(matrix, row, col + 1);
        }
        if (!matrix[row + 1][col]) {
            ret += 1;
            DFS(matrix, row + 1, col);
        }
        if (!matrix[row][col - 1]) {
            ret += 1;
            DFS(matrix, row, col - 1);
        }
    }
}
