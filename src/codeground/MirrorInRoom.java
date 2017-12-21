package codeground;

/*
* 문제: 64 / SCPC 1회 예선 / 방속의 거울 / 0.34129
* link: https://www.codeground.org/practice
* 알고리즘: 구현
* 풀이방법:
*   방문여부, 거울상태 정보를 가진 방 클래스로 2차원 객체 배열 선언
*   거울 상태 정보(0: 거울없음, 1:오른쪽 상단에서 왼쪽 하단 거울, 2:왼쪽 상단에서 오른쪽 하단 거울)
*   거울 상태 정보에 따라 빛의 방향을 설정(0: 가던 방향으로 진행, 1, 2 의 경우 빛이 온 방향에 따라 가는방향 변경)
*   빛의 방향을 enum 으로 선언
*   2차원 배열에서
*       row 증가: 방에서 아래(DOWN)
*       row 감소: 방에서 위(UP)
*       col 증가: 방에서 오른쪽(RIGHT)
*       col 감소: 방에서 왼쪽(LEFT)
*       방향으로 진행
*
* 의사코드(Pseudo Code)
*   input T
*   each T
*       answer <- 0
*       input N
*       init room[N][N]
*
*       row<-0, col<-0
*       explore until 0 <= row <= N-1 && 0 <= col <= N-1
*           switch room[row][col].status
*               case 0:
*                   switch direction
*                       case UP:
*                           row--
*                       case RIGHT:
*                           col++
*                       case DOWN:
*                           row++
*                       case LEFT:
*                           col--
*               case 1:
*                   if room[row][col] not visited
*                       visitCount <- visitCount + 1
*                       room[row][col].visited <- true
*
*                   switch direction
*                       case UP:
*                           col++
*                           direction <- RIGHT
*                       case RIGHT:
*                           row--
*                           direction <- UP
*                       case DOWN:
*                           col--
*                           direction <- LEFT
*                       case LEFT:
*                           row++
*                           direction <- DOWN
*
*               case 2:
*
*                   switch direction
*                       visitCount <- visitCount + 1
*                       room[row][col].visited <- true
*
*                       case UP:
*                           col--
*                           direction <- LEFT
*                       case RIGHT:
*                           row++
*                           direction <- DOWN
*                       case DOWN:
*                           col++
*                           direction <- RIGHT
*                       case LEFT:
*                           row--
*                           direction <- UP
*
* 시간복잡도(Time Complexity)
*   N개의 숫자를 입력받고 2차원 객체 배열을 선언. 최악의 경우 배열의 모든 요소 방문
*   O(N^2)
*
* 공간복잡도(Space Complexity)
*   입력 N에 대한 2차원 배열 선언
*   O(N^2)
*
* */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

//class Solution {
class MirrorInRoom {
    static int Answer;

    enum Direction {UP, DOWN, RIGHT, LEFT}

    static class Room {
        boolean visited;
        int status;
    }

    public static void main(String args[]) throws Exception {

//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("input.txt"));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt")); // BufferedReader for file
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader for keyboard

        int N, row, col, visitCount, i, j;
        Direction direction;
        String input;

        int T = sc.nextInt();
//        int T = Integer.parseInt(br.readLine()); // br
//        StringTokenizer st = new StringTokenizer(br.readLine()); // line 기준 입력
//        Integer.parseInt(st.nextToken()) // 공백 기준 입력 e.g. 1 2 3 4 5 받을 때
        for (int test_case = 0; test_case < T; test_case++) {

            Answer = 0;
            /////////////////////////////////////////////////////////////////////////////////////////////
            /*
               Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            N = sc.nextInt();
            sc.nextLine();

            Room[][] room = new Room[N][N];
            for (row = 0; row < N; row++) {
                input = sc.nextLine();
                for (col = 0; col < N; col++) {
                    room[row][col] = new Room();
                    room[row][col].status = (input.charAt(col) - 48);
                    room[row][col].visited = false;
                }
            }

            row = 0;
            col = 0;
            visitCount = 0;
            direction = Direction.RIGHT;
            while (row >= 0 && col >= 0 && row < N  && col < N ) {
                switch (room[row][col].status) {
                    case 0:
                        switch (direction) {
                            case UP:
                                row--;
                                break;
                            case RIGHT:
                                col++;
                                break;
                            case DOWN:
                                row++;
                                break;
                            case LEFT:
                                col--;
                                break;
                        }
                        break;
                    case 1:
                        if (!room[row][col].visited) {
                            visitCount++;
                            room[row][col].visited = true;
                        }
                        switch (direction) {
                            case UP:
                                col++;
                                direction = Direction.RIGHT;
                                break;
                            case RIGHT:
                                row--;
                                direction = Direction.UP;
                                break;
                            case DOWN:
                                col--;
                                direction = Direction.LEFT;
                                break;
                            case LEFT:
                                row++;
                                direction = Direction.DOWN;
                                break;
                        }
                        break;
                    case 2:
                        if (!room[row][col].visited) {
                            visitCount++;
                            room[row][col].visited = true;
                        }
                        switch (direction) {
                            case UP:
                                col--;
                                direction = Direction.LEFT;
                                break;
                            case RIGHT:
                                row++;
                                direction = Direction.DOWN;
                                break;
                            case DOWN:
                                col++;
                                direction = Direction.RIGHT;
                                break;
                            case LEFT:
                                row--;
                                direction = Direction.UP;
                                break;
                        }
                        break;
                }
            }

            Answer = visitCount;
            /////////////////////////////////////////////////////////////////////////////////////////////
            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.println(Answer);
        }
    }
}
