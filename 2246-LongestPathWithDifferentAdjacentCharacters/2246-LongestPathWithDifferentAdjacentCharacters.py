# Last updated: 5/31/2025, 3:03:20 PM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minCameraCover(self, root: Optional[TreeNode]) -> int:
        @cache
        def dfs(root):
            if root is None: return inf, 0, 0
            # three conditions: blue yellow and red
            l_blue, l_yellow, l_red = dfs(root.left)
            r_blue, r_yellow, r_red = dfs(root.right)
            blue = 1 + min(min(l_blue, l_yellow), l_red) + min(min(r_blue, r_yellow), r_red)
            yellow = min(l_blue, l_red) + min(r_blue, r_red)
            red = min(min(l_blue + min(r_blue, r_red), r_blue + min(l_blue, l_red)), l_blue + r_blue)
            return blue, yellow, red
        res = dfs(root)
        return min(res[0], res[2])