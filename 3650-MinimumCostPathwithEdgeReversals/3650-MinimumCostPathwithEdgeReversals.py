# Last updated: 1/27/2026, 12:15:03 AM
1class Solution:
2    def minCost(self, n: int, edges: List[List[int]]) -> int:
3        g = [[] for _ in range(n)]
4        for x, y, w in edges:
5            g[x].append((y, w))
6            g[y].append((x, 2 * w))
7
8        dist = [inf] * n
9        visited = [False] * n
10        dist[0] = 0
11        heap = [(0, 0)]  # (Distance, Node)
12
13        while heap:
14            cur_dist, x = heapq.heappop(heap)
15
16            if x == n - 1:
17                return cur_dist
18
19            # already processed
20            if visited[x]:
21                continue
22            visited[x] = True
23
24            # relaxing neighbors
25            for y, w in g[x]:
26                new_dist = cur_dist + w
27                if new_dist < dist[y]:
28                    dist[y] = new_dist
29                    heapq.heappush(heap, (new_dist, y))
30
31        return -1