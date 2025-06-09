# Last updated: 6/9/2025, 3:19:06 PM
class Solution:
    def pyramidTransition(self, bottom: str, allowed: List[str]) -> bool:
        allow = defaultdict(set)
        ok = False
        for u,v,w in allowed:
            allow[u,v].add(w)
        def dfs(s):
            nonlocal ok
            if len(s) == 1: 
                ok = True
                return
            for s1 in build(s, [], 0):
                if ok:
                    return
                dfs(s1)
                
        def build(s, lst, i=0):
            if i == len(s) - 1:
                yield "".join(lst)
            else:
                u,v = s[i], s[i+1]
                for w in allow[u, v]:
                    lst.append(w)
                    for result in build(s, lst, i+1):
                        yield result
                    lst.pop()
        dfs(bottom)
        return ok

        