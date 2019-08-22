/*
 * 문제: 10942 / 펠린드롬? / scanner 사용시: 4472 MS, BufferedReader StringBuffer 사용: 768 MS
 * link: https://www.acmicpc.net/problem/10942
 * 알고리즘: 다이나믹 프로그래밍
 * 풀이방법:
 *   pelindrom[left][right]: left 에서 시작하여 right 끝나는 수열의 펠린드롬 여부
 *
 * 의사코드(Pseudo Code)
 *   input N
 *   init sequence[N+1] with N numbers
 *   init pelindrom[N+1][N+1] with false
 *
 *   길이 1인 펠린드롬 여부 확인
 *   길이 2인 펠린드롬 여부 확인
 *   길이 3 이상인 펠린드롬여부 확인
 *
 *   input M
 *   for i: 1 to M
 *       input S, E
 *       if pelindrom[S][E]
 *           print 1
 *       else
 *           print 0
 *
 * 시간복잡도(Time Complexity)
 *   계차수열?
 *   O(N^2)
 *
 * 공간복잡도(Space Complexity)
 *   2차원 배열사용
 *   O(N^2)
 *
 * */

package boj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//public class Main {
public class Boj_10942 {

    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(new File("input.txt"));
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new FileReader("input.txt")); // BufferedReader for file
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader for keyboard

        int N, M, S, E;
        int left, right, mid, input, i;
        int[] sequence = null;
        boolean[][] pelindrom = null;
        StringTokenizer st = null;
        StringBuffer buffer = new StringBuffer();

//        N = sc.nextInt();
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        sequence = new int[N + 1];
        pelindrom = new boolean[N + 1][N + 1];
        for (i = 1; i <= N; i++) {
//            sequence[i] = sc.nextInt();
            sequence[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(pelindrom[i], false);
        }

        // 펠린드롬 알고리즘 O(N^2)
        // pelindrom[left][right]: left 에서 right 까지 수열에서 펠린드롬 여부
        // 1개 길이 펠린드롬 여부 확인
        for (left = 1; left <= N; left++) {
            right = left;
            pelindrom[left][right] = true;
        }
        // 2개 길이 펠린드롬 여부 확인
        for (left = 1; left <= N - 1; left++) {
            right = left + 1;
            if (sequence[left] == sequence[right]) {
                pelindrom[left][right] = true;
            }
        }
        // 3개 이상 길이 펠린드롬 여부 확인
        for (mid = 2; mid <= N - 1; mid++) {
            for (left = 1; left <= N - mid; left++) {
                right = left + mid;
                if (sequence[left] == sequence[right] && pelindrom[left + 1][right - 1]) {
                    pelindrom[left][right] = true;
                }
            }
        }

        // 질의
//        M = sc.nextInt();
        M = Integer.parseInt(br.readLine());
        for (i = 0; i < M; i++) {
//            S = sc.nextInt();
//            E = sc.nextInt();
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            if (pelindrom[S][E]) {
//                System.out.println(1);
                buffer.append("1\n");
            } else {
//                System.out.println(0);
                buffer.append("0\n");
            }
        }

        System.out.print(buffer);
    }
}
