# Last updated: 5/30/2025, 4:47:07 PM
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
            res = max(res, left+right+2)
            return max(left, right) + 1
        dfs(root)
        return res
        
        return dfs(root, res)[1]