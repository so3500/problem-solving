/*
* 문제: 2112. [모의 SW 역량테스트] 보호 필름 / 2172 ms
* link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V1SYKAaUDFAWu
* 알고리즘: 완전 탐색
* 풀이방법:
*
* 의사코드(Pseudo Code)
*
* 시간복잡도(Time Complexity)
*
* 공간복잡도(Space Complexity)
*
* */

package swexpert;

import java.util.Scanner;

public class SE_2112 {

	static int D, W, K, minChangeCnt;
	static int[] film;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T, t;
		T = sc.nextInt();
		for (t = 1; t <= T; t++) {
			init(sc);
			
			if (isFilmValid()) {
				// 변경 0 회 때 검사
				minChangeCnt = Integer.min(minChangeCnt, 0);
			}
			else {
				// 각 셀 D개 중에서 1개 뽑아서 0 또는 1로 변경, 
				//			  2개 뽑아서 0 또는 1로 변경 ...,
				//			  D개 뽑아서 0 또는 1로 변경
				//			   해본 뒤 성능검사 수행
				for(int i=0; i<D; i++) {
					solve(i, 0, 1);
					solve(i, 1, 1);									
				}
			}
			System.out.println("#" + t + " " + minChangeCnt);
		}
		sc.close();
	}

	static void init(Scanner sc) {
		D = sc.nextInt();
		W = sc.nextInt();
		K = sc.nextInt();
		film = new int[D];
		visited = new boolean[D];
		for (int r = 0; r < D; r++) {
			for (int c = 0; c < W; c++) {
				film[r] += (sc.nextInt() << (W - c - 1));
			}
		}
		minChangeCnt = Integer.MAX_VALUE;
	}

	static void solve(int idx, int key, int changeCnt) {
		visited[idx] = true;

		int temp = film[idx];
		if ( key == 0) film[idx] = 0;
		else if (key == 1) film[idx] = ((1 << W) - 1);
		
		if (isFilmValid()) minChangeCnt = Integer.min(minChangeCnt, changeCnt);

		for (int i = idx; i < D; i++) {
			if (!visited[i]) {
				solve(i, 0, changeCnt + 1);
				solve(i, 1, changeCnt + 1);
			}
		}
		film[idx] = temp;
		visited[idx] = false;
	}

	// 단면의 모든 세로방향에 대해서 동일한 특성의 셀들이 K개 이상 연속 여부 검사
	static boolean isFilmValid() {
		boolean valid = true;
		int k, cell, col;
		for (int c = 0; c < W && valid; c++) {
			k = 1;
			col = W - c - 1;
			cell = (film[0] & (1 << col));
			for (int r = 1; r < D && valid; r++) {
				if (cell == (film[r] & (1 << col))) { // 셀이 연속적이면
					k++;
				} else { // 연속적이지 않으면
					k = 1;
					cell = film[r] & (1 << col); // 새로운 기준으로 변경
				}
				if (k >= K)
					break; // 조건 만족 시 해당 열은 더 이상 검사안함
			}
			if (k < K)
				valid = false; // 조건을 만족하지 않는 경우가 하나라도 나오면 fail
		}
		return valid;
	}
}
