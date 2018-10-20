package sw_test.woowa.test_2018_1_1st;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int solution(int A, int B, int C, int D) {
		int ret;
		ret = Integer.MIN_VALUE;

		// (A,B), (C,D)
		ret = Integer.max(ret, getSquaredDist(A, B, C, D));
		// (A,B), (D,C)
		ret = Integer.max(ret, getSquaredDist(A, B, D, C));
		// (B,A), (C,D)
		ret = Integer.max(ret, getSquaredDist(B, A, C, D));
		// (B,A), (D,C)
		ret = Integer.max(ret, getSquaredDist(B, A, D, C));

		// (A,C), (B,D)
		ret = Integer.max(ret, getSquaredDist(A, C, B, D));
		// (A,C), (D,B)
		ret = Integer.max(ret, getSquaredDist(A, C, D, B));
		// (C,A), (B,D)
		ret = Integer.max(ret, getSquaredDist(C, A, B, D));
		// (C,A), (D,B)
		ret = Integer.max(ret, getSquaredDist(C, A, D, B));

		// (A D), (B C)
		ret = Integer.max(ret, getSquaredDist(A, D, B, C));
		// (A D), (C B)
		ret = Integer.max(ret, getSquaredDist(A, D, C, B));
		// (D A), (B C)
		ret = Integer.max(ret, getSquaredDist(D, A, B, C));
		// (D A), (C B)
		ret = Integer.max(ret, getSquaredDist(D, A, C, B));

		return ret;

	}

	public static int getSquaredDist(int a, int b, int c, int d) {
		int xDist, yDist, squaredDist;
		xDist = Math.abs(a - c);
		yDist = Math.abs(b - d);
		squaredDist = (int) Math.pow(xDist, 2) + (int) Math.pow(yDist, 2);
		return squaredDist;
	}
}
