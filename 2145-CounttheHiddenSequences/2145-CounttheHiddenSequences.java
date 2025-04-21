// Last updated: 4/20/2025, 9:15:02 PM
class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long low = 0, hi = 0;
        long cur = 0;
        for(int i: differences){
            cur += i;
            low = Math.min(low, cur);
            hi = Math.max(hi, cur);
        }
            // System.out.println("low: " + low + "; hi: " + hi);
        return (upper - lower) - (hi - low) + 1 > 0 ? (int)((upper - lower) - (hi - low) + 1) : 0 ;

    }
}