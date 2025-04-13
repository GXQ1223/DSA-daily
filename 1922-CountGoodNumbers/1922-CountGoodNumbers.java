// Last updated: 4/12/2025, 11:53:18 PM
class Solution {
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = (n/2);
        
        return (int)((exp(5,even)*exp(4,odd))%(1000000007));
    }
    public long exp(long base, long p)
    {
     int mod = 1000000007;
     long result = 1;
     while(p>0)
     {
        if((p&1)==1)
            result = (result*base)%mod;
        p>>= 1;
        base = (base*base)%mod;
     }
    return result;
    }
}