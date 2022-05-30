class Solution {
    public int maxProfit(int[] prices) {
        int minVal = Integer.MAX_VALUE;
        int res = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i] < minVal)
                minVal = prices[i];
            else if(prices[i] - minVal > res)
                res = prices[i] - minVal;
        }
        return res;
    }
}