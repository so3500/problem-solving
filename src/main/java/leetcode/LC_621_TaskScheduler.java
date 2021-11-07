package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * related topic:
 * Time Complexity:
 * Space Complexity:
 *
 * TODO runtime :617ms -> 100ms 미만으로 줄이기
 *
 * https://leetcode.com/problems/task-scheduler/
 */
public class LC_621_TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
		Queue<Task> taskQueue = init(tasks, n);
		return schedule(taskQueue, n);
	}

	private int schedule(Queue<Task> taskQueue, int cooldownPeriod) {
		int runningTime = 0;

		while (!taskQueue.isEmpty()) {
			findRunnableAndRunTask(taskQueue, runningTime, cooldownPeriod);
			runningTime++;
		}

		return runningTime;
	}

	private void findRunnableAndRunTask(Queue<Task> taskQueue, int runningTime, int cooldownPeriod) {
		List<Task> temp = new ArrayList<>();

		while (true) {
			if (taskQueue.isEmpty()) {
				// idle
				break;
			}

			Task t = taskQueue.remove();
			if (t.isRunnable(runningTime, cooldownPeriod)) {
				t.run(runningTime);

				if (t.isNotFinished()) {
					taskQueue.add(t);
				}
				break;
			} else {
				temp.add(t);
			}
		}

		taskQueue.addAll(temp);
	}

	private Queue<Task> init(char[] tasks, int cooldownPeriod) {
		Map<Character, Task> taskMap = new HashMap<>();
		for (char task : tasks) {
			taskMap.putIfAbsent(task, Task.init(task));
			taskMap.get(task).countUp();
		}

		return new PriorityQueue<>(taskMap.values());
	}

	private static class Task implements Comparable<Task> {
		private char task;
		private int taskCount;
		private int lastUsedTime;

		public static Task init(char task) {
			Task t = new Task();
			t.task = task;
			t.lastUsedTime = -999; // 처음에 바로 사용할 수 있도록 setting
			return t;
		}

		public boolean isNotFinished() {
			return taskCount > 0;
		}

		public void countUp() {
			taskCount++;
		}

		public boolean isRunnable(int currentTime, int n) {
			return currentTime - lastUsedTime > n;
		}

		public void run(int currentTime) {
			taskCount--;
			lastUsedTime = currentTime;
		}

		@Override
		public int compareTo(Task o) {
			// desc
			int taskCountCompare = Integer.compare(o.taskCount, taskCount);
			if (taskCountCompare != 0) {
				return taskCountCompare;
			} else {
				// asc
				return Integer.compare(lastUsedTime, o.lastUsedTime);
			}
		}
	}
}