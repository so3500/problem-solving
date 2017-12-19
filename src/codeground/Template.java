//package codeground;
//
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
