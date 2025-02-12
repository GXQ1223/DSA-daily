class Solution {
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isPalin(chars, i, j)) res++;
                else break;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isPalin2(chars, i, j)) res++;
                else break;
            }
        }
        return res;
    }

    public boolean isPalin(char[]chars, int i, int j){
        int n = chars.length;
        if(j == 0) return true;
        if(i - j < 0 || i + j >= n) return false;
        if(chars[i+j] == chars[i-j]) return true;
        return false;
    }

    public boolean isPalin2(char[]chars, int i, int j){
        int n = chars.length;
        if(i + 1 >= n) return false;
        if(j == 0)
            if (chars[i] == chars[i+1]) return true;
            else return false;
        if(i - j < 0 || i + 1 + j >= n) return false;
        if(chars[i + 1 + j] == chars[i - j]) return true;
        return false;
    }
}