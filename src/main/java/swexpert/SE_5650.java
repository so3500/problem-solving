package swexpert;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SE_5650 {

    static class WormHole {
        int wormId;
        int row;
        int col;

        public WormHole(int wormId, int row, int col) {
            this.wormId = wormId;
            this.row = row;
            this.col = col;
        }
    }

    static int N;
    static int maxPoint;
    static int startRow;
    static int startCol;
    static int[] rows = {-1, 0, 1, 0};
    static int[] cols = {0, 1, 0, -1};
    static int[][] map;
    static List<WormHole> wormHoles;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            init(sc);
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] == 0) {
                        for (int dir = 0; dir < 4; dir++) {
                            startRow = r;
                            startCol = c;
                            dfs(dir, r, c, 0);
                        }
                    }
                }
            }
            System.out.println(String.format("#%d %d", test_case, maxPoint));
        }
        sc.close();
    }

    static void init(Scanner sc) {
        N = sc.nextInt();
        sc.nextLine();
        map = new int[N][N];
        wormHoles = new ArrayList<>();
        maxPoint = Integer.MIN_VALUE;
        for (int r = 0; r < N; r++) {
            String[] input = sc.nextLine().split(" ");
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(input[c]);
                if (map[r][c] >= 6) {
                    wormHoles.add(new WormHole(map[r][c], r, c));
                }
            }
        }
    }

    static void dfs(int dir, int row, int col, int point) {

        while (true) {
            int toDir = dir;
            int toRow = row + rows[dir];
            int toCol = col + cols[dir];
            int toPoint = point;

            if (isWall(toRow, toCol)) {
                toDir = (dir + 2) % 4;
                toRow = toRow + rows[toDir];
                toCol = toCol + cols[toDir];
                toPoint = point + 1;
            }

            int blockId = map[toRow][toCol];
            if (blockId == -1 || (toRow == startRow && toCol == startCol)) {
                maxPoint = Integer.max(maxPoint, toPoint);
                break;
            } else if (blockId >= 1 && blockId <= 5) {
                toDir = getDir(blockId, toDir);
                toPoint++;
            } else if (blockId >= 6 && blockId <= 10) {
                WormHole wormHole = getWormHole(blockId, toRow, toCol);
                toRow = wormHole.row;
                toCol = wormHole.col;
            }
            dir = toDir;
            row = toRow;
            col = toCol;
            point = toPoint;
        }

    }

    static int getDir(int blockId, int dir) {
        int toDir = (dir + 2) % 4;
        switch (blockId) {
            case 1:
                if (dir == 2) {
                    toDir = 1;
                } else if (dir == 3) {
                    toDir = 0;
                }
                break;
            case 2:
                if (dir == 0) {
                    toDir = 1;
                } else if (dir == 3) {
                    toDir = 2;
                }
                break;
            case 3:
                if (dir == 0) {
                    toDir = 3;
                } else if (dir == 1) {
                    toDir = 2;
                }
                break;
            case 4:
                if (dir == 1) {
                    toDir = 0;
                } else if (dir == 2) {
                    toDir = 3;
                }
                break;
        }
        return toDir;
    }

    static WormHole getWormHole(int wormId, int row, int col) {
        WormHole wormHole = null;
        for (WormHole wHole : wormHoles) {
            if (wHole.wormId == wormId && wHole.row != row && wHole.col != col) {
                wormHole = wHole;
                break;
            }
        }
        return wormHole;
    }

    static boolean isWall(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N) {
            return true;
        } else {
            return false;
        }
    }
}
