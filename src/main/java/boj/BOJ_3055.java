/*
 * 문제: 3055 탈출
 * link: https://www.acmicpc.net/problem/3055
 * 알고리즘: BFS, simulation
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

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_3055 {

    static class Point {
        int r, c, dist;

        public Point(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    static private Queue<Point> animal, water;
    static private int R, C, minDist;
    static private char[][] map;
    static private int[] rows = {-1, 0, 1, 0}, cols = {0, 1, 0, -1};
    static private Scanner sc;

    public static void main(String[] args) {
        init();
        boolean isExitEnable = bfs();
        if (isExitEnable) {
            System.out.println(minDist);
        } else {
            System.out.println("KAKTUS");
        }
    }

    private static void init() {
        sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        animal = new LinkedList<>();
        water = new LinkedList<>();
        String input;
        minDist = Integer.MAX_VALUE;

        for (int r = 0; r < R; r++) {
            input = sc.next();
            for (int c = 0; c < C; c++) {
                map[r][c] = input.charAt(c);
                if (map[r][c] == 'S') {
                    animal.add(new Point(r, c, 0));
                } else if (map[r][c] == '*') {
                    water.add(new Point(r, c, 0));
                }
            }
        }
        sc.close();
    }

    private static boolean bfs() {
        boolean isExitEnable = false;
        Point a, w;
        int numOfWater, numOfC, i, toR, toC;

        while (!animal.isEmpty() && !isExitEnable) {
            // 물 이동
            numOfWater = water.size();
            while (numOfWater > 0) {
                w = water.poll();
                for (i = 0; i < 4; i++) {
                    toR = w.r + rows[i];
                    toC = w.c + cols[i];
                    // 유효한 범위, 물이 없는 곳, 비버의 소굴이 아닌 곳
                    if (isValid(toR, toC) && map[toR][toC] == '.' && map[toR][toC] != 'D') {
                        map[toR][toC] = '*';
                        water.add(new Point(toR, toC, 0));
                    }
                }
                numOfWater--;
            }
            // 고슴도치 이동
            numOfC = animal.size();
            while (numOfC > 0) {
                a = animal.poll();
                for (i = 0; i < 4; i++) {
                    toR = a.r + rows[i];
                    toC = a.c + cols[i];
                    // 유효한 범위, 방문하지 않은 곳, 물이 없는 곳, 비버의 소굴인 곳
                    if (isValid(toR, toC) && (map[toR][toC] == '.' || map[toR][toC] == 'D')) {
                        if (map[toR][toC] == 'D') {
                            minDist = a.dist + 1;
                            isExitEnable = true;
                            break;
                        }
                        map[toR][toC] = 'S';
                        animal.add(new Point(toR, toC, a.dist + 1));
                    }
                }
                numOfC--;
            }

        }
        return isExitEnable;
    }

    private static boolean isValid(int r, int c) {
        if (0 <= r && r < R && 0 <= c && c < C && map[r][c] != 'X') {
            return true;
        } else {
            return false;
        }
    }
}
