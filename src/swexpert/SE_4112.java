/*
 * 문제: 4112 이상한 피라미드 탐험 / 149 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWJHmLraeEwDFAUH
 * 알고리즘: 구현, upperBound
 * 풀이방법:
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *      입력 a, b 중 최대값을 N 이라 하면
 *      upperBound 연산에서 걸리는 시간은 O(logN)
 *      solve 의 반복문 안에서 idxDiff 의 최대값은 140 즉 a, b 차이의 루트? 만큼 증가하므로
 *      O(N^1/2 * logN)
 *
 *
 * 공간복잡도(Space Complexity)
 *      입력으로 주어지는 a, b 가 i*(i+1)/2 의 범위 안에 들어야 한다.
 *      범위를 N 이라 할때 O(N)?
 *
 * */

package swexpert;

import java.util.Scanner;

public class SE_4112 {

    static final int ARR_SIZE = 500;
    static int[] arr = new int[ARR_SIZE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t, i, a, b, ans;
        for (i = 1; i < ARR_SIZE; i++) {
            arr[i] = i * (i + 1) / 2;
        }
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            a = sc.nextInt();
            b = sc.nextInt();
            if (a > b) ans = solve(a, b);
            else if (a < b) ans = solve(b, a);
            else ans = 0;
            System.out.println("#" + t + " " + ans);
        }
        sc.close();
    }

    static int solve(int a, int b) {
        int ans, idxDiff, aIdx, bIdx, leftPlus, rightPlus, left, right;
        aIdx = getUpperBound(a);
        bIdx = getUpperBound(b);
        if (aIdx == bIdx) {
            ans = a - b;
        } else {
            left = b;
            right = b;
            leftPlus = bIdx;
            rightPlus = bIdx + 1;
            idxDiff = aIdx - bIdx;
            for (int i = 0; i < idxDiff; i++) {
                left += leftPlus;
                right += rightPlus;
                leftPlus++;
                rightPlus++;
            }
            if (a < left) ans = idxDiff + (left - a);
            else if (left <= a && a <= right) ans = idxDiff;
            else ans = idxDiff + (a - right);
        }
        return ans;
    }

    static int getUpperBound(int input) {
        int start, end, mid;
        start = 1;
        end = ARR_SIZE;
        mid = (start + end) / 2;
        while (start != end) {
            if (input <= arr[mid]) end = mid;
            else start = mid + 1;
            mid = (start + end) / 2;
        }
        return start;
    }
}
