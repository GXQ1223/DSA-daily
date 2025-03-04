class Solution {
    public boolean checkPowersOfThree(int n) {
        int[]nums = new int[17];
        nums[0] = 1;
        for(int i = 1; i < 17; i++){
            nums[i] = 3 * nums[i-1]; 
            System.out.print(";" + nums[i]);
        }
        for(int i = 16; i >= 0; i--){
            if(nums[i] <= n){
                n -= nums[i];
            }
            System.out.println("n: " + n);
        }
        return n == 0;
    }
}