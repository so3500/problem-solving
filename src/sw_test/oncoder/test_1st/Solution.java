package sw_test.oncoder.test_1st;

import java.util.regex.Pattern;

import java.util.HashMap;
import java.util.Map;

// https://www.oncoder.com
//에디터 기능을 더 잘 지원하는 이클립스를 통해 소스코드를 작성하였습니다.
public class Solution {

	// 1. 문자열 변환
	public String decryptSpell(String str) {
		StringBuilder builder = new StringBuilder(str);
		int strLen = builder.length();
		if (strLen >= 3) {
			// 문자열에서 3으로 나누어 떨어지는 순서에 있는 문자만 검사한다.
			for (int idx = 2; idx < strLen; idx += 3) {
				// 정규식을 사용하여 조건에 해당하는 문자열을 대무자로 변환한다.
				if (Pattern.matches("[a-z]", builder.substring(idx, idx + 1))) {
					builder.replace(idx, idx + 1, builder.substring(idx, idx + 1).toUpperCase());
				} else {
					builder.replace(idx, idx + 1, "!");
				}
			}
		}
		return builder.toString();
	}

	// ===================================
	// 2번 문제: 해시 M값 구하기
	// 1 ~ 2^24 (16,777,216)
	public int getHashM(int maxK, int collision) {
		int L = maxK / collision;

		if (L > 2) {
			int tempL = L;
			int cnt = 0;
			// bit 연산을 활용하여 L과 가장 가까운 2의 제곱수를 구한다.
			while (tempL > 0) {
				cnt++;
				tempL = (tempL >> 1);
			}
			// 2의 가까운 제곱
			int start = (int) Math.pow(2, cnt - 1);
			int end = (int) Math.pow(2, cnt);

			boolean[] isNotPrime = initPrimeArr(start, end);

			int maxL = 0;
			int ret = 0;
			for (int cur = start; cur < end; cur++) {
				if (isNotPrime[cur] == false) { // 소수
					int l = Integer.min(cur - start, end - cur);
					if (l > maxL) { // 거리가 멀면
						ret = cur;
						maxL = l;
					}
				}
			}
			return ret;
		} else {
			return 2;
		}
	}

	// 에라토스 테네스의 체 알고리즘을 이용하여
	// start 부터 end 범위의 임의의 수의 소수 여부를
	// O(1)에 알 수 있는 정보가 저장된 배열 생성
	public boolean[] initPrimeArr(final int start, final int end) {
		boolean[] isNotPrime = new boolean[end];
		int num, cur, len;
		len = isNotPrime.length;
		for (cur = 2; cur < len; cur++) {
			num = cur;
			if (isNotPrime[num]) {
				continue;
			}
			num += cur;
			while (num < len) {
				isNotPrime[num] = true;
				num += cur;
			}
		}
		return isNotPrime;
	}

	// ===================================
	// 3. 패킷 줄이기
	public String encoder(String message) {
		// 1. bit table 생성
		Map<Character, String> stringBitMap = getStringBitMap();

		// 2. 입력을 bit string으로 변환
		StringBuilder bitString = new StringBuilder(message.length() * 8);
		for (int idx = 0; idx < message.length(); idx++) {
			bitString.append(stringBitMap.get(message.charAt(idx)));
		}

		// 3. padding 작업
		int q = bitString.length() / 8;
		int r = bitString.length() % 8;
		if (r > 0) {
			for (int cnt = 0; cnt < 8 - r; cnt++) {
				bitString.append('0');
			}
		}

		// 4. string을 16진수 문자 hex string으로 변환
		StringBuilder hexString = new StringBuilder(bitString.length() / 4);

		for (int curIdx = 0; curIdx < bitString.length(); curIdx += 8) {
			String hexSubString = bitString.subSequence(curIdx, curIdx + 8).toString();

			int hex = 0;
			int digit = 1;
			for (int i = 7; i >= 0; i--) {
				if (hexSubString.charAt(i) == '1') {
					hex += digit * 1;
				}
				digit *= 2;
			}
			hexString.append(String.format("%02X", hex));
		}

		return hexString.toString();
	}

	public Map<Character, String> getStringBitMap() {
		Map<Character, String> stringBitMap = new HashMap<>();

		putStringBit(stringBitMap, 'a', 0, 25); // a ~ z
		putStringBit(stringBitMap, 'A', 26, 51); // A ~ Z
		putStringBit(stringBitMap, '0', 52, 61); // 0 ~ 9
		putStringBit(stringBitMap, ' ', 62, 62); // 공백

		return stringBitMap;
	}

	public void putStringBit(Map<Character, String> stringBitMap, char chr, int start, int end) {
		char curChr = chr;
		for (int num = start; num <= end; num++) {
			StringBuilder sb = new StringBuilder(6);
			int tmpNum = num;
			for (int cnt = 0; cnt < 6; cnt++) {
				if ((tmpNum & 1) == 1) {
					sb.insert(0, '1');
				} else {
					sb.insert(0, '0');
				}
				tmpNum = tmpNum >> 1;
			}
			stringBitMap.put(curChr, sb.toString());
			curChr += 1;
		}
	}

	// ===================================
}
