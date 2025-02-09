class Solution {
    public int myAtoi(String s) {
        
        if(s == "")return 0;
        
        //leading 0
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' ') {
                start = i;
                break;
            }
        }
            
        s = s.substring(start, s.length());
        if(s.length() == 0)return 0;
        
        int neg = 1;
        if(s.charAt(0) == '-'){
            neg = -1;s = s.substring(1, s.length());
        } else if (s.charAt(0) == '+'){
            s = s.substring(1, s.length());
        }
        
        
        if(s == "")return 0;
        // System.out.println("s: " + s);
        
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) - '0' < 0 || s.charAt(i) - '0' > 9) break;
            
            
            // System.out.println("res: " + res);
            if(-(double)res <= (double)(Integer.MIN_VALUE + (s.charAt(i) - '0'))/10) return neg > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            
            res = res * 10 + s.charAt(i) - '0';
            
            // System.out.println("res: " + res);
            // System.out.println();
        }
        
        return res * neg;
    }
}