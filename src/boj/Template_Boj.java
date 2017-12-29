// 가장 큰 정사각형
//
// 다이나믹 프로그래밍, 동적 계획법
//
//
/*
* 가장 큰 정사각형
* https://www.acmicpc.net/problem/1915
* 알고리즘: 다이나믹 프로그래밍(동적 계획법)
* 풀이방법: matrix[row][col]은 해당 정사각형의 맨 오른쪽 아래이며 길이 정보를 저장한다.
* 의사코드:
*   input n, m
*   declare matrix[n][m]
*   for row 0 to n-1
*       find maxValue(1) in matrix[row][0]
*   for col 0 to m-1
*       find maxValue(1) in matrix[0][col]
*   for row 1 to n-1
*       for col 1 to m-1
*           if matrix[row][col] = 1
*               matrix[row][col] <- min(matrix[row-1, col-1], matrix[row, col-1], matrix[row-1, col]) + 1
*               answer <- max(answer, matrix[row][col])
*
*   return answer^2
*
* 시간복잡도(Time Complexity)
*
* 공간복잡도(Space Complexity)
* */

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
