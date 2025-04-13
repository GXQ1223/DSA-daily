// Last updated: 4/12/2025, 11:51:54 PM
class Solution {
    public int countGoodNumbers(long n) {
        int MOD = 1000000007;
        long res = 1; //when n is 1, place 0 can only be 2,4,6,8

        if(n % 2 == 1) res *= 5;
        while(n > 1){
            long s = 1;
            int exp = 0;
            while(s * 2 <= n){
                s *= 2; exp++;
            }
            // System.out.println("exp: " + exp);
            long r = 20;
            int i = 1;
            for(i = 1; i < exp; i++){
                r *= r; r %= MOD;
            }
            if(i >= 1) {res *= r; res %= MOD;}


            // System.out.println("s: " + s + ";exp: " + exp + ";r: " + r + ";res: " + res);

            n -= s;
        }
        return (int)res;
    }
}