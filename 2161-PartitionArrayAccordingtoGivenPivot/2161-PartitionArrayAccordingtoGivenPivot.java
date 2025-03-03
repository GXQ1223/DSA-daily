class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[]res = new int[nums.length];
        int l = 0, r = nums.length-1;
        Arrays.fill(res, pivot);
        for(int i: nums)
            if(i < pivot){
                res[l] = i;
                l++;
            }
        for(int i = nums.length-1; i >= 0; i--)
            if(nums[i] > pivot){
                res[r] = nums[i];
                r--;
            }
        return res;
    }
}