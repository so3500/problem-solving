package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * related topic:
 * Time Complexity: O(NlogN)
 * Space Complexity: O(N)
 */
public class LC_1834_SingleThreadedCPU {
	public int[] getOrder(int[][] tasks) {
		int[] order = new int[tasks.length];
		int[][] sortedTasks = getSortedTasks(tasks);

		PriorityQueue<int[]> nextTask = new PriorityQueue<>((a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);
		int time = 0;
		int answerIndex = 0;
		int taskIndex = 0;

		while (answerIndex < tasks.length) {
			while (taskIndex < tasks.length && sortedTasks[taskIndex][1] <= time) {
				nextTask.offer(sortedTasks[taskIndex++]);

			}
			if (nextTask.isEmpty()) {
				time = sortedTasks[taskIndex][1];
				continue;
			}
			int[] bestFit = nextTask.poll();
			order[answerIndex++] = bestFit[0];
			time += bestFit[2];
		}

		return order;
	}

	private int[][] getSortedTasks(int[][] tasks) {
		int[][] sortedTasks = new int[tasks.length][3];
		for (int i = 0; i < tasks.length; i++) {
			sortedTasks[i][0] = i;
			sortedTasks[i][1] = tasks[i][0];
			sortedTasks[i][2] = tasks[i][1];
		}
		Arrays.sort(sortedTasks, Comparator.comparingInt(a -> a[1]));
		return sortedTasks;
	}
}