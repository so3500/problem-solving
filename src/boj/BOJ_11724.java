/*
* 문제: 11724 연결 요소의 개수
* link: https://www.acmicpc.net/problem/11724
* 알고리즘: dfs, bfs
* 풀이방법:
*
*/

package boj;

import java.util.Scanner;

class Graph {

	int vertexNum;
	int edgeNum;
	boolean[] visited;
	boolean[][] edge;

	public void init() {
		Scanner sc = new Scanner(System.in);
		vertexNum = sc.nextInt();
		edgeNum = sc.nextInt();
		visited = new boolean[vertexNum + 1];
		edge = new boolean[vertexNum + 1][vertexNum + 1];
		for (int cnt = 0; cnt < edgeNum; cnt++) {
			int fromVertex = sc.nextInt();
			int toVertex = sc.nextInt();
			edge[fromVertex][toVertex] = true;
			edge[toVertex][fromVertex] = true;
		}
		sc.close();
	}

	public void printConCom() {
		int conComNum = getConCom();
		System.out.println(conComNum);
	}

	public int getConCom() {
		int conComNum = 0;
		for (int fromVertex = 1; fromVertex <= vertexNum; fromVertex++) {
			if (!visited[fromVertex]) {
				dfs(fromVertex);
				conComNum++;
			}
		}
		return conComNum;
	}

	public void dfs(int fromVertex) {
		visited[fromVertex] = true;
		for (int toVertex = 1; toVertex <= vertexNum; toVertex++) {
			if (!visited[toVertex] && edge[fromVertex][toVertex]) {
				dfs(toVertex);
			}
		}
	}
}

public class BOJ_11724 {

	public static void main(String[] args) {
		Graph g = new Graph();
		g.init();
		g.printConCom();
	}

}
