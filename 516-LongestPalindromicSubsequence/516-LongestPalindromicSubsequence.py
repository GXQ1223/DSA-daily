# Last updated: 5/30/2025, 2:37:33 PM
class Solution:
    def mergeStones(self, stones: List[int], k: int) -> int:
        n = len(stones)
        if (n-1) % (k-1) != 0: return -1
        pref = [0] * (n+1)
        pref[0] = stones[0]
        for i in range(n):
            pref[i+1] = pref[i] + stones[i]
        print("pref: " , pref)
        
        @cache
        def dfs(i,j):
            if j - i + 1 < k: return 0
            res = min(dfs(i, mid) + dfs(mid+1, j) for mid in range(i, j, k-1))
            if (j-i) % (k-1) == 0:
                res += pref[j+1] - pref[i]
            return res
        return dfs(0, n-1)
        