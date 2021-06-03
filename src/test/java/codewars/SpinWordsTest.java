package codewars;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SpinWordsTest {

	@Test
	void spinWords() {
		assertThat(new SpinWords().spinWords("Welcome")).isEqualTo("emocleW");
		assertThat(new SpinWords().spinWords("Hey wollef sroirraw")).isEqualTo("Hey fellow warriors");
		assertThat(new SpinWords().spinWords("Hey fellow warriors")).isEqualTo("Hey wollef sroirraw");
		assertThat(new SpinWords().spinWords("This is a test")).isEqualTo("This is a test");
		assertThat(new SpinWords().spinWords("This is another test")).isEqualTo("This is rehtona test");
		assertThat(new SpinWords().spinWords("Just kidding there is still one more")).isEqualTo("Just gniddik ereht is llits one more");
	}

}