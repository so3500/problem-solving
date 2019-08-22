/*
 * 문제: 4047 영준이의 카드 카운팅 / 99 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIsY84KEPMDFAWN
 * 알고리즘: 구현
 * 풀이방법:
 *   카드에 대한 정보 S가 주어지면 길이 3만큼씩 잘라서
 *   어떤 카드의 몇번에 대한 정보인지 파악한다.
 *   해당 정보를 파악한 뒤 card[카드종류][카드번호]에 true변수를 대입한다.
 *      여기서 중복되는 정보가 나오면 ERROR를 출력
 *   그리고 해당 카드 종류를 나타내는 int형 변수에서 하나씩 차감한다.
 *
 *   위 과정이 끝난 뒤 카드 종류를 나타내는 int형 변수의 정보를 출력
 *
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   카드에 대한 정보 S가 주어질 때 선형 탐색하므로
 *   O(S)
 *
 * 공간복잡도(Space Complexity)
 *   입력과, 테스트케이스에 상관없이 일정한 크기의 card 배열 사용
 *   O(1)
 *   카드에 대한 정보 S가 문자열로 주어지는데, 이를 고려한다면
 *   O(S)
 *
 * */

package swexpert;

import java.util.Scanner;

public class SE_4047 {

    static boolean[][] card;
    static int S, D, H, C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, cIdx;
        boolean ret;
        char c;
        String input, num;
        T = sc.nextInt();
//        sc.next();
        for (int t = 1; t <= T; t++) {
            input = sc.next();
            cIdx = 0;
            card = new boolean[4][14];
            S = 13;
            D = 13;
            H = 13;
            C = 13;
            ret = true;
            for (int i = 0; i < input.length() / 3; i++) {
                c = input.charAt(cIdx);
                num = input.substring(cIdx + 1, cIdx + 3);
                cIdx += 3;
                ret = solve(c, Integer.parseInt(num));
                if (!ret) break;
            }
            if (!ret) System.out.println("#" + t + " ERROR");
            else System.out.println("#" + t + " " + S + " " + D + " " + H + " " + C);
        }
        sc.close();
    }

    static boolean solve(char c, int num) {
        boolean ret = true;
        switch (c) {
            case 'S':
                S--;
                if (card[0][num]) ret = false;
                else card[0][num] = true;
                break;
            case 'D':
                D--;
                if (card[1][num]) ret = false;
                else card[1][num] = true;
                break;
            case 'H':
                H--;
                if (card[2][num]) ret = false;
                else card[2][num] = true;
                break;
            case 'C':
                C--;
                if (card[3][num]) ret = false;
                else card[3][num] = true;
                break;
        }
        return ret;
    }
}
