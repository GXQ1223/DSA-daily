# Last updated: 8/9/2025, 8:15:05 PM
class Solution:
    def reorderedPowerOf2(self, n: int) -> bool:
        lst = list(str(n))
        # print(lst)
        n = len(lst)
        def can(lst):
            x = int("".join(lst))
            return x > 0 and x-1 & x == 0
        def dfs(path, i, s):
            # print("path: ", path, i, s)
            if i == n:
                return can(path)
            for j, ele in enumerate(s.copy()):
                if ele == '0' and i == 0:
                    continue
                path.append(ele)
                s.pop(j)
                if dfs(path, i+1, s):
                    return True
                path.pop()
                s.insert(j, ele)
            return False
        return dfs([], 0, lst)


        