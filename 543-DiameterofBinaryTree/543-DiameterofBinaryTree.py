# Last updated: 5/31/2025, 11:39:06 AM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        res = -1001

        @cache
        def dfs(node):
            if node is None: return 0
            nonlocal res
            left = max(0,dfs(node.left))
            right = max(0,dfs(node.right))
            res = max(left + right + node.val, res)
            ans = max(max(left, right), 0) + node.val
            # print("ans: " , ans)
            return ans
        dfs(root)
        return res