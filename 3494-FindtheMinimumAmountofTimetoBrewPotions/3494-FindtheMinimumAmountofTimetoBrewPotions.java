// Last updated: 3/24/2025, 10:48:55 AM
// class Solution {
//     public long minTime(int[] skill, int[] mana) {
//         int n = skill.length;
//         int m = mana.length;
        
//         long[][] dp = new long[m][n + 1];
        
//         // Fill first day
//         for (int i = 1; i <= n; i++) {
//             dp[0][i] = dp[0][i-1] + (long)skill[i-1] * mana[0];
//         }
        
//         for (int i = 1; i < m; i++) {
//             dp[i][0] = 0;
//             for (int j = 1; j <= n; j++) {
//                 // Option 1: Don't train person j on day i
//                 dp[i][j] = dp[i][j-1] + (long)skill[j-1] * mana[i];
                
//                 // Option 2: Find optimal number of people to skip on day i
//                 for (int k = 0; k < j; k++) {
//                     dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + dp[i][j] - dp[i][k]);
//                 }
//             }
//         }
        
//         return dp[m-1][n];
//     }
// }

class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        long[] f = new long[n];
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++)
            pre[i + 1] = pre[i] + skill[i];
        long tot = pre[n];
        for (int j = 0; j < m; j++) {
            long cur = mana[j];
            long t0 = f[0];
            for (int i = 1; i < n; i++)
                t0 = Math.max(t0, f[i] - pre[i] * cur);
            for (int i = 0; i < n; i++)
                f[i] = t0 + pre[i + 1] * cur;
        }
        return f[n - 1];
    }
}