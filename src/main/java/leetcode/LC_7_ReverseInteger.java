package leetcode;

public class LC_7_ReverseInteger {

	public int reverse(int x) {
		// Integer.MIN_VALUE * -1 is still Integer.MIN_VALUE
		if (x == 0 || x == Integer.MIN_VALUE) {
			return 0;
		}

		StringBuilder reverseStr = new StringBuilder();
		boolean isNegative = false;
		if (x < 0) {
			isNegative = true;
			x *= -1;
		}

		while (x != 0) {
			reverseStr.append(x % 10);
			x /= 10;
		}

		long reverseLong = Long.parseLong(reverseStr.toString());
		if (isNegative) {
			reverseLong *= -1;
		}

		if ((!isNegative && reverseLong > Integer.MAX_VALUE) ||
				(isNegative && reverseLong < Integer.MIN_VALUE)) {
			return 0;
		}

		return (int) reverseLong;
	}
}
