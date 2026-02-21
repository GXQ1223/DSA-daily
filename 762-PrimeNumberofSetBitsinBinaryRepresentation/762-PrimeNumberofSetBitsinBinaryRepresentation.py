# Last updated: 2/21/2026, 1:27:38 AM
1class Solution(object):
2    def countPrimeSetBits(self, L, R):
3        primes = {2, 3, 5, 7, 11, 13, 17, 19}
4        return sum(bin(x).count('1') in primes
5                   for x in range(L, R+1))