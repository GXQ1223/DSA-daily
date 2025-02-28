class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(String num: nums){
            if(num.charAt(i) == '0') sb.append('1');
            else sb.append('0');
            i++;
        }
        return sb.toString();
    }
}