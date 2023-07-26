//package modern_java_in_action.ch2;
//
//import java.io.File;
//import java.util.List;
//import java.util.Optional;
//import java.util.PriorityQueue;
//import java.util.function.Consumer;
//
//import org.junit.jupiter.api.Test;
//
//class ApplePrinterTest {
//
//	@Test
//	void prettyPrintApple_printWeight() {
//		List<Apple> apples = List.of(new Apple(Color.RED, 10), new Apple(Color.GREEN, 20));
//		Consumer<Apple> weightPrinter = (Apple a) -> System.out.println("apple weight: " + a.weight());
//
//		ApplePrinter.prettyPrintApple(apples, (Apple a) -> System.out.println("apple weight: " + a.weight()));
//	}
//
//	@Test
//	void prettyPrintApple_printWeightAndColor() {
//		List<Apple> apples = List.of(new Apple(Color.RED, 10), new Apple(Color.GREEN, 20));
//		Consumer<Apple> weightAndColorPrinter = (Apple a) -> System.out.println("apple weight: " + a.weight() + " apple color: " + a.color());
//
//		ApplePrinter.prettyPrintApple(apples, weightAndColorPrinter);
//
//		ProcessHandle processHandle = ProcessHandle.current();
//		ProcessHandle.Info processInfo = processHandle.info();
//		processHandle.children().forEach(ProcessHandle::destroy);
//		Runtime.getRuntime().exec("command ...");
//
//
//
//		String javaCmd = ProcessUtils.getJavaCmd().getAbsolutePath();
//		ProcessBuilder processBuilder = new ProcessBuilder(javaCmd, "-version");
//		Process process = processBuilder.inheritIO().start();
//		ProcessHandle processHandle = process.toHandle();
//
//		PriorityQueue<Integer> intQueue = new PriorityQueue<>();
//
//		Optional.of(javaCmd).orElseThrow();
//		List.copyOf().toArray();
//	}
//
//	@Test
//	public void givenString_thenRevertValue() {
////		String text = "Baeldung";
////		String transformed = text.transform(value ->
////			new StringBuilder(value).reverse().toString()
////		);
////
////		try (new File("filename") { }.finalWrapper.finalCloseable) {
////			f
////			// do some stuff with finalCloseable
////		} catch (Exception ex) { }
//	}
//}