class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int first = 0;
        int second = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] < 0){
                first = i+1;
            } else break;
        }
        System.out.println(first);

        for(int i = first; i < n; i++){
            if(nums[i] > 0){
                second = n - i + 0;
                break;
            }
        }
        return Math.max(first, second);

    }
}