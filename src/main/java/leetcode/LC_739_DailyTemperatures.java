package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/daily-temperatures/
 *
 * Related Topics: Array, Stack, Monotonic Stack
 */
public class LC_739_DailyTemperatures {

	public int[] dailyTemperatures(int[] temperatures) {
		int[] ret = new int[temperatures.length];
		Deque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < temperatures.length; i++) {
			/*
			index i를 stack 에 넣기 전 temperatures[i] 보다 작은 수를 모두 제거한다 (+제거된 수들의 ret 값 채운다.)
			stack 의 top 에 가까운 element 를 upIndex, bottom 에 가까운 element 를 downIndex 라고 할 때 temperatures[upIndex] > temperatures[downIndex] 를 보장한다.
			 */
			while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
				int coolTemperatureIndex = stack.pop();
				ret[coolTemperatureIndex] = i - coolTemperatureIndex;
			}
			stack.push(i);
		}
		return ret;
	}

}