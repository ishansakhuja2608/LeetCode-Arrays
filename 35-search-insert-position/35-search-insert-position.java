class Solution {
    public int searchInsert(int[] nums, int target) {
        int r=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<target)
                r++;
        }
        return r;
    }
}