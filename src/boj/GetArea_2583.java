package boj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class GetArea_2583 {
    //    static int numberOfArea;
    static int ret = 0;

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
        // 바깥 네 변에 대해서 true(visited)로 초기화
        for (col = 0; col <= N + 1; col++) {
            matrix[0][col] = true;
            matrix[M + 1][col] = true;
        }
        for (row = 0; row <= M + 1; row++) {
            matrix[row][0] = true;
            matrix[row][N + 1] = true;
        }

        // (x1, y1) 부터 (x2, y2)까지 true(visited)로 초기화, 실제 연산 순서는 (x1, y2) to (x2, y1)
        for (i = 0; i < K; i++) {
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            for (row = y2; row <= y1; row++) {
                for (col = x1; col <= x2; col++) {
                    matrix[row][col] = true;
                }
            }
        }

        // DFS
        for (row = 1; row <= M; row++) {
            for (col = 1; col <= N; col++) {
                ret = 0;
                if (!matrix[row][col]) {
                    DFS(matrix, row, col);
                    area[numberOfArea] = ret;
                    numberOfArea += 1;
                }
            }
        }

        Arrays.sort(area, 0, numberOfArea - 1);

        // 결과 출력
        StringBuffer sb = new StringBuffer();
        sb.append(numberOfArea + "\n");
//        System.out.print(numberOfArea);
        for (i = numberOfArea - 1; i >= 0; i--) {
            sb.append(area[i] + " ");
        }

        System.out.println(sb);
    }

    private static void DFS(boolean[][] matrix, int row, int col) {
        matrix[row][col] = true;
        if (!matrix[row - 1][col]) {
            ret += 1;
            DFS(matrix, row - 1, col);
        } else if (!matrix[row][col + 1]) {
            ret += 1;
            DFS(matrix, row, col + 1);
        } else if (!matrix[row + 1][col]) {
            ret += 1;
            DFS(matrix, row + 1, col);
        } else if (!matrix[row][col - 1]) {
            ret += 1;
            DFS(matrix, row, col - 1);
        }
    }
}
