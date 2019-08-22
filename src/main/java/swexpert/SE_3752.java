/*
 * 문제: 3752. 가능한 시험 점수 / 632 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWHPkqBqAEsDFAUn&categoryId=AWHPkqBqAEsDFAUn&categoryType=CODE
 * 알고리즘: implementation
 * 풀이방법:
 *      hash, list 를 이용하여 풀었지만,
 *      1차원 배열을 이용하여 해결할 수도 있다. (index 를 뒤에서부터 앞으로)
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *
 * 공간복잡도(Space Complexity)
 *
 * */

package swexpert;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SE_3752 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t, N, input, i;
        List<Integer> list = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            N = sc.nextInt();
            list.clear();
            set.clear();
            set.add(0);
            for (i = 0; i < N; i++) {
                input = sc.nextInt();
                while (!list.isEmpty()) {
                    set.add(list.remove(0));
                }
                for (int elm : set) {
                    list.add(elm + input);
                }
            }
            while (!list.isEmpty()) {
                set.add(list.remove(0));
            }
            System.out.println("#" + t + " " + set.size());
        }
    }
}
