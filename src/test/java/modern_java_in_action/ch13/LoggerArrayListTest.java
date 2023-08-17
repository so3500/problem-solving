package modern_java_in_action.ch13;

class LoggerArrayListTest {

	void test() {
		LoggerArrayList<String> loggerArrayList = new LoggerArrayList<>();
		loggerArrayList.add("Tom");
		loggerArrayList.logNow();
	}

}