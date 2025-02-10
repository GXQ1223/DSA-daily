class Solution {
    public String clearDigits(String s) {
        char[]chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] - '0' >= 0 && chars[i] - '9' <= 0){
                //isdigit
                chars[i] = ' ';
                for(int j = i-1; j >= 0; j--){
                    if(chars[j] - 'a' >= 0 && chars[j] - 'z' <= 0){
                        //is char
                        chars[j] = ' ';
                        break;
                    }
                }
            }
        }
        s = "";
        for(char c: chars){
            if (c != ' ') s += c;
        }
        return s;
    }
}