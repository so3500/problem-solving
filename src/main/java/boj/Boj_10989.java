/*
 * 문제: 10989 수 정렬하기3 / 6036 ms
 * link: https://www.acmicpc.net/problem/10989
 * 알고리즘: 정렬, 구현
 * 풀이방법:
 *  주어진 메모리는 8MB 로 제한, 시간은 5초.
 *  입력으로 주어지는 인덱스를 카운팅 한다.
 *  입력이 끝난 뒤 arr 배열을 1부터 10000 까지 순회하면서
 *  arr[k]=x 일 경우 k를 x번 출력한다.
 *  실제 주어진 입력을 정렬하지 않고, 정렬한 것 처럼 보이게 한 것이다.
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   입력 N일 때 이중 반복문에서
 *   바깥쪽 반복문은 상수만큼 수행. 안쪽 반복문은 N만큼 수행
 *   O(N)
 *
 * 공간복잡도(Space Complexity)
 *   입력 N에 관계없이 10000길이의 배열 사용
 *   O(1)
 *
 * */

package boj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Boj_10989 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N;
        int[] arr = new int[10001];
        N = sc.nextInt();
        // 입력받은 수에 해당하는 인덱스에 카운팅
        // e.g. 3을 2번 입력받을 경우 arr[3]=2
        for (int i = 0; i < N; i++) {
            arr[sc.nextInt()]++;
        }
        // arr[3]=2 일 경우 3을 두번 출력
        // arr[4]=0 일 경우 4는 출력 안함
        for (int i = 1; i <= 10000; i++) {
            for (int j = 1; j <= arr[i]; j++) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
