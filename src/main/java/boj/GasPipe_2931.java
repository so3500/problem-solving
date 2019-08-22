/* 가스관
 * https://www.acmicpc.net/problem/2931
 * 알고리즘: DFS, 구현
 * 풀이방법:
 *   M 또는 Z의 위치를 찾는다.
 *   해당 위치에서 갈 수 있는 pipe를 찾는다.(조건에 의해서 1개는 무조건 존재한다.)
 *   pipe를 따라 dfs 탐색을 한다.
 *   끊어진 pipe의 위치를 찾는다.
 *   끊어진 pipe에서 주변에 갈 수 있는 pipe를 찾는다.
 *   pipe가 끊어지기 전 어디서 왔는지, 앞으로 어디로 갈 수 있는지 등의 정보를 참고하여 pipe를 정한다.
 *
 * 의사코드:
 *
 * 시간복잡도(Time Complexity)
 *   최악의 경우 가로 C, 세로 R 길이인 2차원 배열을 모두 탐색
 *   O(RC)
 *
 * 공간복잡도(Space Complexity)
 *   row R, col C
 *   O(RC)
 *
 * */

package boj;

//import java.io.File;

import java.util.Arrays;
import java.util.Scanner;

public class GasPipe_2931 {

    static char[][] map;
    static Direction enableDirection;

    public static class Node {
        private int row;
        private int col;
        private Direction direction;
        private Direction from;

        public void setRow(int row) {
            this.row = row;
        }

        public void setCol(int col) {
            this.col = col;
        }

        public int getRow() {
            return this.row;
        }

        public int getCol() {
            return this.col;
        }

        public Direction getDirection() {
            return direction;
        }

        public void setDirection(Direction direction) {
            this.direction = direction;
        }

        public Direction getFrom() {
            return from;
        }

        public void setFrom(Direction from) {
            this.from = from;
        }
    }

    public enum Direction {
        DOWN, UP, LEFT, RIGHT
    }

    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(new File("input.txt"));
        Scanner sc = new Scanner(System.in);

        int R, C, row, col;
//        char[][] map;
        String input;
        Node position, M, Z;
        Direction direction, from;

        // 가스관 정보 입력
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R + 2][C + 2];
        M = new Node();
        Z = new Node();
        for (row = 1; row <= R; row++) {
            input = sc.next();
            for (col = 1; col <= C; col++) {
                map[row][col] = input.charAt(col - 1);
                if (map[row][col] == 'M') {
                    M.setRow(row);
                    M.setCol(col);
                } else if (map[row][col] == 'Z') {
                    Z.setRow(row);
                    Z.setCol(col);
                }
            }
        }

        // 위아래 변 '.' 으로 채우기
        Arrays.fill(map[0], 0, C + 2, '.');
        Arrays.fill(map[R + 1], 0, C + 2, '.');
        // 좌우 변 '.' 으로 채우기
        for (row = 1; row < R + 1; row++) {
            map[row][0] = '.';
            map[row][C + 1] = '.';
        }

        position = new Node();
        position.setRow(M.getRow());
        position.setCol(M.getCol());
        // M 주변에 연결 된 파이프 찾기, 인접한 블럭의 수는 하나이므로 찾으면 바로 그 블럭
        row = position.getRow();
        col = position.getCol();
        if (map[row - 1][col] != '.' && map[row - 1][col] != 'Z') { // up
            position.setDirection(Direction.UP);
        } else if (map[row][col + 1] != '.' && map[row][col + 1] != 'Z') { // right
            position.setDirection(Direction.RIGHT);
        } else if (map[row + 1][col] != '.' && map[row + 1][col] != 'Z') { // down
            position.setDirection(Direction.DOWN);
        } else if (map[row][col - 1] != '.' && map[row][col - 1] != 'Z') { // left
            position.setDirection(Direction.LEFT);
        } else { // M 주변이 모두 비어있을 경우, Z에서 시작
            row = Z.getRow();
            col = Z.getCol();
            position.setRow(row);
            position.setCol(col);
            if (map[row - 1][col] != '.' && map[row - 1][col] != 'M') { // up
                position.setDirection(Direction.UP);
            } else if (map[row][col + 1] != '.' && map[row][col + 1] != 'M') { // right
                position.setDirection(Direction.RIGHT);
            } else if (map[row + 1][col] != '.' && map[row + 1][col] != 'M') { // down
                position.setDirection(Direction.DOWN);
            } else if (map[row][col - 1] != '.' && map[row][col - 1] != 'M') { // left
                position.setDirection(Direction.LEFT);
            }
        }
//        printPosition(position);
        dfs(position);

    }

    private static void dfs(Node position) {
        StringBuffer output = new StringBuffer();
        Direction direction = position.getDirection();
        int row, col;
        char block = 'a';
        // 끊어진 pipe 찾기
        while (true) {
            row = position.getRow();
            col = position.getCol();
            block = map[row][col];
            setNextDirection(position, block);
            if (block == '.') break;
//            printPosition(position);
            move(position);
        }

        // 지워진 블록에 도착
        // 이제 지워진 블록에서 지워진 블록을 제외한 3방향으로 탐색하여
        // 갈 수 있는 블록의 개수, .에서 해당 블록으로 갈 수있는 방향 탐색
        int blockCount = 0;
        row = position.getRow();
        col = position.getCol();
        Direction from = position.getFrom();
        if (from == Direction.LEFT) {
            // up이 지워진 블록일 때, 지워진 블록에서 갈 수있는 블록인가?
            blockCount += findBlock(row + 1, col, Direction.UP);
            blockCount += findBlock(row, col + 1, Direction.LEFT);
            blockCount += findBlock(row - 1, col, Direction.DOWN);
        } else if (from == Direction.UP) {
            blockCount += findBlock(row + 1, col, Direction.UP);
            blockCount += findBlock(row, col + 1, Direction.LEFT);
            blockCount += findBlock(row, col - 1, Direction.RIGHT);
        } else if (from == Direction.RIGHT) {
            blockCount += findBlock(row + 1, col, Direction.UP);
            blockCount += findBlock(row, col - 1, Direction.RIGHT);
            blockCount += findBlock(row - 1, col, Direction.DOWN);
        } else if (from == Direction.DOWN) {
            blockCount += findBlock(row, col - 1, Direction.RIGHT);
            blockCount += findBlock(row, col + 1, Direction.LEFT);
            blockCount += findBlock(row - 1, col, Direction.DOWN);
        }

        // 지워진 블록에서 갈 수 있는 블록이 3개이면 '+'
        // 1개이면 주어진 조건에 따라 정해진다.
        if (blockCount == 1) {
            if (from == Direction.LEFT && enableDirection == Direction.RIGHT) block = '-';
            else if (from == Direction.LEFT && enableDirection == Direction.UP) block = '3';
            else if (from == Direction.LEFT && enableDirection == Direction.DOWN) block = '4';
            else if (from == Direction.RIGHT && enableDirection == Direction.UP) block = '2';
            else if (from == Direction.RIGHT && enableDirection == Direction.LEFT) block = '-';
            else if (from == Direction.RIGHT && enableDirection == Direction.DOWN) block = '1';
            else if (from == Direction.UP && enableDirection == Direction.LEFT) block = '3';
            else if (from == Direction.UP && enableDirection == Direction.DOWN) block = '|';
            else if (from == Direction.UP && enableDirection == Direction.RIGHT) block = '2';
            else if (from == Direction.DOWN && enableDirection == Direction.LEFT) block = '4';
            else if (from == Direction.DOWN && enableDirection == Direction.RIGHT) block = '1';
            else if (from == Direction.DOWN && enableDirection == Direction.UP) block = '|';
        } else if (blockCount == 3) {
            block = '+';
        }
//        printPosition(position);
//        System.out.println("blockCount: " + blockCount);
        System.out.println(position.getRow() + " " + position.getCol() + " " + block);

    }

    private static int findBlock(int row, int col, Direction from) {
        int blockCount = 0;
        char block = map[row][col];
        if (from == Direction.DOWN) {
            if (block == '4' || block == '1' || block == '+' || block == '|' || block == 'Z' || block == 'M') {
                blockCount++;
                enableDirection = Direction.UP;
            }
        } else if (from == Direction.UP) {
            if (block == '3' || block == '2' || block == '+' || block == '|' || block == 'Z' || block == 'M') {
                blockCount++;
                enableDirection = Direction.DOWN;
            }
        } else if (from == Direction.LEFT) {
            if (block == '4' || block == '3' || block == '+' || block == '-' || block == 'Z' || block == 'M') {
                blockCount++;
                enableDirection = Direction.RIGHT;
            }
        } else if (from == Direction.RIGHT) {
            if (block == '2' || block == '1' || block == '+' || block == '-' || block == 'Z' || block == 'M') {
                blockCount++;
                enableDirection = Direction.LEFT;
            }
        }
        return blockCount;
    }

    private static void printPosition(Node position) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("(row: ")
                .append(position.getRow())
                .append(" col: ")
                .append(position.getCol())
                .append(")")
                .append("from: ")
                .append(position.getFrom())
                .append(" direction: ")
                .append(position.getDirection());
        System.out.println(buffer);
    }

    private static void setNextDirection(Node position, char block) {
//        Direction direction = position.getDirection();
        Direction from = position.getFrom();
//        System.out.print(block + " ");
        switch (block) {
            case '|':
                // keep direction
                break;
            case '-':
                // keep direction
                break;
            case '+':
                // keep direction
                break;
            case '1': // r
                if (from == Direction.RIGHT) {
                    position.setDirection(Direction.DOWN);
                } else if (from == Direction.DOWN) {
                    position.setDirection(Direction.RIGHT);
                }
                break;
            case '2': // ㄴ
                if (from == Direction.RIGHT) {
                    position.setDirection(Direction.UP);
                } else {
                    position.setDirection(Direction.RIGHT);
                }
                break;
            case '3': // ㅢ
                if (from == Direction.UP) {
                    position.setDirection(Direction.LEFT);
                } else {
                    position.setDirection(Direction.UP);
                }
                break;
            case '4': // ㄱ
                if (from == Direction.LEFT) {
                    position.setDirection(Direction.DOWN);
                } else {
                    position.setDirection(Direction.LEFT);
                }
                break;
        }
    }

    private static void move(Node position) {
        int row = position.getRow();
        int col = position.getCol();
        Direction direction = position.getDirection();
        switch (direction) {
            case UP:
                position.setRow(row - 1);
                position.setFrom(Direction.DOWN);
                break;
            case LEFT:
                position.setCol(col - 1);
                position.setFrom(Direction.RIGHT);
                break;
            case RIGHT:
                position.setCol(col + 1);
                position.setFrom(Direction.LEFT);
                break;
            case DOWN:
                position.setRow(row + 1);
                position.setFrom(Direction.UP);
                break;
        }
    }
}
