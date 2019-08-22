/*
* 문제: 42587 프린터
* problem-link: https://programmers.co.kr/learn/courses/30/lessons/42587
* solution-link: 
* 
*/

package programmers;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PG_42587 {

	static class Solution {

		class Node {
			int firstLocation;
			int priority;

			public Node(int firstLocation, int priority) {
				this.firstLocation = firstLocation;
				this.priority = priority;
			}
		}

		Queue<Node> taskQueue;
		PriorityQueue<Integer> priorityQueue;

		public int solution(int[] priorities, int location) {
			initQueue(priorities);
			int answer = getPrintOrder(location);
			return answer;
		}

		private void initQueue(int[] priorities) {
			taskQueue = new LinkedList<>();
			priorityQueue = new PriorityQueue<>((p1, p2) -> p2 - p1); // priority 내림차순 정렬
			int location = 0;
			for (int priority : priorities) {
				taskQueue.add(new Node(location, priority));
				priorityQueue.add(priority);
				location++;
			}
		}

		private int getPrintOrder(int location) {
			int printOrder = 1;
			int maxPriority = priorityQueue.remove();
			while (!taskQueue.isEmpty()) {
				Node node = taskQueue.remove();
				if (node.priority == maxPriority) {
					if (node.firstLocation == location) {
						break;
					}
					maxPriority = priorityQueue.remove();
					printOrder++;
				} else if (node.priority < maxPriority) {
					taskQueue.add(node);
				}
			}
			return printOrder;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new int[] { 2, 1, 3, 2 }, 2); // 1
		solution.solution(new int[] { 1, 1, 9, 1, 1, 1 }, 0); // 5
	}

}
