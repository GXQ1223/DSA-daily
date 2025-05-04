// Last updated: 5/4/2025, 12:22:42 PM
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[]freq = new int[100];
        int res = 0;
        for(int[]dominoe: dominoes) 
            freq[Math.min(dominoe[0] * 10 + dominoe[1], dominoe[1] * 10 + dominoe[0])]++;
        for(int i: freq) res += i * (i-1) / 2;
        return res;
    }
}
