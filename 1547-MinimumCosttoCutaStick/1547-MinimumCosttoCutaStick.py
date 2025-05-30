# Last updated: 5/30/2025, 4:19:59 PM
# class Solution:
#     def longestPalindrome(self, word1: str, word2: str) -> int:
#         # make sure there is no repeat
#         n = len(word1)
#         pairs = set()
#         for char in ascii_lowercase:
#             i = word1.find(char)
#             j = word2.rfind(char)
#             if i != -1 and j != -1: pairs.add((i,j + n))

#         if len(pairs) == 0:
#             return 0

#         total_word = word1 + word2
#         @cache
#         def dfs(i, j, word):
#             if i > j: return 0
#             if i == j: return 1
#             if word[i] == word[j]:
#                 return dfs(i+1, j-1, word) + 2
#             return max(dfs(i, j-1, word), dfs(i+1, j, word))

#         res = 0
#         for i, j in pairs:
#             res = max(res, dfs(0, j - i , total_word[i:j + 1]))
#             dfs.cache_clear()
#         return res


class Solution:
    def longestPalindrome(self, word1: str, word2: str) -> int:
        
        @cache
        def fn(lo, hi):
            """Return length of longest palindromic subsequence."""
            if lo >= hi: return int(lo == hi)
            if word[lo] == word[hi]: return 2 + fn(lo+1, hi-1)
            return max(fn(lo+1, hi), fn(lo, hi-1))
        
        ans = 0
        word = word1 + word2
        for x in ascii_lowercase: 
            i = word1.find(x) 
            j = word2.rfind(x)
            if i != -1 and j != -1: ans = max(ans, fn(i, j + len(word1)))
        return ans 