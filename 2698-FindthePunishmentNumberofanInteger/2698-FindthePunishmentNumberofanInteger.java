class Solution {
    public int punishmentNumber(int n) {
        boolean[]nums = new boolean[1001];
        int res = 0;
        for(int i = 1; i <= n; i++) 
            if(isPunishmentNumber(i, i * i))
                res += (i * i);
            
        return res;
    }

    private boolean isPunishmentNumber(int target, int string){

        // do backtracking
        if(target == string)
            return true;

        //case2, when target smaller than 0
        if(target < 0) return false;

        int lastNum = string % 10;
        int pl = 10;
        while(string > 0 && lastNum < target){
            // System.out.println("String: " + string + "; lastNum: " + lastNum + ";target:" + target);
            if(isPunishmentNumber(target - lastNum, string / 10)) return true;
            
            string /= 10;
            lastNum += (string % 10) * pl;
            pl *= 10;
        }
        return false;
    }
}