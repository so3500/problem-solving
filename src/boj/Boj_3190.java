/*
* 문제: 3190 뱀 / 156 ms
* link: https://www.acmicpc.net/problem/3190
* 알고리즘: 구현, 시뮬레이션
* 풀이방법:
*
* 의사코드(Pseudo Code)
*
* 시간복잡도(Time Complexity)
*
* 공간복잡도(Space Complexity)
*
* */

package boj;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Boj_3190 {

	static int N, K, L, sec;
	static boolean[][] map, visited; // map: 사과 존재 여부, visited: 뱀 존재 여부
	static List<Snake> S; // 뱀 리스트
	static List<Query> Q; // 질의 리스트
	static int[] rows = { -1, 0, 1, 0 };
	static int[] cols = { 0, 1, 0, -1 };

	static class Snake {
		int r, c;

		public Snake(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class Query {
		int sec;
		char query;

		public Query(int sec, char query) {
			this.sec = sec;
			this.query = query;
		}
	}

	public static void main(String[] args) {
		init();
		solve();
		System.out.println(sec);
	}

	static void init() {
		Scanner sc = new Scanner(System.in);
		int r, c, i, second;
		char dir;
		N = sc.nextInt();
		K = sc.nextInt();
		map = new boolean[N][N];
		visited = new boolean[N][N];
		for (i = 0; i < K; i++) {
			r = sc.nextInt() - 1;
			c = sc.nextInt() - 1;
			map[r][c] = true;
		}
		L = sc.nextInt();
		Q = new LinkedList<>();
		for (i = 0; i < L; i++) {
			second = sc.nextInt();
			dir = sc.next().charAt(0);
			Q.add(new Query(second, dir));
		}
		sec = 0;
		S = new LinkedList<>();
		S.add(new Snake(0, 0));
		sc.close();
	}

	// 머리를 늘렸는데 꼬리가 거기 있으면? DIE
	static void solve() {
		int toR, toC, dir;
		Query q = Q.remove(0);
		Snake head, tail;
		dir = 1; // 기본 방향(동쪽)
		while (true) {
			// 1. 해당 시간(초)에 방향 전환 정보가 있으면 전환
			if (sec == q.sec) {
				if (q.query == 'D') { // 오른쪽
					dir = (dir + 1) % 4;
				} else { // 왼쪽
					dir = (dir + 3) % 4;
				}
				
				if(!Q.isEmpty()) { // 명령이 남아있을 경우
					q = Q.remove(0);
				}
			}
			// 2. 다음 위치(row, col) 구하기
			head = S.get(0);
			toR = head.r + rows[dir];
			toC = head.c + cols[dir];
			sec++;
			
			// 3. 보드를 벗어나거나 자기 몸에 부딪히면 끝
			if (toR < 0 || toC < 0 || N <= toR || N <= toC || visited[toR][toC]) {
				break;
			}
			visited[toR][toC] = true;
			S.add(0, new Snake(toR, toC));
			
			// 4. 사과가 없으면 꼬리 자름
			if (!map[toR][toC]) { 
				tail = S.remove(S.size() - 1);
				visited[tail.r][tail.c] = false; 
			} else { // 사과가 있으면 먹음
				map[toR][toC] = false;				
			}
		}
	}
}
