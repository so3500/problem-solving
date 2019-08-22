/*
 * 문제: 1493. 수의 새로운 연산 / 147 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV2b-QGqADMBBASw&categoryId=AV2b-QGqADMBBASw&categoryType=CODE
 * 알고리즘: 구현, upper bound
 * 풀이방법:
 *      연산의 일정한 규칙을 찾아서 구현하는 문제
 *      1차원 배열 arr[idx] 에 각 1 ~ idx 합을 넣음
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *
 * 공간복잡도(Space Complexity)
 *
 * */

package swexpert;

import java.util.Scanner;

public class SE_1493 {

    static final int ARR_SIZE = 500;
    static int[] arr = new int[ARR_SIZE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t, idx, ans, p, q;
        T = sc.nextInt();
        for (idx = 1; idx < ARR_SIZE; idx++) {
            arr[idx] = idx * (idx + 1) / 2;
        }
        for (t = 1; t <= T; t++) {
            p = sc.nextInt();
            q = sc.nextInt();
            ans = solve(p, q);
            System.out.println("#" + t + " " + ans);
        }
    }

    static int solve(int p, int q) {
        int idx, r1, r2, c1, c2, newIdx, ans;

        // &(p) 연산
        c1 = 0;
        c2 = 0;
        idx = getUpperBound(p);
        if (idx > 1) c1 = p - arr[idx - 1];
        else if (idx == 1) c1 = 1;
        r1 = idx - c1 + 1;
        idx = getUpperBound(q);
        if (idx > 1) c2 = q - arr[idx - 1];
        else if (idx == 1) c2 = 1;
        r2 = idx - c2 + 1;

        // #(x, y) 연산
        r1 += r2;
        c1 += c2;
        newIdx = r1 + c1 - 1;
        ans = arr[newIdx] - (newIdx - c1);
        return ans;
    }

    static int getUpperBound(int input) {
        int start, mid, end;
        start = 1;
        end = ARR_SIZE;
        mid = (start + end) / 2;
        while (start != end) {
            if (input <= arr[mid]) end = mid;
            else if (arr[mid] < input) start = mid + 1;
            mid = (start + end) / 2;
        }
        return start;
    }
}
