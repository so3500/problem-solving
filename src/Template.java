/*
* 문제: 43165 타켓넘버
* problem-link: https://programmers.co.kr/learn/courses/30/lessons/43104
* solution-link: https://bibibim.tistory.com/5
=======
* 문제: 5658. [모의 SW 역량테스트] 보물상자 비밀번호
* problem-link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRUN9KfZ8DFAUo
* solution-link: https://bibibim.tistory.com/8
*/

/*
* 문제: 1010 다리놓기
* link: https://bibibim.tistory.com/5
*/

/*
* 문제: 1662 압축
* link: https://www.acmicpc.net/problem/1662
* 알고리즘: 재귀호출
* 풀이방법:
*	( 괄호일 때 ( 괄호앞의 수를 재귀함수의 인수로 넘겨준다. 해당 수는 괄호안의 숫자 개수와 곱할 수
*	) 괄호일 때 이전 ( 괄호앞의 숫자와 () 괄호 내부의 숫자의 곱을 리턴
*	숫자일 때 전체 문자 수 +1
*
*/

/*
* 문제: 7562 나이트의이동 / 80 ms
* link: https://www.acmicpc.net/problem/11933
* 알고리즘: BFS
* 풀이방법:
*   큐에 시작 점 객체 (row, col, cnt:1) 추가
*   bfs 함수에서 큐에 하나도 남지 않을 때 까지 '시작 점에서 갈 수 있는 점' 추가
*       '시작 점에서 갈 수 있는 점'의 조건: 배열 범위 내, 이미 지나가지 않은 점
*       새 점 추가 시 이전 점 cnt+1 값을 초기값으로 줌.
*
* 의사코드(Pseudo Code)
*
* 시간복잡도(Time Complexity)
*   입력 N일 때 2차원 배열을 모두 탐색하는 경우
*   O(N^2)
*
* 공간복잡도(Space Complexity)
*   입력 N일 때 2차원 배열을 사용하는 경우
*   O(N^2)
*
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
