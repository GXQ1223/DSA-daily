// Last updated: 4/17/2025, 9:02:06 PM
class Solution {
    public String countAndSay(int n) {
        if(n == 1)return "1";
        return RLE(n);
    }
    public String RLE(int n){
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        for(int j = 1; j < n; j++){
            StringBuilder res = new StringBuilder();
            // System.out.println(res.toString() + ";");
            for(int i = 0; i < sb.length(); i++){
                Character cur = sb.charAt(i);
                int count = 0;
                while(i < sb.length() && sb.charAt(i) == cur){
                    // System.out.print("j: " + j + "; count: " + count + "; i: " + i + "; char: " + sb.charAt(i));
                    count++; i++;
                    // System.out.println("; j: " + j + "; count: " + count + "; i: " + i );
                }
                if(count >= 1)i--;
                res.append((char)(count + '0')).append(cur);
            }
            // System.out.println("res: " + res.toString() + ";");
            sb.delete(0, sb.length());
            sb.append(res);
            if(j == n-1) return res.toString();
        }
        return "1";
    }
}