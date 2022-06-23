class Solution {
    public int maxProfit(int[] prices) {
        
        int buy = Integer.MAX_VALUE; // we have to buy the stock on the day when its value is minimum
        int maxProfit = 0; // have to sell the stock on such a day that the profit earned could be maimum
        
        for(int i = 0; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]); // minimum of array
            maxProfit = Math.max(maxProfit, prices[i] - buy); // difference of that minimum with all the elements
        }
        return maxProfit;
    }
}
