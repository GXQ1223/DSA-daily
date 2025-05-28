# Last updated: 5/27/2025, 9:04:02 PM
class Solution:
    def maxTargetNodes(self, edges1: List[List[int]], edges2: List[List[int]], k: int) -> List[int]:
        # first build the graph
        tree1 = defaultdict(list)
        tree2 = defaultdict(list)
        for u, v in edges1:
            tree1[u].append(v)
            tree1[v].append(u)
        for u, v in edges2:
            tree2[u].append(v)
            tree2[v].append(u)

        # using bfs to find number of nodes within k range of node i
        def findNodes(node, tree, k):
            numbers = 1
            frontier = deque([node])
            visited = {node}
            for _ in range(k):
                currentsize = len(frontier)
                for i in range(currentsize):
                    cur = frontier.popleft()
                    for child in tree[cur]:
                        if child not in visited:
                            frontier.append(child)
                            numbers += 1

                            visited.add(child) # sets need to use add()
            return numbers if k >= 0 else 0
        # print(tree1)
        # print(tree2)
        # print(findNodes(0, tree1, k))
        tree1_k_range = []
        tree2_k_range = []
        for i in range(len(tree1)):
            tree1_k_range.append(findNodes(i, tree1, k))
        for i in range(len(tree2)):
            tree2_k_range.append(findNodes(i, tree2, k - 1))
        tree2_max_node = max(tree2_k_range)
        # print(tree1_k_range)
        # print(sorted(tree2_k_range)[-1])
        tree2 = sorted(tree2_k_range)[-1]
        ans = []
        for i in tree1_k_range:
            ans.append(i + tree2)
        return ans