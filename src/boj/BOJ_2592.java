/*
* 문제: 대표값
* link: https://www.acmicpc.net/problem/2592
* 알고리즘: 수학, 구현 
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

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_2592 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int sum = 0;
		Map<Integer, Integer> table = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			int num = sc.nextInt();
			sum += num;
			if (table.containsKey(num)) {
				int cnt = table.get(num);
				table.put(num, cnt + 1);
			} else {
				table.put(num, 1);
			}
		}

		int avg = sum / 10;
		int maxCnt, maxCntNum;
		maxCnt = 0;
		maxCntNum = 0;
		for (Map.Entry<Integer, Integer> entry : table.entrySet()) {
			if (entry.getValue() > maxCnt) {
				maxCnt = entry.getValue();
				maxCntNum = entry.getKey();
			}
		}

		System.out.println(String.format("%d\n%d", avg, maxCntNum));
		sc.close();
	}

}
