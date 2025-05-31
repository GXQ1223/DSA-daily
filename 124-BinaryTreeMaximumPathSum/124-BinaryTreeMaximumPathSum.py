# Last updated: 5/31/2025, 12:59:27 PM
class TreeNode:
    def __init__(self, val = None, children = None):
        self.val = val
        self.children = set() if children is None else children
class Solution:
    def longestPath(self, parent: List[int], s: str) -> int:
        n = len(parent)
        tree = {}                  
        tree[0] = TreeNode(s[0])
        root = tree[0]
        for i in range(1, n):
            node = TreeNode(s[i])
            tree[i] = node
        for i in range(1, n):
            par = tree[parent[i]]
            par.children.add(tree[i])

        res = 1

        @cache
        def dfs(node):
            if node is None:
                return -1
            val = []
            if len(node.children) == 0: return 1
            # print(node.children)
            for child in node.children:
                if not child or child.val == node.val: 
                    dfs(child)
                    continue
                val.append(dfs(child))

            #no valid children, return 0
            nonlocal res
            if not val:
                res = max(res, 1)
                return 1
            val.sort()

            #see if the biggest two numbers gets you result
            biggest = val[-1]
            secondbiggest = 0 if len(val) < 2 else val[-2]
            res = max(res, biggest + secondbiggest + 1)
            return biggest + 1
            


        dfs(root)
        return res

        