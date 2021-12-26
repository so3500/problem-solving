package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * related topic: Two Pointers, Design, Sorting, Heap(Priority Queue), Data Stream
 * Time Complexity: O()
 * Space Complexity: O(N)
 */
public class LC_295_FindMedianFromDataStream {
	class MedianFinder {
		/**
		 * 중앙값보다 작거나 같은 수 모음
		 * 큐에서 꺼낸 첫번째 값의 순서는 항상 (n/2) 이다
		 */
		private final Queue<Integer> smallPart;
		/**
		 * even: 중앙값보다 큰 수 모음
		 * odd: 중앙값보다 크거나 같은 수 모음.
		 * 큐에서 꺼낸 첫번째 값의 순서는 항상 (n/2 + 1) 이다
		 */
		private final Queue<Integer> largePart;

		public MedianFinder() {
			smallPart = new PriorityQueue<>(Collections.reverseOrder());
			largePart = new PriorityQueue<>();
		}

		public void addNum(int num) {
			if (hasEvenValues()) {
				largePart.add(num);
				smallPart.add(largePart.remove());
			} else {
				smallPart.add(num);
				largePart.add(smallPart.remove());
			}
		}

		public double findMedian() {
			double median = smallPart.peek();

			if (hasEvenValues()) {
				median += largePart.peek();
				median *= 0.5;
			}

			return median;
		}

		private boolean hasEvenValues() {
			return (smallPart.size() + largePart.size()) % 2 == 0;
		}
	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */