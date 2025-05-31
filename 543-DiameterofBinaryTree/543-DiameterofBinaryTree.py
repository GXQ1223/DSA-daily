# Last updated: 5/31/2025, 11:12:54 AM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        res = 0
        def dfs(node):
            if node == None: return -1
            left = dfs(node.left)
            right = dfs(node.right)
            nonlocal res
            res  = max(res, left+right+2)
            return max(left, right) + 1
        dfs(root)
        return res
        
        return dfs(root, res)[1]