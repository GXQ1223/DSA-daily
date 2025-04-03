// Last updated: 4/3/2025, 12:04:31 AM
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long[]pref = new long[n];
        long[]suff = new long[n];

        pref[1] = (long)nums[0];
        for(int i = 2; i < n; i++)
            pref[i] = Math.max(pref[i-1], (long)nums[i-1]);

// for(int i = 0; i < n; i++)System.out.print(pref[i] + "; ");

        suff[n-2] = (long)nums[n-1];
        for(int i = n - 3; i >= 0; i--)
            suff[i] = Math.max(suff[i+1], (long)nums[i+1]);
// System.out.println();
// System.out.println("suff: ");
// for(int i = 0; i < n; i++)System.out.print(suff[i] + "; ");

        long res = 0;
        for(int i = 1; i <= n-2; i++)
            res = Math.max(res, (pref[i] - (long)nums[i]) * suff[i]);
        
        return res;
    }
}