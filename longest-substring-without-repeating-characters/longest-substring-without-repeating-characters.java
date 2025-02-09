class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        
        int j = 0;
        int res = 0;
        Map<Character, Integer> freq = new HashMap<>();
        boolean repeat = false;
        for(int i = 0; i < s.length(); i++){
            
            while(j < s.length() && !repeat){
                System.out.println("increased j: " + s.charAt(j));
                freq.putIfAbsent(s.charAt(j), 0);
                freq.put(s.charAt(j), freq.get(s.charAt(j)) + 1);
                if(freq.get(s.charAt(j)) > 1)
                    repeat = true;
                j++;
            }
            if(repeat) res = Math.max(j-i-1, res);
            else res = Math.max(j-i, res);
            
            freq.put(s.charAt(i), freq.get(s.charAt(i)) - 1);
            System.out.println("decreased i: " + s.charAt(i));
            if (freq.get(s.charAt(i)) == 1) {
                repeat = false;
                res = Math.max(res, j-i-1);
            }
            
        }
        
        System.out.println();
        return res;
    }
}