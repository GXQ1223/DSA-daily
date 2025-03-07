class Solution {
    public int[] closestPrimes(int left, int right) {
        int[]res = new int[]{-1, -1};
        boolean [] composite = new boolean[right + 1];
        composite[1] = true;
        // use Sieve of Eratosthenes
        for(int i = 2; i <= right; i++)
            if(!composite[i] && isPrime(i)) // it needs to be prime
                for(int j = 2; j * i <= right; j++)
                    composite[j * i] = true;

        int dif = Integer.MAX_VALUE;
        int prev = 0;
        for(int i = left; i <= right; i++)
            if(!composite[i]) {prev = i; break;}
        if(prev == 0) return res;

        for(int i = prev + 1; i <= right; i++)
            if(!composite[i]){
                dif = Math.min(dif, i - prev);
                res[0] = prev; res[1] = i;
                if(dif <= 2) return res;
                prev = i;
            } 
        return res;
    }

    public boolean isPrime(int n){
        for(int i = 2; i < i; i++)
            if(n % i == 0) return false;
        return true;
    }
}