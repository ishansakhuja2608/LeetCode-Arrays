class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // a+b+c = 0; b+c = -a
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList();
        
        for(int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int left = i + 1;
                int right = nums.length-1;
                int sum = -nums[i];
                
                while(left < right) {
                    if(nums[left] + nums[right] == sum) {
                        // Adding that triplet to triplets
                        triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        
                        while(left < right && nums[left] == nums[left+1])
                            left++; // skipping the same elements on the left ride
                        
                        while(left < right && nums[right] == nums[right-1])
                            right--; // skipping the same elements on the right side
                        
                        left++;
                        right--;
                        
                    }
                    else if(nums[left] + nums[right] < sum)
                        left++;
                    else
                        right--;
                }
            }
        }
        return triplets;
    }
}
