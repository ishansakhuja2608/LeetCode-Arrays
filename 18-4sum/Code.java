class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
            
        if(nums == null || nums.length == 0)
                return res;
            
        int n = nums.length;
        Arrays.sort(nums);
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n ; j++) {
                int target2 = target - nums[j] - nums[i];
                
                int left = j + 1;
                int right = n - 1;
                
                while(left < right) {
                    int twoSum = nums[left] + nums[right];
                    if(twoSum < target2)
                        left++;
                    else if(twoSum > target2)
                        right--;
                    else {
                        List<Integer> set = new ArrayList<>();
                        set.add(nums[i]);
                        set.add(nums[j]);
                        set.add(nums[left]);
                        set.add(nums[right]);
                        
                        res.add(set);
                        // dealing with duplicates on left
                        while(left < right && nums[left] == set.get(2)) ++left;
                        // dealing with duplicates on right
                        while(left < right && nums[right] == set.get(3)) --right;
                    }
                }
                while(j + 1 < n && nums[j+1] == nums[j]) ++j; // duplicates of j
            }
            while(i + 1 < n && nums[i+1] == nums[i]) ++i; // duplicates of i
        }
        
        return res;
    }
}
