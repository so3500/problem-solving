package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * related topic: Depth-First Search, Breadth-First Search, Graph, Topological Sort
 *
 * V(vertex, node) : numCourses
 * E(edge, link) : prerequisites
 *
 * Time Complexity: O(V+E)
 * Space Complexity: O(V+E)
 */
public class LC_210_CourseSchedule2 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		int[] indegree = new int[numCourses];
		int[] topologicalOrder = new int[numCourses];

		initAdjanceyList(prerequisites, adjList, indegree);
		Queue<Integer> queue = initQueueWithZeroDegree(numCourses, indegree);
		int i = processQueue(adjList, indegree, topologicalOrder, queue);

		if (i != numCourses) {
			return new int[0];
		}

		return topologicalOrder;
	}

	private void initAdjanceyList(int[][] prerequisites, Map<Integer, List<Integer>> adjList, int[] indegree) {
		for (int[] prerequisite : prerequisites) {
			int to = prerequisite[0];
			int from = prerequisite[1];
			adjList.putIfAbsent(from, new ArrayList<>());
			adjList.get(from).add(to);

			indegree[to] += 1;
		}
	}

	private Queue<Integer> initQueueWithZeroDegree(int numCourses, int[] indegree) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}
		return queue;
	}

	private int processQueue(Map<Integer, List<Integer>> adjList, int[] indegree, int[] topologicalOrder, Queue<Integer> q) {
		int i = 0;

		while (!q.isEmpty()) {
			int node = q.remove();
			topologicalOrder[i++] = node;

			if (adjList.containsKey(node)) {
				for (Integer neighbor : adjList.get(node)) {
					indegree[neighbor]--;

					if (indegree[neighbor] == 0) {
						q.add(neighbor);
					}
				}
			}
		}

		return i;
	}
}