package competition.codeground;
/*
 * 문제: 3 / SCPC 연습문제 시험공부 / 0.39192초
 * link: https://www.codeground.org/practice
 * 알고리즘: 구현
 * 풀이방법: N개의 숫자를 입력받고, 정렬한 뒤 내림차순으로 K개의 숫자의 합을 출력
 * 의사코드(Pseudo Code)
 *   input T
 *   each T
 *       answer <- 0
 *       input N, K
 *       init subjectScore[N]
 *       sort subjectScore
 *       for i N-K to N-1
 *           answer <- answer + subjectScore[i]
 *
 * 시간복잡도(Time Complexity)
 *   각 testCase T 에서 입력 N에 대하여 N개의 배열을 초기화 및 사용하므로
 *   O(TN)
 * 공간복잡도(Space Complexity)
 *   input N일때 길이 N인 배열이 필요
 *   O(N)
 *
 * */

/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
//class Solution {
class TestStudy {
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

        int T = sc.nextInt();
        int N, K, i;
//        final int NUMBER_OF_SUBJECT = 200000;
//        int[] subjectScore = new int[NUMBER_OF_SUBJECT + 5];

        for (int test_case = 0; test_case < T; test_case++) {
            Answer = 0;
            /////////////////////////////////////////////////////////////////////////////////////////////
            /*
               Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            N = sc.nextInt();
            K = sc.nextInt();
            int[] subjectScore = new int[N];
            for (i = 0; i < N; i++) {
                subjectScore[i] = sc.nextInt();
            }

            // Sorts the specified range of the array into ascending order.
//            Arrays.sort(subjectScore, 0, N - 1);
            Arrays.sort(subjectScore);

            // Get sum of the specified range of the array from N - K to N-1.
            for (i = N - K; i < N; i++) {
                Answer += subjectScore[i];
            }

//            Arrays.fill(subjectScore, 0, N - 1, 0);
            /////////////////////////////////////////////////////////////////////////////////////////////
            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.println(Answer);
        }
    }
}