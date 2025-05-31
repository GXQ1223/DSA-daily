# Last updated: 5/31/2025, 2:19:41 PM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        res = 1
        @cache
        def dfs(x):
            if x is None:
                return 0,0
            sel_left, nosel_left = dfs(x.left)[0], dfs(x.left)[1]
            sel_right, nosel_right = dfs(x.right)[0], dfs(x.right)[1]

            nosel_res = max(max(sel_left + sel_right, nosel_left + nosel_right), max(sel_left + nosel_right, sel_right +nosel_left))
            sel_res = nosel_left + nosel_right + x.val
            return sel_res, nosel_res
        res = dfs(root)
        return max(res[0], res[1])