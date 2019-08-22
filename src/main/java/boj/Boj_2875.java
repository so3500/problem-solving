/*
 * 문제: 2875 대회 or 인턴 / 116 ms
 * link: https://www.acmicpc.net/problem/2875
 * 알고리즘: 그리디
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

import java.util.Scanner;

public class Boj_2875 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int man, woman, K, team;
        woman = sc.nextInt();
        man = sc.nextInt();
        K = sc.nextInt();
        // 잉여: 최대로 만들 수 있는 팀에 들어가지 않는 학생
        // 여학생 쪽에서 잉여가 발생하는 경우 여학생 한명 인턴십 참여
        // 남학생 쪽에서 잉여가 발생하는 경우 남학생 한명 인턴십 참여
        while (K > 0 && man > 0 && woman > 0) {
            if (woman >= 2 * man) {
                woman--;
                K--;
            } else {
                man--;
                K--;
            }
        }
        // 팀 수 구하기
        if (woman >= 2 * man) {
            team = man;
        } else {
            team = woman / 2;
        }
        System.out.println(team);
        sc.close();
    }

}
