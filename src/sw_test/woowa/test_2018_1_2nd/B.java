package sw_test.woowa.test_2018_1_2nd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B {

	static boolean[] S;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		int[] A = new int[100000001];
		int n, a, b, i, from, idx, min, max;
		String last;
		n = Integer.parseInt(input);
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		for (i = 0; i < n; i++) {
			String[] in = br.readLine().split(" ");
			a = Integer.parseInt(in[0]);
			b = Integer.parseInt(in[1]);
			if (b > 100000000) {
				b = 10000000;
			}
			min = Integer.min(min, a);
			max = Integer.max(max, b);
			for (idx = a; idx < b; idx++) {
				A[idx]++;
			}
		}
		if (A[min] % 2 == 1) {
			bw.write("(-, " + min + ")\n");
			if (A[max] % 2 == 1) { // ~ ) ... ( ~
				last = "(-, " + max + ")\n";
				for (idx = min + 1; idx < max; idx++) {
					if (A[idx - 1] < A[idx] && A[idx] % 2 == 0) {
						
					} else if (A[idx - 1] > A[idx]) {

					}
				}
				bw.write(last);
			} else { // ~ ) ... [ ~

			}
		} else {
			if (A[max] % 2 == 1) { // ~ ] ... ( ~
				last = "(-, " + max + ")\n";

				bw.write(last);
			} else { // ~ ] ... [ ~

			}
		}

		bw.flush();
	}
}
