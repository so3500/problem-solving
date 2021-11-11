package leetcode;

/**
 * related topic: Array
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class LC_121_BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
		int minPrice = prices[0];
		int maxProfit = 0;

		for (int price : prices) {
			if (price < minPrice) {
				minPrice = price;
			} else {
				maxProfit = Integer.max(maxProfit, price - minPrice);
			}
		}

		return maxProfit;
	}
}