class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int windowSize = n-k;
        int i = 0, j = 0;
        int windowSum = 0;
        int total = 0;
        int minWindowSum = Integer.MAX_VALUE;
        
        while(i < n && j < n){
            windowSum += cardPoints[j]; // adding to the window sum
            total += cardPoints[j]; // total score of all the elements
            
            if(j >= windowSize){
                windowSum -= cardPoints[i++]; // sliding the window, removing the leftmost element
            }
            
            if(j >= windowSize-1) {
                minWindowSum = Math.min(minWindowSum, windowSum);
            }
            j++;
        }
        return total - minWindowSum;
    }
}