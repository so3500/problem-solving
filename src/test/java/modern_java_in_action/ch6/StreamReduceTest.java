package modern_java_in_action.ch6;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class StreamReduceTest {

	@Test
	void reduceSum() {
		Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// 0 + 1 + 2 + 3 + 4 + ... + 10
		Integer sum = numbers.reduce(0, (total, n) -> total + n); // Integer::sum

		assertThat(sum).isEqualTo(55);
	}

	@Test
	void reduceMinus() {
		Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// 0 - 1 - 2 - 3 - 4 - ... - 10
		Integer sum = numbers.reduce(0, (total, n) -> total - n);

		assertThat(sum).isEqualTo(-55);
	}

	@Test
	void reduceSumParallel() {
		Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// 0 + (1 + 2) + (3 + 4) + ... + (9 + 10)
		Integer sum = numbers.parallel().reduce(0, (total, n) -> total + n); // Integer::sum

		assertThat(sum).isEqualTo(55);
	}

	@Test
	void reduceMinusParallel() {
		Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// 0 - (1 - 2) - (3 - 4) - ... - (9 - 10)
		Integer sum = numbers.parallel().reduce(0, (total, n) -> total - n);

		assertThat(sum).isEqualTo(-5); // -55
	}

	@Test
	void reduceMinusParallelCombine() {
		Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// 0 - 1 - 2 - 3 - 4 - ... - 10
		// 첫번째 연산의 결과가 다음 연산에 영향을 주기 때문에 나눠서 작업을 처리할 수 없게됨
		Integer sum = numbers.parallel().reduce(0,
			(total, n) -> total - n,
			(total1, total2) -> total1 + total2); // Integer::sum / 병렬 처리된 결과들의 관계를 설정함

		assertThat(sum).isEqualTo(-55);
	}
}
