package woowa2_2018_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			int n = s.nextInt();
			int d = s.nextInt();
			int k = s.nextInt();
			int j = s.nextInt();
			int ans = solve(n, d, k, j);
			System.out.println(ans);
		}
	}

	public static int solve(int n, int d, int k, int j) {
		int ans, i, idx, cnt;
		ans = 1;
		List<Integer> list = new ArrayList<>();
		for (i = 1; i <= n; i++) {
			list.add(i);
		}

		idx = 0;
		cnt = k;
		while (list.size() > 1) {
			if (d == 1) { // 시계 방향
				idx = (idx + cnt) % list.size();
				list.remove(idx);
				idx = (idx - 1 + list.size()) % list.size();
			} else if (d == 0) { // 반시계 방향
				idx = (idx - cnt + list.size()) % list.size();
				idx = (idx + list.size()) % list.size();
				list.remove(idx);
			}
			cnt += j;
		}
		ans = list.get(0);
		return ans;
	}

}
