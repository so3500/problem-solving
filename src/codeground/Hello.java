package codeground;

/*
* 문제: 45 / SCPC 연습문제 / 안녕 / 0.34129
* link: https://www.codeground.org/practice
* 알고리즘: 구현
* 풀이방법:
*   입력받은 문자열에서 각 문자가 나온 횟수를 센다.
*   'l' 횟수는 2로 나눠준다.
*   각 문자가 나온 횟수 중 최소값이 곧 hello 문자열을 만들 수 있는 수 이므로 최소값을 구한다.
*
* 의사코드(Pseudo Code)
*   input T
*   each T
*       answer <- 0
*       input testString
*       init charCount[4] // h, e, o, l 순으로 각 문자가 나온 횟수 저장
*
*       for i: 0 to testString.length()
*           if testString[i] == 'h': charCount[0]++
*           if testString[i] == 'e': charCount[1]++
*           if testString[i] == 'o': charCount[2]++
*           if testString[i] == 'l': charCount[3]++
*       charCount[3] /= 2 // 'l'은 2개씩 필요함
*
*       answer <- minimum of charCount*
*
* 시간복잡도(Time Complexity)
*   길이가 N인 문자열에 대해 연산
*   O(N)
*
* 공간복잡도(Space Complexity)
*   입력 N 길이 만큼의 문자열 사용
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

//class Solution {
class Hello {
    static int Answer;

    public static int min(int a, int b, int c, int d){
        return Integer.min(Integer.min(a, b), Integer.min(c, d));
    }

    public static void main(String args[]) throws Exception	{
//        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream("input.txt"));
//        BufferedReader br = new BufferedReader(new FileReader("input.txt")); // BufferedReader for file
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader for keyboard
//        int T = sc.nextInt();
//        int T = Integer.parseInt(br.readLine()); // br
//        StringTokenizer st = new StringTokenizer(br.readLine()); // line 기준 입력
//        int a = Integer.parseInt(st.nextToken()); // 공백 기준 입력 e.g. 1 2 3 4 5 받을 때
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[] charCount = new int[4]; // h, e, o, l
        String inputString = null;
        int i;

        for(int test_case = 0; test_case < T; test_case++) {
            Answer = 0;
            Arrays.fill(charCount, 0);
            inputString = br.readLine();

            // 입력 문자열에서 각 글자가 나온 수를 구한다.
            for (i=0; i<inputString.length(); i++){
                switch (inputString.charAt(i)){
                    case 'h':
                        charCount[0]++;
                        break;
                    case 'e':
                        charCount[1]++;
                        break;
                    case 'o':
                        charCount[2]++;
                        break;
                    case 'l':
                        charCount[3]++;
                        break;
                }
            }
            charCount[3] /= 2; // l은 두개가 있어야 hello 하나를 만들 수 있으므로, 2로 나눈 몫의 값으로 바꾼다.

            // print minimum(charCount[0] to [3])
            Answer = min(charCount[0], charCount[1], charCount[2], charCount[3]);

            // Print the answer to standard output(screen).
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}
