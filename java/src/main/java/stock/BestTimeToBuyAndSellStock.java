package stock;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve.
 * You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * <p>
 * Example 2:
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later,
 * as you are engaging multiple transactions at the same time. You must sell before buying again.
 * <p>
 * Example 3:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e., max profit = 0.
 * <p>
 * Constraints:
 * 1 <= prices.length <= 3 * 104
 * 0 <= prices[i] <= 104
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        return calculate(prices, 0);
    }

    private int calculate(int[] prices, int beginIndex) {
        int valley = -1, peak = -1;
        int minimumIndex = beginIndex;
        int maximumIndex = -1;

        for (int i = beginIndex; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                minimumIndex = i;
                valley = prices[minimumIndex];
                break;
            }
        }
        if (valley < 0) {
            minimumIndex = prices.length - 1;
            valley = prices[minimumIndex];
        }
        for (int i = minimumIndex + 1; i < prices.length - 1; i++) {
            if (prices[i] > prices[i + 1]) {
                maximumIndex = i;
                peak = prices[maximumIndex];
                break;
            }
        }
        if (peak < 0) {
            maximumIndex = prices.length - 1;
            peak = prices[maximumIndex];
        }
        int profit = peak - valley;
        if (maximumIndex < 0 || maximumIndex >= prices.length - 1) {
            return profit;
        } else {
            System.out.print("Buy on day " + (minimumIndex + 1));
            System.out.print(", Sell on day " + (maximumIndex + 1));
            System.out.println(", profit= " + peak + "-" + valley + " = " + profit);
            return profit + calculate(prices, maximumIndex);
        }
    }

    public static int maxProfit2(int[] prices) {
        int i = 0;
        int valley, peak;
        int maxProfit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            int minimumIndex = i;
            valley = prices[minimumIndex];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            int maximumIndex = i;
            peak = prices[maximumIndex];
            int profit = peak - valley;
            if (profit > 0) {
                maxProfit += profit;
                System.out.print("Buy on day " + (minimumIndex + 1));
                System.out.print(", Sell on day " + (maximumIndex + 1));
                System.out.println(", profit= " + peak + "-" + valley + " = " + profit);
            }
        }
        return maxProfit;
    }

    public static int maxProfit3(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();
        System.out.println("====");
        System.out.println("Output[2]: " + solution.maxProfit(new int[]{2, 4, 1}));
        System.out.println("====");
        System.out.println("Output[2]: " + maxProfit2(new int[]{2, 4, 1}));
        System.out.println("====");
        System.out.println("Output[2]: " + maxProfit3(new int[]{2, 4, 1}));
        System.out.println("~~~~~");
        System.out.println("Output[7]: " + solution.maxProfit((new int[]{7, 1, 5, 3, 6, 4})));
        System.out.println("====");
        System.out.println("Output[4]: " + solution.maxProfit((new int[]{1, 2, 3, 4, 5})));
        System.out.println("====");
        System.out.println("Output[0]: " + solution.maxProfit((new int[]{7, 6, 4, 3, 1})));
    }
}
