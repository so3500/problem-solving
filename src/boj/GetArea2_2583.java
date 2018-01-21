package boj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// public class Main {
public class GetArea2_2583 {

    static int M, N, NumOfArea;

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int K, row, col, row1, col1, row2, col2, i, count;
        boolean[][] rectangle = null;
        int[] area = null;
        StringBuffer buffer = new StringBuffer();

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()) + 2; // 가장자리를 고려하여 +2
        N = Integer.parseInt(st.nextToken()) + 2;
        K = Integer.parseInt(st.nextToken());

        rectangle = new boolean[M][N]; // 0으로 초기화
        area = new int[M * N]; // 0으로 초기화
        // 바깥 4변 색칠
        Arrays.fill(rectangle[0], 0, N, true); // from 0 to N+1
        Arrays.fill(rectangle[M - 1], 0, N, true);
        for (row = 0; row < M; row++) {
            rectangle[row][0] = true;
            rectangle[row][N - 1] = true;
        }

        // 직사각형 색칠
        // (row1, col1)은 포함, (row2, col2)는 비포함하여 색칠한다.
        for (i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            col1 = Integer.parseInt(st.nextToken()) + 1;
            row1 = Integer.parseInt(st.nextToken()) + 1;
            col2 = Integer.parseInt(st.nextToken()) + 1;
            row2 = Integer.parseInt(st.nextToken()) + 1;
            for (row = row1; row < row2; row++) {
                Arrays.fill(rectangle[row], col1, col2, true); // fill true from col1 to col2-1
            }
        }
        br.close();
        st = null;

        // 알고리즘
        count = 0;
        for (row = 1; row < M - 1; row++) {
            for (col = 1; col < N - 1; col++) {
                if (!rectangle[row][col]) {
                    NumOfArea = 0;
                    dfs(rectangle, row, col);
                    area[count] = NumOfArea;
                    count++;
                }
            }
        }
        Arrays.sort(area, 0, count);

        // 결과 출력
        buffer.append(count).append("\n");
        for (i = 0; i < count; i++) {
            buffer.append(area[i]).append(" ");
        }
        System.out.println(buffer);

    }

    private static void dfs(boolean[][] rectangle, int row, int col) {
        NumOfArea++;
        rectangle[row][col] = true;
        if (!rectangle[row - 1][col]) {
            dfs(rectangle, row - 1, col);
        }
        if (!rectangle[row][col + 1]) {
            dfs(rectangle, row, col + 1);
        }
        if (!rectangle[row + 1][col]) {
            dfs(rectangle, row + 1, col);
        }
        if (!rectangle[row][col - 1]) {
            dfs(rectangle, row, col - 1);
        }
    }
}
