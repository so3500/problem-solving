/*
* 문제: 1756 피자굽기 / 712 ms
* link: https://www.acmicpc.net/problem/1756
* 알고리즘: 배열, 구현
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1756 {

	static int[] oven;
	static int D, N, ans;
	static BufferedReader br;
	static String[] input;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
		System.out.println(ans);
		br.close();
	}

	public static void init() throws IOException {
		input = br.readLine().split(" ");
		D = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);
		oven = new int[D];
		input = br.readLine().split(" ");
		oven[0] = Integer.parseInt(input[0]);
		for (int i = 1; i < D; i++) {
			oven[i] = Integer.parseInt(input[i]);
			// 상단의 오븐길이가 하단의 오븐길이보다 짧을 경우, 짧은 상단의 오븐길이에 맞춘다. 어차피 짧은 길이만큼만 사용가능하므로
			if (oven[i - 1] < oven[i]) {
				oven[i] = oven[i - 1];
			}
		}

	}

	public static void solve() throws IOException {
		input = br.readLine().split(" ");
		int pizza, oIdx, pIdx;
		pizza = 0;
		pIdx = 0;
		pizza = Integer.parseInt(input[pIdx]);
		for (oIdx = D - 1; oIdx >= 0; oIdx--) {
			if (pizza <= oven[oIdx]) {
				pIdx++;
				if (pIdx == N) {
					break;					
				}
				pizza = Integer.parseInt(input[pIdx]);
			}
		}
		// 피자반죽이 오븐에 모두 들어간 경우
		if (pIdx == N) {
			ans = oIdx + 1;
		} else { // 피자반죽에 오븐에 모두 들어가지 않은 경우
			ans = 0;
		}
	}

}
