// Last updated: 4/22/2025, 9:28:26 PM
class Solution {
    public int countLargestGroup(int n) {
        int max = 0;
        int[]sums = new int[37];
        for(int i = 1; i < n+1; i++){
            int cur = i;
            int s = 0; 
            while(cur > 0){
                s += cur % 10;
                cur /= 10;
            }
            sums[s]++;
            max = Math.max(sums[s], max);
        }
        int res = 0;
        for(int x: sums){
            if(x == max)res++;
        }
        return res;
    }
}