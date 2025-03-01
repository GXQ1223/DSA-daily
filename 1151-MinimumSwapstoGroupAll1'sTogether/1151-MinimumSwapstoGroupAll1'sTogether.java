class Solution {
    public int minSwaps(int[] data) {
        int cnt1 = 0;
        for(int i:data)
            if(i == 1)cnt1++;
        int cnt0 = 0;
        int res = data.length;
        for(int i = 0; i < cnt1; i++)
            if(data[i] == 0) cnt0++;
        res = Math.min(res, cnt0);
        // System.out.println("cnt1: " + cnt1 + ";cnt0: " + cnt0);

        for(int i = 1; i <= data.length - cnt1; i++){
            if(data[i-1] == 0) cnt0--;
            if(data[i+cnt1-1] == 0) cnt0++;
            res = Math.min(res, cnt0);
        }
        return res;
    }
}