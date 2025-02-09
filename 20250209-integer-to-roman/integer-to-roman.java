class Solution {
    public String intToRoman(int num) {
        String res = "";
        int pl = 0;
        while(num!=0){
            
            int i = num % 10;
            num = num / 10;
            
            if(pl == 0){
                if(i <= 3) for(int j = 0; j < i; j++) res += 'I';
                else if(i == 4) res += "IV";
                else if(i == 5) res += 'V';
                else if(i < 9) {res += 'V'; for(int j = 0; j < i-5; j++) res += 'I';}
                else res += "IX";
            }
            
            if(pl == 1){
                if(i <= 3) for(int j = 0; j < i; j++) res = 'X' + res;
                else if(i == 4) res = "XL" + res;
                else if(i == 5) res = 'L' + res;
                else if(i < 9) { for(int j = 0; j < i-5; j++) res = 'X' + res;res = 'L' + res;}
                else res = "XC" + res;
            }
            
            if(pl == 2){
                if(i <= 3) for(int j = 0; j < i; j++) res = 'C' + res;
                else if(i == 4) res = "CD" + res;
                else if(i == 5) res = 'D' + res;
                else if(i < 9) { for(int j = 0; j < i-5; j++) res = 'C' + res;res = 'D' + res;}
                else res = "CM" + res;
            }
            if(pl == 3){
                for(int j = 0; j < i; j++) res = 'M' + res;
            }
            pl++;
        }
        return res;
    }
}