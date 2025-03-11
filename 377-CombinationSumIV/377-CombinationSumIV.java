class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[]dp = new int[target + 1];
        dp[0] = 1;

        for(int combSum = 1; combSum < target+1; combSum++){
            for(int num: nums){
                if(combSum - num >= 0)
                    dp[combSum ]+= dp[combSum - num];
                else
                    break;
            }
        }
        return dp[target];
    }
}

