package modern_java_in_action.ch13;

import java.time.LocalDateTime;

public interface LoggerList<E> {

	default void logNow() {
		System.out.println(LocalDateTime.now());
	}
}
