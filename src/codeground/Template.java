//package codeground;

/*
* 문제: 64 / SCPC 1회 예선 / 방속의 거울 / 0.34129
* link: https://www.codeground.org/practice
* 알고리즘: 구현
* 풀이방법:
*   입력받은 숫자 중 홀수 번으로 입력받은 숫자에 대한 xor 연산 결과를 출력한다.
*   짝수번으로 입력받은 숫자에 대해서 xor 연산을 수행 하면 해당 숫자는 상쇄되는 성질을 이용한다.
* 의사코드(Pseudo Code)
*   input T
*   each T
*       answer <- 0
*       input N
*       for i: 0 to N-1
*           input number
*           answer <- answer xor number*
*
* 시간복잡도(Time Complexity)
*   각 TestCase T에 대하여 N개의 숫자를 입력받고 연산을 수행하므로 O(TN)
*
* 공간복잡도(Space Complexity)
*   자료구조를 사용하지 않음. O(1)
*
* */

///*
//You should use the statndard input/output
//
//in order to receive a score properly.
//
//Do not use file input and output
//
//Please be very careful.
//*/
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.FileReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Scanner;
//import java.util.StringTokenizer;
//
///*
//   As the name of the class should be Solution , using Solution.java as the filename is recommended.
//   In any case, you can execute your program by running 'java Solution' command.
// */
//class Solution {
//    static int Answer;
//
//    public static void main(String args[]) throws Exception	{
//		/*
//		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
//		   To test your program, you may save input data in input.txt file,
//		   and call below method to read from the file when using nextInt() method.
//		   You may remove the comment symbols(//) in the below statement and use it.
//		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
//		 */
//
//		/*
//		   Make new scanner from standard input System.in, and read data.
//		 */
//        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream("input.txt"));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt")); // BufferedReader for file
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader for keyboard
//
//        int T = sc.nextInt();
//        int T = Integer.parseInt(br.readLine()); // br
//        StringTokenizer st = new StringTokenizer(br.readLine()); // line 기준 입력
//        Integer.parseInt(st.nextToken()) // 공백 기준 입력 e.g. 1 2 3 4 5 받을 때
//        for(int test_case = 0; test_case < T; test_case++) {
//
//            // Answer = 0;
//            /////////////////////////////////////////////////////////////////////////////////////////////
//			/*
//			   Implement your algorithm here.
//			   The answer to the case will be stored in variable Answer.
//			 */
//            /////////////////////////////////////////////////////////////////////////////////////////////
//
//
//            // Print the answer to standard output(screen).
//            System.out.println("Case #"+(test_case+1));
//            System.out.println(Answer);
//        }
//    }
//}
