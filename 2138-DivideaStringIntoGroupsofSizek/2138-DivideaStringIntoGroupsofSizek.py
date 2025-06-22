# Last updated: 6/21/2025, 8:54:22 PM
class Solution:
    def divideString(self, s: str, k: int, fill: str) -> List[str]:
        res = []
        for i in range(0, len(s), k):
            res.append(s[i:i+k])
        if len(res[-1]) < k:
            st = list(res[-1])
            print(res[-1])
            print(st)
            for i in range(k - len(st)):
                st.append(fill)
            res[-1] = "".join(st)
        return res
        