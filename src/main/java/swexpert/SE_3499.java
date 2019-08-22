/*
 * 문제: 3499 퍼펙트 셔플 / 140 ms
 * link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWGsRbk6AQIDFAVW
 * 알고리즘: 구현, 문자열
 * 풀이방법:
 *      전제 문자열을 입력받음
 *      aIndex, bIndex 를 두고 증가시키면서 newCard 에 복사
 *
 * 의사코드(Pseudo Code)
 *
 * 시간복잡도(Time Complexity)
 *   입력 N일 때 1차원 배열을 모두 탐색하는 경우
 *   O(N)
 *
 * 공간복잡도(Space Complexity)
 *   입력 N일 때 1차원 배열 사용
 *   O(N)
 *
 * */

package swexpert;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class SE_3499 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] card, newCard;
        card = new String[1000];
        newCard = new String[1000];
        int N, T, t, len, i, aIdx, bIdx, idx;
        T = sc.nextInt();
        for (t = 1; t <= T; t++) {
            N = sc.nextInt();
            Arrays.fill(card, null);
            Arrays.fill(newCard, null);
            for (i = 0; i < N; i++) card[i] = sc.next();
            idx = 0;
            if (N % 2 == 0) {
                aIdx = 0;
                bIdx = N / 2;
                while (bIdx < N) {
                    newCard[idx++] = card[aIdx++];
                    newCard[idx++] = card[bIdx++];
                }
            } else {
                aIdx = 0;
                bIdx = N / 2 + 1;
                while (bIdx < N) {
                    newCard[idx++] = card[aIdx++];
                    newCard[idx++] = card[bIdx++];
                }
                newCard[idx] = card[aIdx];
            }

            bw.write("#" + t + " ");
            for (i = 0; i < N; i++) bw.write(newCard[i] + " ");
            bw.write("\n");
            bw.flush();
        }
        bw.close();
        sc.close();
    }
}
