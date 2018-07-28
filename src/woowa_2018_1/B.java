package woowa_2018_1;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int solution(String A, String B) {
		int ret, i;
		char alecCard, bobCard;
		ret = 0;

		for (i = 0; i < A.length(); i++) {
			alecCard = A.charAt(i);
			bobCard = B.charAt(i);
			if (alecCard == bobCard) {
				continue;
			} else if (alecCard == 'A' || alecCard > bobCard) {
				ret++;
			}
			// bob이 이긴 경우는 따지지 않음
		}

		return ret;
	}

}
