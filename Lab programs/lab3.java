
public class MaximumProfitAnalyzer {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        int minPrice = prices[0];
        int maxProfit = 0;
        int buyPrice = 0;
        int sellPrice = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
                buyPrice = minPrice;
                sellPrice = prices[i];
            }

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        System.out.println("Maximum Profit: " + maxProfit);

        if (maxProfit > 0) {
            System.out.println("Buy Price: " + buyPrice);
            System.out.println("Sell Price: " + sellPrice);
        } else {
            System.out.println("No profitable transaction.");
        }
    }
}
Maximum Profit: 5
Buy Price: 1
Sell Price: 6
