/*
* 문제: 1199 오일러 회로 / 1752ms
* link: https://www.acmicpc.net/problem/1199
* 알고리즘: 오일러 회로(서킷)
* 풀이방법:
*   DFS 알고리즘 사용하여 각 정점에 연결 되어 있으면서 아직 방문하지 않은 간선이 있을 경우
*   해당 간선을 통해 다른 정점으로 이동한다.
*   위 과정을 재귀로 반복하면서 특정 정점에서 더 이상 가용한 간선이 없을 때 까지 탐색 한다.
*   그 때 그 정점을 스택에 저장한다.
*   결과적으로 circuit 에는 경로의 끝점 부터 역순으로 간선들이 추가된다.
*
*   모든 과정이 끝난 뒤 스택에 저장된 element 를
*       꺼내면 오일러 회로가 완성된다.(무향 그래프에서)
*       꺼낸 뒤 역순으로 나열하면 오일러 트레일이 완성된다.(유향 그래프에서) 스택을 이용할 경우 해당 과정이 자동으로 됨.
*
*
*   오일러 (한붓 그리기) 문제 해결 조건
*       오일러 서킷: 모든 간선을 한 번 씩 지나서 시작점으로 돌아오는 경로가 존재
*       오일러 트레일: 모든 간선을 한 번 씩 지나는 경로가 존재(시작점과 끝점이 다르다.)
*       오일러 회로/경로 모두 모든 간선 수의 합은 짝수개여 함.
*
*       무향 그래프
*           오일러 회로(circuit): 모든 정점은 짝수개의 degree
*           오일러 경로(path, trail): 시작, 끝 정점만(즉 2개) 홀수 개의 degree
*           각 간선이 양방향으로 사용될 수 있기 떄문에 서킷을 뒤집을 필요도 없다.
*       유향 그래프
*           오일러 회로: indegree = outdegree
*           오일러 경로: 시작점은 outdegree가 한개 더 많고, 끝점은 indegree가 한개 더 많음
*           위와  방법으로 오일러 서킷을 찾을 떄는 결과적으로 얻은 순서를 뒤집어 줘야 한다.
*
* 의사코드(Pseudo Code)
*   input N
*   input N*N numbers in G[][]
*   if degree of any of vertex is odd
*       tourAvailable <- false
*
*   if tourAvailable
*       start <- 0
*       EulerCircuit(G, start)
*       print(element in stack)
*   else
*       print(-1)
*
*   eulerCircuit(G[][], start):
*       for dest: 0 to N-1
*           if G[start][dest] > 0
*               G[start][dest]--
*               G[dest][start]--
*               eulerCircuit(G, dest)
*
*       stack.push(start)
*
* 시간복잡도(Time Complexity)
*   오일러 서킷 함수 호출 횟수는 Edge 수 만큼, 오일러 서킷 안 반복문은 Vertex 만큼
*   O(VE)
*
* 공간복잡도(Space Complexity)
*   인접 행렬 사용
*   O(V^2)
*
* */


package boj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//public class Main {
public class EulerCircuit_1199 {
    private static int N;
    private static Stack<Integer> stack;

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // 변수 선언
        int start, row, col, degree;
        int[][] G;
        boolean tourAvailable;
        StringBuffer buffer = new StringBuffer();
        stack = new Stack<>();

        // 변수 초기화 및 입력 처리
        tourAvailable = true;
        N = Integer.parseInt(br.readLine());
        G = new int[N][N];
        for (row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            degree = 0;
            for (col = 0; col < N; col++) {
                G[row][col] = Integer.parseInt(st.nextToken());
                degree += G[row][col];
            }
            // 차수가 홀수인 정점이 존재할 경우 오일러회로 불가능(Eulerian circuit)
            // 차수가 홀수인 정점이 2개일 경우 오일러경로 가능(Eulerian path)
            if ((degree % 2) != 0) {
                tourAvailable = false;
                break;
            }
        }
        br = null;
        st = null;

        // 알고리즘, 오일러 회로
        if (tourAvailable) {
            start = 0;
            EulerCircuit(G, start);
            for (int elm : stack) {
                buffer.append(elm)
                      .append(" ");
            }
            System.out.println(buffer);
        } else {
            System.out.println("-1");
        }
    }

    private static void EulerCircuit(int[][] G, int start) {
        for (int dest = 0; dest < N; dest++) {
            if (G[start][dest] > 0) {
                G[start][dest]--;
                G[dest][start]--;
                EulerCircuit(G, dest);
            }
        }
        stack.push(start + 1);
    }
}
