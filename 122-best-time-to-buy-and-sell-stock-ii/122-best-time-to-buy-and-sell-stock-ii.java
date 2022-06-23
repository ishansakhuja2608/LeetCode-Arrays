class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        // If array is null, the net profit is 0
        if(prices == null || prices.length == 0)
            return 0;
        
        for(int i = 0; i < prices.length - 1; i++) {
            // If the prices on a particular day is more than the prices on the previous day, then we add the profit to the result
            if(prices[i] < prices[i+1])
                maxProfit += prices[i+1] - prices[i]; 
        }
        return maxProfit;
    }
}
