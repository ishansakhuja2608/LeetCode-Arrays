class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length; // length of the array
        int windowSize = n - k; // the size of the sliding window
        int windowSum = 0;
        int minWindowSum = Integer.MAX_VALUE;
        int total = 0;
        int i = 0, j = 0;
        
        while(i < n && j < n) {
            total += cardPoints[j];
            windowSum += cardPoints[j];
            
            if(j >= windowSize) {
                windowSum -= cardPoints[i++]; // keeping the window size same
            }
            
            if(j >= windowSize - 1) {
                minWindowSum = Math.min(minWindowSum, windowSum); // storing the minimum window sum
            }
            j++;
        }
        return total - minWindowSum;
    }
}
