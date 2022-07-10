class Solution {
    /*
    Each element can be considered as an index, with every iteration make the element at particular index negative, 
    if there's a duplicate then we'll arrive at a particular index twice, check whether the elment if negative, if it is,
    return that.
    */
    public int findDuplicate(int[] nums) {
        int res = -1;
        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0) {
                return index+1;
            }
            nums[index] = -nums[index];
        }
        return -1;
    }
}
