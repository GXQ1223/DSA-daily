class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int res = 0;
        Set<Integer> nums = new HashSet<>();
        for(int i: arr) nums.add(i);
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                int prev = arr[j];
                int next = arr[i] + arr[j];
                int len = 2;
                while(nums.contains(next)){
                    len++;
                    int temp = prev;
                    prev = next; 
                    next = temp+next;
                    res = Math.max(res, len);
                }
            }
        }
        return res;
    }
}