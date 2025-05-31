# Last updated: 5/31/2025, 11:34:26 AM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        res = -1001

        def dfs(node):
            if node is None: return -1001
            nonlocal res
            left = dfs(node.left)
            right = dfs(node.right)
            res = max(left, res)
            res = max(right, res)
            res = max(left + node.val, res)
            res = max(right + node.val, res)
            res = max(left + right + node.val, res)
            res = max(node.val, res)
            ans = max(max(left, right), 0) + node.val
            # print("ans: " , ans)
            return ans
        dfs(root)
        return res