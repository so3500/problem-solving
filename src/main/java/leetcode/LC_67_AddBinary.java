package leetcode;

import java.math.BigInteger;

/**
 * related topic: Math, String, Bit Manipulation, Simulation
 * Time Complexity:
 * Space Complexity:
 */
public class LC_67_AddBinary {
	public String addBinary(String a, String b) {
		BigInteger aBigInteger = new BigInteger(a, 2);
		BigInteger bBigInteger = new BigInteger(b, 2);

		BigInteger sumBigInteger = aBigInteger.add(bBigInteger);

		return sumBigInteger.toString(2);
	}
}