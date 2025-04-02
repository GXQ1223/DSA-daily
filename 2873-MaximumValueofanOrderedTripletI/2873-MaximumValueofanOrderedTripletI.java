// Last updated: 4/1/2025, 8:04:32 PM
class Solution {
    public long maximumTripletValue(int[] nums) {
        long res = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                for(int k = j+1; k < n; k++){
                    res = Math.max(res, ((long)nums[i] - (long)nums[j]) * (long)nums[k]);
                }
            }
        }
        return res;
    }
}