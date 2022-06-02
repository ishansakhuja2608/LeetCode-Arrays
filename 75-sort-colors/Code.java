class Solution {
    public void sortColors(int[] nums) {
        int curr = 0;
        int left = 0;
        int right = nums.length-1;
        while(curr <= right){
            if(nums[curr] == 0){
                int temp = nums[curr];
                nums[curr] = nums[left];
                nums[left] = temp;
                curr++;
                left++;
            } else if(nums[curr] == 2){
                int temp = nums[curr];
                nums[curr] = nums[right];
                nums[right] = 2;
                right--;
            } else {
                curr += 1;
            }
        }
    }
}
