class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        // int res = 0;
        // Set<Integer> nums = new HashSet<>();
        // for(int i: arr) nums.add(i);
        // for(int i = 0; i < arr.length; i++){
        //     for(int j = i+1; j < arr.length; j++){
        //         int prev = arr[j];
        //         int next = arr[i] + arr[j];
        //         int len = 2;
        //         while(nums.contains(next)){
        //             len++;
        //             int temp = prev;
        //             prev = next; 
        //             next = temp+next;
        //             res = Math.max(res, len);
        //         }
        //     }
        // }
        // return res;

        int res = 0, n = arr.length;
        int[][]dp = new int[n][n];
        //map each value to its index for O(1) loopup
        Map<Integer, Integer>idx = new HashMap<>();

        //fill dp array
        for(int i = 0; i < n; i++){
            idx.put(arr[i], i);
            for(int j = 0; j < i; j++){
                int d = arr[i] - arr[j];
                int p = idx.getOrDefault(d, -1);
                if(d < arr[j] && p >= 0){
                    dp[j][i] = dp[p][j] + 1;
                } else {
                    dp[j][i] = 2;
                }
                res = Math.max(res, dp[j][i]);
            }
        }
        return res > 2 ? res: 0;
    }
}