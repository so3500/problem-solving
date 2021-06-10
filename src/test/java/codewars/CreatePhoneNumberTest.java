package codewars;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CreatePhoneNumberTest {

	@Test
	void createPhoneNumber() {
		assertThat(CreatePhoneNumber.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0})).isEqualTo("(123) 456-7890");
		assertThat(CreatePhoneNumber.createPhoneNumber(new int[] {0, 0, 0, 0, 0, 0, 1, 1, 1, 1})).isEqualTo("(000) 000-1111");
	}
}