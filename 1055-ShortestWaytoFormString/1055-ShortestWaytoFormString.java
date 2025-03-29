// Last updated: 3/28/2025, 9:38:03 PM
class Solution {
    public int shortestWay(String source, String target) {
        int res = 0;
        int n = target.length();
        int index = 0;
        while(index < n){
            int temp = index;
            for(int i = 0; i < source.length() && index < n; i++){
                if(source.charAt(i) == target.charAt(index)){
                    index++;
                }
            }
            if(index == temp) return -1;
            res++;
        }
        return res;
    }
}