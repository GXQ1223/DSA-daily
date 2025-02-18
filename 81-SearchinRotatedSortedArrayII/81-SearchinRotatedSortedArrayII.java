class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        if(nums.length == 1) return target == nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] < nums[i-1]){
                start = i; break;
            }
        }
        System.out.println(start);
        //perform binary search
        int l = start; 
        int r = start + n - 1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid % n] == target) return true;
            if(nums[mid % n] > target) r = mid-1;
            else l = mid+1;
        }
        return false;
    }
}