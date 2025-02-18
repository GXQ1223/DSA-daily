class Solution {
    String finalS = "";
    public String smallestNumber(String pattern) {
        String s = "";
        boolean[]used = new boolean[10];
        while(finalS.length() < pattern.length()+1){
            for(int i = 1; i < 10; i++){
                s += (char)(i+'0');
                used[i] = true;
                if(pattern.length() == 0) break;
                if(makeSense(s, pattern, used)){
                    pattern = pattern.substring(1,pattern.length());
                    break;
                } else {
                    s = s.substring(0, s.length()-1);
                    used[i] = false;
                }
            }
        }
        
        return finalS;
    }

    public boolean makeSense(String s, String pattern, boolean[] used){
        if(pattern.length() == 0) {
            // System.out.println("final s: " + s); 
            finalS = s; 
            return true;
        }
        if(s.charAt(s.length()-1) == '9' && pattern.charAt(0) == 'I') return false;
        if(s.charAt(s.length()-1) == '0' && pattern.charAt(0) == 'D') return false;
        // System.out.println("s: " + s);
        for(int i = 1; i < 10; i++){
            if(!used[i]){
                if(pattern.charAt(0) == 'I' && s.charAt(s.length()-1) < i + '0'){
                    s += (char)(i+'0');
                    used[i] = true;
                    if(makeSense(s, pattern.substring(1,pattern.length()), used)){
                        return true;
                    }
                    s = s.substring(0, s.length()-1);
                    used[i] = false;
                } else if(pattern.charAt(0) == 'D' && s.charAt(s.length()-1) > i + '0'){
                    s += (char)(i+'0');
                    used[i] = true;
                    if(makeSense(s, pattern.substring(1,pattern.length()), used)){
                        return true;
                    }
                    s = s.substring(0, s.length()-1);
                    used[i] = false;
                }

            }
        }
        return false;
         
    }
}