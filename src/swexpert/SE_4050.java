/*
 * 문제: 4050. 재관이의 대량 할인 / 614 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIseXoKEUcDFAWN&categoryId=AWIseXoKEUcDFAWN&categoryType=CODE
 * 알고리즘: 구현
 * 풀이방법:
 *      가격이 가장 비슷한 상품끼리 묶었을 때 최대로 할인 받을 수 있다.
 *      1 2 / 2 2 2 / 2 4 4 / 4 6 6 / 6 6 6 / 9 9 10
 *      의 경우 위와 같이 묶을 때 이다.
 *      따라서 입력받은 가격을 정렬한 뒤 배열의 뒤에서부터 탐색을 한다.
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *      입력 N에 대하여 길이 N의 정수배열을 정렬 O(NlogN)
 *      sum 값을 구하기 위해 길이 N의 배열을 탐색 O(N)
 *      O(NlogN)
 *
 * 공간복잡도(Space Complexity)
 *      입력 N에 대하여 비례하는 1차원 배열을 사용하므로
 *      O(N)
 *
 * */

package swexpert;

import java.util.Arrays;
import java.util.Scanner;

public class SE_4050 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T, t, N, i, cnt, sum;
        int[] arr;
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            N = sc.nextInt();
            arr = new int[N];
            for (i = 0; i < N; i++) arr[i] = sc.nextInt();
            Arrays.sort(arr);
            cnt = 0;
            sum = 0;
            for (i = N - 1; i >= 0; i--) {
                // 세 개 묶은 상품 중 최소가격 상품을 sum에서 제외
                if (cnt == 2) {
                    cnt = 0;
                    continue;
                }
                sum += arr[i];
                cnt++;
            }
            System.out.println("#" + t + " " + sum);
        }
    }
}
