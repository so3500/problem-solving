package modern_java_in_action.ch10;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class LambdaTest {
	@Test
	void stacktraceTest() {
		List<Point> nums = Arrays.asList(new Point(1, 2), null);
		nums.stream().map(p -> p.x).forEach(System.out::println);
	}

	record Point(
		int x,
		int y
	) {
	}
}