// Last updated: 4/26/2025, 12:44:07 AM
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int n = nums.length;
        int minPo = -1, maxPo = -1, left = -1;
        for(int i = 0; i < n; i++){
            if(nums[i] < minK || nums[i] > maxK) left = i;
            if(nums[i] == minK) minPo = i;
            if(nums[i] == maxK) maxPo = i;
            res += Math.max(0, Math.min(minPo, maxPo) - left);
        }
        return res;
    }
}