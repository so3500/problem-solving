package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule/
 *
 * V(vertex, node) : numCourses
 * E(edge, link) : prerequisites
 *
 * related topic: Depth-First Search, Breadth-First Search, Graph, Topological Sort
 * Time Complexity: O(V+E) : init V+E, bfs V+E
 * Space Complexity: O(V+E)
 */
public class LC_207_CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> graph = new ArrayList<>(numCourses);
		int[] inDegree = new int[numCourses];

		// init
		for (int i = 0; i < numCourses; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] prerequisite : prerequisites) {
			int from = prerequisite[0];
			int to = prerequisite[1];
			graph.get(from).add(to);
			inDegree[to]++;
		}

		return bfs(graph, inDegree);
	}

	private boolean bfs(List<List<Integer>> graph, int[] inDegree) {
		Queue<Integer> queue = initQueue(inDegree);

		int count = queue.size(); // inDegree 가 0 개인 course 수
		int numCourses = graph.size();
		while (!queue.isEmpty()) {
			int from = queue.remove();

			for (int to : graph.get(from)) {
				inDegree[to]--;

				if (inDegree[to] == 0) {
					queue.add(to);
					count++;
				}
			}
		}

		// same : cycle 이 없고 count 가 numCourse 만큼 됨
		// diff : cycle 로 인해 inDegree 값이 남아있어 count 가 덜 됨
		return numCourses == count;
	}

	private Queue<Integer> initQueue(int[] inputLink) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < inputLink.length; i++) {
			if (inputLink[i] == 0) {
				queue.add(i);
			}
		}
		return queue;
	}
}