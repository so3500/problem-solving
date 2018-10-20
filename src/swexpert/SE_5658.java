/*
* 문제: 5658. [모의 SW 역량테스트] 보물상자 비밀번호
* problem-link: https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRUN9KfZ8DFAUo
* solution-link: https://bibibim.tistory.com/8
*/

package swexpert;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SE_5658 {

	static int N;
	static int K;
	static long pwd;
	static String box;
	static PriorityQueue<Long> pq;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			init(sc);
			findPwds();
			findPwdByOrder(K);
			System.out.println(String.format("#%d %d", test_case, pwd));
		}
		sc.close();
	}

	static void init(Scanner sc) {
		N = sc.nextInt();
		K = sc.nextInt();
		box = sc.next();
		pwd = 0L;
		pq = new PriorityQueue<>((o1, o2)-> {
			return Long.compare(o2, o1);
		});
	}

	static void findPwds() {
		HashSet<Long> set = new HashSet<>();
		int rotateCnt = N / 4;
		int from = 0;
		int next = N / 4;
		while (rotateCnt > 0) {
			// 각 회전 마다 4개의 16진수의 수를 구한다.
			for (int numCnt = 0; numCnt < 4; numCnt++) {
				int len = next;
				int idx = from;
				long pwd = 0L;
				long mul = (long) Math.pow(16, next - 1);
				// 한 변에 해당하는 16진수를 구하는 과정
				while (len > 0) {
					long hexNum = convertCharToHexNum(box.charAt(idx));
					pwd = pwd + mul * hexNum;
					mul /= 16;
					idx = (idx + 1) % N;
					len--;
				}
				if (!set.contains(pwd)) {
					pq.add(pwd);
					set.add(pwd);
				}
				from = (from + next) % N;
			}
			from = (from + 1) % N;
			rotateCnt--;
		}
	}

	static long convertCharToHexNum(char chr) {
		long num = 0;
		if (chr >= '0' && chr <= '9') {
			num = chr - '0';
		} else if (chr >= 'A' && chr <= 'F') {
			num = 10 + (chr - 'A');
		}
		return num;
	}

	static void findPwdByOrder(int order) {
		while (order > 0) {
			pwd = pq.poll();
			order--;
		}
	}

}
