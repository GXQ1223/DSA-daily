class Solution {
    public int longestPalindromicSubsequence(String s, int k) {
        int n = s.length();
        int[][][]dp = new int[n][n][k+1];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                for(int l = 0; l <= k; l++)
                    dp[i][j][l] = -1;
        return getSub(dp, s, 0, n-1, k);
    }

    public int getSub(int[][][]dp, String s, int l, int r, int k){
        if(l > r) return 0;
        if(l == r) return 1;
        if(dp[l][r][k] != -1) return dp[l][r][k];
        int res = 0;
        int d = dist(s.charAt(l), s.charAt(r));
        if(d <= k)
            res = getSub(dp, s, l+1, r-1, k-d) + 2;
        res = Math.max(res, getSub(dp, s, l+1, r, k));
        res = Math.max(res, getSub(dp, s, l, r-1, k));
        dp[l][r][k] = res;
        return res;
    }

    public int dist(char a, char b){
        if(a>b)return dist(b,a);
        return Math.min(b-a, a+26-b);
    }
}