package codeground;
/*
* 문제: SCPC 1회 예선 개구리 뛰기
* link: https://www.codeground.org/practice
* 알고리즘: 구현
* 풀이방법: 주의. a1 부터 an 까지 돌이 있을 때 개구리는 a0부터 시작함.
* 의사코드(Pseudo Code)
*   input T, N, (a1, a2, ... , an), K
*
*   start <- 0
*   end <- start + 1
*   noJump <- false
*   jumpcount <- 0
*
*   init stone[N]
*
*   while noJump is false
*       start <- end - 1
*       end <- start + 1
*       diff <- stone[end] - stone[start]
*
*       if maximum jump distance exceed
*           jumpCount <- -1
*           loop stop
*       else if reach the end
*           jumpCount <- jumpCount + 1
*           loop stop
*       else if no exceed, no end
*           search for next
*
* 시간복잡도(Time Complexity)
*   최악의 경우: 한 칸씩 점프하여 배열의 끝까지 가는 경우
*   input N일때 길이 N인 배열에 대하여 기본연산을 수행
*   O(N)
*
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
import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */

public class FrogJump {
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
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream("input.txt"));

        final int STONE_SIZE = 1000001;
        int T = sc.nextInt();
        int N, K, start, end, diff, jumpCount, i;
        boolean noJump;
        int[] stone = new int[STONE_SIZE];
        for (int test_case = 0; test_case < T; test_case++) {

            Answer = 0;
            /////////////////////////////////////////////////////////////////////////////////////////////
            /*
               Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            // input data
            N = sc.nextInt();
//            int[] stone = new int[N + 1];
            for (i = 1; i <= N; i++) {
                stone[i] = sc.nextInt();
            }
            K = sc.nextInt();

            // init variables
            start = 0;
            end = start + 1;
            jumpCount = 0;
            noJump = false;

            // algorithm
            while (!noJump) {
                start = end - 1;
                end = start + 1;
                diff = stone[end] - stone[start];

                    if (diff > K) {
                        noJump = true;
                        jumpCount = -1;
                    } else if (end == N) { // (&& diff <= K)
                        jumpCount++;
                    noJump = true;
                } else if (end != N) { // (&& diff <= K)
                    while (diff <= K) {
                        if (end == N) {
                            noJump = true;
                            break;
                        }
                        end = end + 1;
                        diff = stone[end] - stone[start];
                    }
                    jumpCount++;
                }
            }
            Answer = jumpCount;
            /////////////////////////////////////////////////////////////////////////////////////////////
            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.println(Answer);
        }
    }
}
