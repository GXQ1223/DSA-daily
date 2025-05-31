# Last updated: 5/31/2025, 1:55:55 PM
class Solution:
    def minimumDiameterAfterMerge(self, edges1: List[List[int]], edges2: List[List[int]]) -> int:
        def graph(edges):
            g = [[] for _ in range(len(edges) + 1)]
            for edge in edges:
                g[edge[0]].append(edge[1])
                g[edge[1]].append(edge[0])
            return g
        g1, g2 = graph(edges1), graph(edges2)

        # need to find the starting points first
        def fd(g, start):
            max_depth = 0
            visited = set([start])
            def dfs(x, depth):
                nonlocal start, visited, max_depth
                if depth > max_depth:
                    max_depth = depth
                    start = x
                for y in g[x]:
                    if y in visited:
                        continue
                    visited.add(y)
                    dfs(y, depth + 1)
            dfs(start, 0)
            return start, max_depth    
        #get max diameters for both trees  
        (start1, _), (start2, _) = fd(g1, 0), fd(g2, 0)
        (_, d1), (_, d2) = fd(g1, start1), fd(g2, start2)
        return max((d1 + 1)//2 + (d2 + 1)//2 + 1, max(d1, d2))
        