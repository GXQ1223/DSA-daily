class Solution {
    public int romanToInt(String s) {
        int res = 0;
        boolean V = false;
        boolean L = false;
        boolean D = false;
        boolean X = false;
        boolean C = false;
        boolean M = false;
        for(int i = s.length()-1; i >= 0; i--){
            Character c = s.charAt(i);
            if(c == 'V'){V = true; res += 5;}
            if(c == 'L'){L = true; res += 50;}
            if(c == 'D'){D = true; res += 500;}
            if(c == 'I'){
                if(V || X) res--;
                else res++;
            }
            if(c == 'X'){
                X = true;
                if(L || C) res-=10;
                else res+=10;
            }
            if(c == 'C'){
                C = true;
                if(D || M) res-=100;
                else res+=100;
            }
            if(c == 'M'){
                M = true;
                res+=1000;
            }
        }
        
        return res;
    }
}