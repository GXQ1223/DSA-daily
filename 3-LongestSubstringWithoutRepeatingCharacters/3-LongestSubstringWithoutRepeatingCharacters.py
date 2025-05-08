# Last updated: 5/8/2025, 4:00:36 PM
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        ans = 0
        cnt = Counter() #hashmap char int
        l = 0
        for r in range(0, len(s)):
            cnt[s[r]] += 1
            while cnt[s[r]] > 1:
                cnt[s[l]] -= 1
                l += 1
            ans = max(ans, r - l + 1)

        return ans
        