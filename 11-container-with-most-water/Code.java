class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length-1;
        
        while(left < right) {
            // Max water can be the product of distance between the left and right indices with the min of left and right height  
            maxWater = Math.max(maxWater, Math.min(height[left], height[right]) * (right - left));
            
            if(height[left] < height[right])
                left += 1;
            else 
                right -= 1;
        }
        return maxWater;
    }
}
