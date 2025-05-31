# Last updated: 5/31/2025, 11:17:04 AM
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
            left = dfs(node.left) + 1
            right = dfs(node.right) + 1
            nonlocal res
            res  = max(res, left+right)
            return max(left, right) 
        dfs(root)
        return res
        
        return dfs(root, res)[1]