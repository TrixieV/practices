package moderate2;
/*
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,4,7,6,5,6,8};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int totalProfits = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                int buy = prices[i];
                for (int j = i + 1; j < prices.length; j++) {
                    if (j == prices.length - 1 || prices[j] > prices[j + 1]) {
                        totalProfits += (prices[j] - buy);
                        i = j;
                        break;
                    }
                }
            }
        }
        return totalProfits;
    }
}
