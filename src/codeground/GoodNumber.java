package codeground;
/*
* 문제: 7 / SCPC 연습문제 좋은 수 / 1.92689초
* link: https://www.codeground.org/practice
* 알고리즘: 구현
* 풀이방법: N개의 숫자(a1, a2, ... , an)을 입력받으면서 ak가 a1 ... ak-1 수를 더하여 나오는 결과(중복허용)값과 같을경우
*           그 수를 좋은수라 하고, 카운팅
* 의사코드(Pseudo Code)
*   input T
*   init HashSet oneSet, twoSet
*   init three[]
*   each T
*       answer <- 0
*       input N
*       SIZE_OF_THREE_SET <- 100000
*       clear oneSet, twoSet, three
*       for i 0 to N-1
*           input number
*           if number in three
*               cnt <- cnt + 1
*
*           oneSet.add(number)
*
*           for element in oneSet
*               twoSet.add(number + element)
*
*           for element in twoSet
*               threeSet[element + SIZE_OF_THREE_SET) <- true
*
*
* 시간복잡도(Time Complexity)
*   set에 대한 시간복잡도 이론 공부 필요
*
*
* 공간복잡도(Space Complexity)
*
*
* */

/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
//class Solution {
class GoodNumber {
    static int Answer;
    public static HashSet<Integer> oneSet;
    public static HashSet<Integer> twoSet;
    public static boolean[] threeSet;

    public static void main(String args[]) throws Exception {
//        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream("input.txt"));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt")); // BufferedReader for file
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader for keyboard

        final int SIZE_OF_THREE_SET = 1000000;
//        int T = sc.nextInt();
        int T = Integer.parseInt(br.readLine());
        int N, number, i, goodNumber, revisionNumber, temp;
        oneSet = new HashSet<>();
        twoSet = new HashSet<>();
        threeSet = new boolean[2 * SIZE_OF_THREE_SET + 1];

        for (int test_case = 0; test_case < T; test_case++) {
            Answer = 0;
            /////////////////////////////////////////////////////////////////////////////////////////////
            /*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            oneSet.clear();
            twoSet.clear();
            Arrays.fill(threeSet, false);
//            oneSet = new HashSet<>();
//            twoSet = new HashSet<>();
//            threeSet = new boolean[2 * SIZE_OF_THREE_SET + 1];
            goodNumber = 0;
            revisionNumber = 0;

//            N = sc.nextInt();
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (i = 0; i < N; i++) {
//                number = sc.nextInt();
                number = Integer.parseInt(st.nextToken());
                revisionNumber = number + SIZE_OF_THREE_SET;
                if (threeSet[revisionNumber]) {
                    goodNumber++;
                }

                if (oneSet.contains(number)){
                    continue;
                }

                oneSet.add(number);

                for (Integer element : oneSet) {
                    twoSet.add(element + number);
                }

                for (Integer element : twoSet) {
                    temp = element + number;
                    if (-SIZE_OF_THREE_SET <= temp && temp <= SIZE_OF_THREE_SET){
                        threeSet[temp + SIZE_OF_THREE_SET] = true;
                    }
                }
            }
            Answer = goodNumber;
            /////////////////////////////////////////////////////////////////////////////////////////////
            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.println(Answer);
        }
    }
}
