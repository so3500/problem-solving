package boj;

import java.util.Scanner;

public class BOJ_5533 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        int[][] points = new int[N][3];
        boolean[] isDuplicatedPoint = new boolean[101];

        for (int playerNo = 0; playerNo < N; playerNo++) {
            for (int idx = 0; idx < 3; idx++) {
                int point = sc.nextInt();
                isDuplicatedPoint[point] = true;
                points[playerNo][idx] = point;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int playerNo = 0; playerNo < N; playerNo++) {
            int pointSum = 0;
            for (int idx = 0; idx < 3; idx++) {
                int point = points[playerNo][idx];
                if (isDuplicatedPoint[point] == false) {
                    pointSum += point;
                }
            }
            sb.append(pointSum).append("\n");
        }

        System.out.println(sb);
        sc.close();
    }

}
