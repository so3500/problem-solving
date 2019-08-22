/*
 * 문제: 14891 톱니바퀴 / 120ms
 * 알고리즘: 완전 탐색
 * 풀이방법:
 *   톱니바퀴 정보 배열
 *   톱니바퀴 left, right 정보 배열
 *   톱니바퀴가 움직일 때 left, right 값을 담은 배열 값 수정
 *
 *   추가) 링크드리스트를 이용하여 풀 수도 있다.
 *
 * 의사코드(Pseudo Code)
 *  input circle[]
 *  for i: 0 to 3
 *      input circleNo, direction
 *      solve()
 *  getPoint()
 *  print point
 *
 *  solve:
 *      circleNo, direction 에 따라 gearPosition 수정
 *
 * 시간복잡도(Time Complexity)
 *  각 질의 K 에 따라 O(1) 의 처리시간
 *  O(K)
 *
 * 공간복잡도(Space Complexity)
 *  배열을 사용했으나 그 길이는 상수이므로
 *  O(1)
 *
 * */


package boj;

import java.util.Scanner;

public class Wheel_14891 {

    static int K, circleNo, direction, point;
    static String[] circle;
    static int[][] gearPos; // 맞물린 곳. [][0]: Left, [][1]: Right

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        circle = new String[4];
        gearPos = new int[4][2];

        for (int i = 0; i < 4; i++) {
            circle[i] = sc.nextLine();
        }

        K = sc.nextInt();

        initGearPos();
        point = 0;
        for (int i = 0; i < K; i++) {
            circleNo = sc.nextInt() - 1; // 0 ~ 3
            direction = sc.nextInt();
            solve();
        }
        getPoint();
        System.out.println(point);
    }

    static void solve() {
        switch (circleNo) {
            case 0:
                if (circle[0].charAt(gearPos[0][1]) != circle[1].charAt(gearPos[1][0])) {
                    if (circle[1].charAt(gearPos[1][1]) != circle[2].charAt(gearPos[2][0])) {
                        if (circle[2].charAt(gearPos[2][1]) != circle[3].charAt(gearPos[3][0])) {
                            setGearPos(0, direction);
                            setGearPos(1, direction * -1);
                            setGearPos(2, direction);
                            setGearPos(3, direction * -1);
                        } else {
                            setGearPos(0, direction);
                            setGearPos(1, direction * -1);
                            setGearPos(2, direction);
                        }
                    } else {
                        setGearPos(0, direction);
                        setGearPos(1, direction * -1);
                    }
                } else {
                    setGearPos(0, direction);
                }
                break;
            case 1:
                if (circle[0].charAt(gearPos[0][1]) != circle[1].charAt(gearPos[1][0]))
                    setGearPos(0, direction * -1);
                if (circle[1].charAt(gearPos[1][1]) != circle[2].charAt(gearPos[2][0])) {
                    if (circle[2].charAt(gearPos[2][1]) != circle[3].charAt(gearPos[3][0])) {
                        setGearPos(1, direction);
                        setGearPos(2, direction * -1);
                        setGearPos(3, direction);

                    } else {
                        setGearPos(1, direction);
                        setGearPos(2, direction * -1);
                    }
                } else {
                    setGearPos(1, direction);
                }
                break;
            case 2:
                if (circle[2].charAt(gearPos[2][1]) != circle[3].charAt(gearPos[3][0]))
                    setGearPos(3, direction * -1);
                if (circle[1].charAt(gearPos[1][1]) != circle[2].charAt(gearPos[2][0])) {
                    if (circle[0].charAt(gearPos[0][1]) != circle[1].charAt(gearPos[1][0])) {
                        setGearPos(0, direction);
                        setGearPos(1, direction * -1);
                        setGearPos(2, direction);

                    } else {
                        setGearPos(1, direction * -1);
                        setGearPos(2, direction);
                    }
                } else {
                    setGearPos(2, direction);
                }
                break;
            case 3:
                if (circle[2].charAt(gearPos[2][1]) != circle[3].charAt(gearPos[3][0])) {
                    if (circle[1].charAt(gearPos[1][1]) != circle[2].charAt(gearPos[2][0])) {
                        if (circle[0].charAt(gearPos[0][1]) != circle[1].charAt(gearPos[1][0])) {
                            setGearPos(0, direction * -1);
                            setGearPos(1, direction);
                            setGearPos(2, direction * -1);
                            setGearPos(3, direction);
                        } else {
                            setGearPos(1, direction);
                            setGearPos(2, direction * -1);
                            setGearPos(3, direction);
                        }
                    } else {
                        setGearPos(2, direction * -1);
                        setGearPos(3, direction);
                    }
                } else {
                    setGearPos(3, direction);
                }
                break;
        }
    }

    static void initGearPos() {
        for (int i = 0; i <= 3; i++) {
            gearPos[i][0] = 6;
            gearPos[i][1] = 2;
        }
    }

    static void setGearPos(int no, int dir) {
        if (dir == -1) {
            gearPos[no][0] = (gearPos[no][0] + 1) % 8;
            gearPos[no][1] = (gearPos[no][1] + 1) % 8;
        } else if (dir == 1) {
            gearPos[no][0] = (gearPos[no][0] - 1 + 8) % 8;
            gearPos[no][1] = (gearPos[no][1] - 1 + 8) % 8;
        }
    }

    static void getPoint() {
        int fact = 1;
        int noon = 0;
        int left = 0, right = 0;
        for (int i = 0; i < 4; i++) {
            left = gearPos[i][0];
            right = gearPos[i][1];
            if (left > right) {
                if (right == 0)
                    noon = left + right + 2;
                else if (right == 1)
                    noon = left + right + 1;
                else
                    noon = ((left + right) % 8) / 2;
            } else { // 톱니바퀴 180 반전
                noon = (left + right) / 2;
            }
            if (circle[i].charAt(noon) == '1') point += fact;
            fact *= 2;
        }
    }
}
