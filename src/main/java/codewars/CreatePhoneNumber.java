package codewars;

public final class CreatePhoneNumber {

	private CreatePhoneNumber() {
	}

	public static String createPhoneNumber(int[] numbers) {
		String areaCode = convertToString(numbers, 0, 2);
		String exchangeNumber = convertToString(numbers, 3, 5);
		String number = convertToString(numbers, 6, 9);

		return String.format("(%s) %s-%s", areaCode, exchangeNumber, number);
	}

	private static String convertToString(int[] numbers, int from, int to) {
		StringBuilder sb = new StringBuilder();
		for (int i = from; i <= to; i++) {
			sb.append(numbers[i]);
		}
		return sb.toString();
	}
}