package sw_test.scpc_2018_r1;

import java.util.Scanner;

public class B {

	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
		sc.close();
	}

}
