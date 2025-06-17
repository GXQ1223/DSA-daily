# Last updated: 6/17/2025, 5:01:46 PM
class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        res = []
        n = len(s)
        def dfs(i, path):
            nonlocal res
            if i == n:
                res.append("".join(path))
                return
            if s[i] in "0123456789":
                path.append(s[i])
                dfs(i+1, path)
                path.pop()
            else:
                ch = s[i]
                if ch not in "abcdefghijklmnopqrstuvwxyz":
                    ch = chr(ord(ch) - ord('A') + ord('a'))
                path.append(ch)
                dfs(i+1, path)
                path.pop()
                path.append(chr(ord(ch) + ord('A') - ord('a')))
                dfs(i+1, path)
                path.pop()
                
        dfs(0, [])
        return res