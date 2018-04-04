/*
 * 문제: 1219. [S/W 문제해결 기본] 4일차 - 길찾기 / 129 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14geLqABQCFAYD&categoryId=AV14geLqABQCFAYD&categoryType=CODE
 * 알고리즘: DFS
 * 풀이방법:
 *      길의 정보를 나타내는 1차원 배열 2개를 선언
 *      road1, road2 의 모든 원소를 0으로 초기화
 *      길의 정보를 입력
 *          처음 입력받는 출발점 정보이면 road1에 목적지 인덱스 저장
 *          두번째로 입력받는 출발점 정보이면 road2에 인덱스 저장
 *      dfs 수행
 *
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   입력받는 길의 총 개수를 N이라 할때
 *   최악의 경우에는 길의 개수만큼 따라가서 목적지까지 가는경우이다. 이때 O(N)
 *
 * 공간복잡도(Space Complexity)
 *   입력받는 길의 총 개수에 상관없이 일정한 크기의 메모리(여기서는 1차원 배열)를 사용하므로 상수
 *   O(1)
 *
 * */

package swexpert;

import java.util.Arrays;
import java.util.Scanner;

public class SE_1219 {

    static int[] road1, road2;
    static boolean find;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        road1 = new int[100];
        road2 = new int[100];
        for (t = 1; t <= 10; t++) {
            init(sc);
            dfs(road1[0]);
            dfs(road2[0]);
            if (find) System.out.println("#" + t + " 1");
            else System.out.println("#" + t + " 0");
        }
    }

    private static void init(Scanner sc) {
        int N, i, from, to;
        sc.nextInt();
        N = sc.nextInt();
        Arrays.fill(road1, 0);
        Arrays.fill(road2, 0);
        for (i = 0; i < N; i++) {
            from = sc.nextInt();
            to = sc.nextInt();
            if (road1[from] == 0) road1[from] = to;
            else road2[from] = to;
        }
        find = false;
    }

    private static void dfs(int fromIdx) {
        if (fromIdx == 0) return;
        if (fromIdx == 99) find = true;
        if (!find) {
            dfs(road1[fromIdx]);
            dfs(road2[fromIdx]);
        }
    }
}
