class Solution {
    public int minimumRecolors(String blocks, int k) {
        int curr = 0;
        for(int i = 0; i < k; i++){
            if(blocks.charAt(i) == 'W') curr++;
        }
        int res = curr;
        for(int i = k; i < blocks.length(); i++){
            if(blocks.charAt(i) == 'W')curr++;
            if(blocks.charAt(i-k) == 'W') curr--;
            res = Math.min(res, curr);
        }
        return res;
    }
}