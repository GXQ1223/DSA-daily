# Last updated: 5/26/2025, 1:44:31 AM
class Solution:
    def largestPathValue(self, colors: str, edges: List[List[int]]) -> int:
        n = len(colors)
        map = defaultdict(list)
        indegree = [0] * n
        visited = {}
        for u,v in edges:
            map[u].append(v)
            indegree[v] += 1
        # print(map)
        # print(indegree)

        # use topological sort to search from the sources
        color_count = [[0] * 26 for i in range(n)]
        queue = deque(i for i in range(n) if indegree[i] == 0)
        processed_node = 0
        res = 0
        while queue:
            node = queue.popleft()
            processed_node += 1
            color_index = ord(colors[node]) - ord('a')
            color_count[node][color_index] += 1
            res = max(res, color_count[node][color_index])
            for child in map[node]:
                for c in range(26):
                    color_count[child][c] = max(color_count[child][c], color_count[node][c])
                indegree[child] -= 1
                if indegree[child] == 0:
                    queue.append(child)


        return res if processed_node == n else -1