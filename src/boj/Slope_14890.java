/*
 * 문제: 14890 경사로 / 100ms
 * link: https://www.acmicpc.net/problem/14890
 * 알고리즘: 구현
 * 풀이방법:
 *  앞뒤 길이 같으면 pass
 *  앞뒤 길이 다르면 낮은쪽으로 진행
 *      낮은 쪽이 L만큼 이어지는지 + 범위 내 인지 + 길이 차가 1 이내인지 확인
 *      경사로를 놓을 수 있는지 확인
 *
 * 의사코드(Pseudo Code)
 *  input N, L
 *  init[][] map with N numbers
 *  init[] checked with false
 *
 *  for start 0 ~ N-1:
 *      checkHorizontalLine(start)
 *      checkVerticalLine(start)
 *
 *  checkHorizontalLine(row):
 *      for start row ~ N -1:
 *
 * 시간복잡도(Time Complexity)
 *
 * 공간복잡도(Space Complexity)
 *
 * */


package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Slope_14890 {

    static int N, L, cnt;
    static int[][] map;
    static boolean[] checked;

    public enum Direction {
        LEFT, RIGHT, UP, DOWN
    }

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input;
        int row, col, start;
        boolean available;

        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);
        map = new int[N][N];
        checked = new boolean[N];

        Arrays.fill(checked, false);
        for (row = 0; row < N; row++) {
            input = br.readLine().split(" ");
            for (col = 0; col < N; col++) {
                map[row][col] = Integer.parseInt(input[col]);
            }
        }

        cnt = 0;
        for (start = 0; start < N; start++) {
            if (checkHorizontalLine(start)) cnt++;
            Arrays.fill(checked, false);
            if (checkVerticalLine(start)) cnt++;
            Arrays.fill(checked, false);
        }
        System.out.println(cnt);
    }

    // 가로로 검사
    private static boolean checkHorizontalLine(int row) {
        int h, nextH;
        h = map[row][0];
        for (int col = 1; col < N; col++) {
            nextH = map[row][col];
            if (h != nextH) {
                if (Math.abs(h - nextH) > 1) return false;
                if (h > nextH) {
                    // 오른쪽으로 체크
                    if (!isLenAvailable(Direction.RIGHT, row, col, nextH)) return false;
                } else if (h < nextH) {
                    // 왼쪽으로 체크
                    if (!isLenAvailable(Direction.LEFT, row, col - 1, h)) return false;
                }
            }
            h = nextH;
        }
        return true;
    }

    // 세로로 검사
    private static boolean checkVerticalLine(int col) {
        int h, nextH;
        h = map[0][col];
        for (int row =1; row<N; row++){
            nextH = map[row][col];
            if (h != nextH){
                if (Math.abs(h-nextH) > 1) return false;
                if (h > nextH){
                    // 아래로 체크
                    if (!isLenAvailable(Direction.DOWN, row, col, nextH)) return false;
                } else if (h < nextH){
                    // 위로 체크
                    if (!isLenAvailable(Direction.UP, row -1 , col, h)) return false;
                }
            }
            h = nextH;
        }
        return true;
    }

    static boolean isLenAvailable(Direction dir, int row, int col, int height) {
        boolean ret = true;
        if (L > 1) {
            switch (dir) {
                case RIGHT:
                    if (col + L > N) return false;
                    // 경사로를 놓을 수 있는지 검사
                    for (int start = col; start < col + L; start++) {
                        if (height != map[row][start]) {
                            ret = false;
                            break;
                        }
                    }
                    // 기존 경사로가 있는지 검사
                    if (ret) {
                        ret = isSlopeAvailable(col, col + L - 1);
                    }
                    break;
                case LEFT:
                    if (col - L + 1 < 0) return false;
                    for (int start = col; start > col - L; start--) {
                        if (height != map[row][start]) {
                            ret = false;
                            break;
                        }
                    }
                    if (ret) {
                        ret = isSlopeAvailable(col - L + 1, col);
                    }
                    break;
                case UP:
                    if (row - L + 1 < 0) return false;
                    for (int start = row; start > row - L; start--) {
                        if (height != map[start][col]) {
                            ret = false;
                            break;
                        }
                    }
                    if (ret) {
                        ret = isSlopeAvailable(row - L + 1, row);
                    }
                    break;
                case DOWN:
                    if (row + L > N) return false;
                    // 경사로를 놓을 수 있는지 검사
                    for (int start = row; start < row + L; start++) {
                        if (height != map[start][col]) {
                            ret = false;
                            break;
                        }
                    }
                    // 기존 경사로가 있는지 검사
                    if (ret) {
                        ret = isSlopeAvailable(row, row + L - 1);
                    }
                    break;
            }
        } else if (L == 1) {
            switch (dir) {
                case RIGHT:
                case LEFT:
                    ret = isSlopeAvailable(col, col);
                    break;
                case UP:
                case DOWN:
                    ret = isSlopeAvailable(row, row);
                    break;
            }
        }
        return ret;
    }

    static boolean isSlopeAvailable(int from, int to) {
        for (int start = from; start <= to; start++) {
            if (checked[start]) return false;
            checked[start] = true;
        }
        return true;
    }
}
