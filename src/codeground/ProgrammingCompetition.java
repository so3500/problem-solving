package codeground;

/*
* 문제: 69 / SCPC 연습문제 프로그래밍 경진대회
* link: https://www.codeground.org/practice
* 알고리즘: 구현
* 풀이방법:
*   아래 주석 참고
* 의사코드(Pseudo Code)
*   input T
*   each T
*       answer <- 0
*       input N
*       init score[N+1]
*       input N scores to score
*       sort score in ascending order
*
*       get maxScore (a1+N, a2+(N-1), ... , aN + 1) // maxScore is minimum of maxScore
*
*       for i: 1 to N
*           if score[i] + N >= maxScore
*               Answer <- Answer + 1
*
*
* 시간복잡도(Time Complexity)
*   각 TestCase T에 대하여 N개의 숫자를 입력받고, N 크기의 배열을 선언
*   maxScore 를 구하기 위해 크기 N의 배열에 대해 연산,
*   Answer 를 구하기 위해 크기 N의 배열에 대해 연산
*   O(N)
*
* 공간복잡도(Space Complexity)
*   크기 N 배열 사용
*   O(N)
*
* */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
//class Solution {
class ProgrammingCompetition {
    static int Answer;

    public static void main(String args[]) throws Exception {
        /*
           The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */

		/*
           Make new scanner from standard input System.in, and read data.
		 */
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileInputStream("input.txt"));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt")); // BufferedReader for file
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader for keyboard

        int T = sc.nextInt();
//        int T = Integer.parseInt(br.readLine()); // br
//        StringTokenizer st = new StringTokenizer(br.readLine()); // line 기준 입력
//        Integer.parseInt(st.nextToken()) // 공백 기준 입력 e.g. 1 2 3 4 5 받을 때

//        final int SIZE_OF_SCORE = 300000;
        int N, target, plus, maxScore;

        /*
         * 실행시간
         * 최대 크기의 배열을 선언하고, 각 테스트 케이스마다 초기화하면서 사용할 때: .5605s,
         * 각 테스트 케이스마다 N을 입력받고 N에 해당하는 배열을 선언할 때: .5679s
         *
         * 실행시간 차이: <10ms
         * 사용 메모리 차이: <3000byte
         */
//        int[] score = new int[SIZE_OF_SCORE+1];

        for (int test_case = 0; test_case < T; test_case++) {

            Answer = 0;
            /////////////////////////////////////////////////////////////////////////////////////////////
            /*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            N = sc.nextInt();
//            Arrays.fill(score, 1, N+1, 0);
            int[] score = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                score[i] = sc.nextInt();
            }
            Arrays.sort(score);
//            Arrays.sort(score, 0, N+1);
            plus = N;
            maxScore = 0;

            /*
            *   index 1, 2, 3 ... N(오름차순) 정렬된 상태에서 마지막 라운드에서 나올 수 있는 max 값 중 최소값을 구한다.
            *   그 방법은 아래와 같다.
            *   maxScore = max(a1+N, a2+(N-1), ... , aN + 1)
            *
            *   그리고 각 점수에서 N을 더한 점수가 (a1+N, a2+N, ... , aN+N) maxScore 보다 크다면,
            *   해당 사람은 우승가능성이 있다.
            *
            *   maxScore 의 값을 가능한 최소로 잡아야 우승 가능성이 있는 사람의 수가 많아진다.
            *
            * */
            for (target = 1; target <= N; target++) {
                maxScore = Integer.max(score[target] + plus, maxScore);
                plus--;
            }

            for (target = 1; target <= N; target++) {
                if (maxScore <= score[target] + N) {
                    Answer++;
                }
            }
            /////////////////////////////////////////////////////////////////////////////////////////////
            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.println(Answer);
        }
    }
}
