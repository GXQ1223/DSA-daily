# Last updated: 6/9/2025, 1:49:42 PM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalTraversal(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = defaultdict(list)
        def dfs(i, ord,lvl):
            nonlocal res
            if not i:
                return
            if not res[ord]:
                res[ord] = []
            res[ord].append((lvl, i.val))
            dfs(i.left, ord - 1, lvl + 1)
            dfs(i.right, ord + 1, lvl + 1)
        dfs(root, 0, 0)
        ord = 0
        res2 = []
        ord = -1000
        while not res[ord]:
            ord += 1
        while True:
            if not res[ord]:
                break
            res2.append(sorted(res[ord]))
            ord += 1

        return [[r[1] for r in group] for group in res2]