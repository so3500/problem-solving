package competition.codeground;

/*
 * 문제: 54 / SCPC 2회 예선 / 프리랜서 / 0.12973
 * link: https://www.codeground.org/practice
 * 알고리즘: 다이나믹 프로그래밍(동적 계획법)
 * 풀이방법:
 *   P, Q 배열: 각 회사 정보
 *   Pay: Pay[k] 1주 에서 k주 까지 일했을 때 얻을 수 있는 최대 급여
 *
 * 의사코드(Pseudo Code)
 *   input T
 *   each T
 *       answer <- 0
 *       input N
 *       init P[N+1], Q[N+1], Pay[N+1]
 *       input number in P, Q
 *
 *       Pay[1] <- max(P[1], Q[1])
 *       Pay[2] <- max(Pay[1] + P[2], Q[2])
 *       for k: 3 to N
 *           Pay[k] <- max(Pay[k-1] + P[k], Pay[k-2] + P[k])
 *
 *       answer <- Pay[N]
 *
 * 시간복잡도(Time Complexity)
 *   입력 N에 대하여 크기 N인 배열의 모든 요소에 대해 연산하므로
 *   O(N)
 *
 * 공간복잡도(Space Complexity)
 *   입력 N에 대하여 크기 N인 배열 3개 사용
 *   O(N)
 *
 * */

/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
//class Solution {
class Freelancer {
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
//        Scanner sc = new Scanner(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new FileReader("input.txt")); // BufferedReader for file
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader for keyboard

//        int T = sc.nextInt();
        int T = Integer.parseInt(br.readLine()); // br
//        StringTokenizer st = new StringTokenizer(br.readLine()); // line 기준 입력

//        Integer.parseInt(st.nextToken()); // 공백 기준 입력 e.g. 1 2 3 4 5 받을 때
        int[] P, Q, Pay;
        int N, i;
        StringTokenizer st;
        for (int test_case = 0; test_case < T; test_case++) {

            Answer = 0;
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			*/
            N = Integer.parseInt(br.readLine());
            P = new int[N + 1];
            Q = new int[N + 1];
            Pay = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (i = 1; i <= N; i++) {
                P[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (i = 1; i <= N; i++) {
                Q[i] = Integer.parseInt(st.nextToken());
            }

            Pay[1] = Integer.max(P[1], Q[1]);
            Pay[2] = Integer.max(Pay[1] + P[2], Q[2]);
            for (i = 3; i <= N; i++) {
                Pay[i] = Integer.max(Pay[i - 1] + P[i], Pay[i - 2] + Q[i]);
            }

            Answer = Pay[N];
            /////////////////////////////////////////////////////////////////////////////////////////////
            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.println(Answer);
        }
    }
}
