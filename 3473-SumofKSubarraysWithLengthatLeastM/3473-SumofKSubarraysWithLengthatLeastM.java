class Solution {
    public int maxSum(int[] a, int k, int m) {
        int n = a.length, NEG = Integer.MIN_VALUE / 2;
        int[]pre = new int[n+1];
        for(int i = 1; i <= n; i++) pre[i] = pre[i-1] + a[i-1];
        int[][]dp = new int[n+1][k+1];
        for(int i = 0; i <= n; i++) dp[i][0] = 0;
        for(int r = 1; r <= k; r++) dp[0][r] = NEG;
        for(int r = 1; r <= k; r++){
            int maxDiff = NEG;
            for(int i = 1; i <= n; i++){
                dp[i][r] = dp[i-1][r];
                if(i >= m){
                    maxDiff = Math.max(maxDiff, dp[i-m][r-1] - pre[i-m]);
                    dp[i][r] = Math.max(dp[i][r], pre[i] + maxDiff);
                }
            }
        }
        return dp[n][k];
    }
}