// Last updated: 4/10/2025, 10:55:05 PM
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
        for(int i = Math.max(low, 10); i < Math.min(high + 1, 100); i++){
            if(sym1(i))res++;
        }
        for(int i = Math.max(low, 1000); i < Math.min(high + 1, 100000); i++){
            if(sym2(i))res++;
        }
        return res;
    }
    public boolean sym1(int i){
        return i/10 == i % 10;
    }
    public boolean sym2(int i){
        int sum1 = i%10;
        i/=10; sum1 += i%10;
        i/=10;
        int sum2 = i%10;
        i/=10; sum2 += i;
        return sum1 == sum2;
    }
}