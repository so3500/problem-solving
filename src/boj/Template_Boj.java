///*
//* 문제: 11933 ATM / 80ms
//* link: https://www.acmicpc.net/problem/11399
//* 알고리즘: 구현
//* 풀이방법:
//*   입력받은 숫자 중 홀수 번으로 입력받은 숫자에 대한 xor 연산 결과를 출력한다.
//*   짝수번으로 입력받은 숫자에 대해서 xor 연산을 수행 하면 해당 숫자는 상쇄되는 성질을 이용한다.
//* 의사코드(Pseudo Code)
//*   input T
//*   each T
//*       answer <- 0
//*       input N
//*       for i: 0 to N-1
//*           input number
//*           answer <- answer xor number*
//*
//* 시간복잡도(Time Complexity)
//*   각 TestCase T에 대하여 N개의 숫자를 입력받고 연산을 수행하므로 O(TN)
//*
//* 공간복잡도(Space Complexity)
//*   자료구조를 사용하지 않음. O(1)
//*
//* */
//

//import java.util.Arrays;
//import java.util.Scanner;
//import java.io.File;
//
//public class line_1 {
//
//    private static int solve(){
//
//    }
//
//    public static void main(String args[]) throws Exception{
//        File f = new File("input.txt");
//        Scanner scanner = new Scanner(f);
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println(solve());
//        }
//    }
//}
