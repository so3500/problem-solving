/*
* 문제: 43105 정수 삼각형
* problem-link: https://programmers.co.kr/learn/courses/30/lessons/43105
* solution-link: 
*/

package programmers;

public class PG_43105 {

	static class Solution {

		int height;
		int[][] maxSum;

		public int solution(int[][] triangle) {
			int answer = 0;
			initMaxSum(triangle);
			for (int h = 1; h < height; h++) {
				int width = h + 1;
				maxSum[h][0] = triangle[h][0] + maxSum[h - 1][0];
				maxSum[h][width - 1] = triangle[h][width - 1] + maxSum[h - 1][width - 2];
				for (int w = 1; w < width; w++) {
					int leftUp = w - 1;
					int rightUp = w;
					maxSum[h][w] = triangle[h][w] + Integer.max(maxSum[h - 1][leftUp], maxSum[h - 1][rightUp]);
					answer = Integer.max(answer, maxSum[h][w]);
				}
			}
			answer = Integer.max(answer, maxSum[height - 1][0]);
			answer = Integer.max(answer, maxSum[height - 1][height - 1]);
			return answer;
		}

		private void initMaxSum(int[][] triangle) {
			this.height = triangle.length;
			maxSum = new int[height][height];
			maxSum[0][0] = triangle[0][0];
		}
	}

	public static void main(String[] args) {
		// [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]] => 30
		int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		Solution solution = new Solution();
		System.out.println(solution.solution(triangle));
	}

}
