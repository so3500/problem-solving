package modern_java_in_action.ch2;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class ApplePrinter {
	public static void prettyPrintApple(List<Apple> inventory, Consumer<Apple> applePrinter) {
		inventory.forEach(applePrinter);

		UnaryOperator<String> CREATE_USER_KEY = userId -> "postfix" + userId + "_" + LocalDateTime.now().toString();

		String userId = "my_id";
		String userKey = CREATE_USER_KEY.apply(userId);
	}
}
