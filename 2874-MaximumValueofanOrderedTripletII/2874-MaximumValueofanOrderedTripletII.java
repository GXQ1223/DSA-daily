// Last updated: 4/3/2025, 12:05:22 AM
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[]pref = new int[n];
        int[]suff = new int[n];

        pref[1] = nums[0];
        for(int i = 2; i < n; i++)
            pref[i] = Math.max(pref[i-1], nums[i-1]);

        suff[n-2] = nums[n-1];
        for(int i = n - 3; i >= 0; i--)
            suff[i] = Math.max(suff[i+1], nums[i+1]);

        long res = 0;
        for(int i = 1; i <= n-2; i++)
            res = Math.max(res, (pref[i] - (long)nums[i]) * suff[i]);
        
        return res;
    }
}