class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 300001;
        for(int i = 0; i <= nums.length - 3; i++){
            int left = i+1;
            int right = nums.length - 1;
            while(right > left){
                int cur = nums[left] + nums[right] + nums[i];
                if(Math.abs(cur - target) < Math.abs(res - target)) res = cur;
                if(cur < target) left++;
                else right--;
            }
        }
        return res;
    }
}