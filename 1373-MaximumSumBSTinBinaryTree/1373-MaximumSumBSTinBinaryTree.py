# Last updated: 6/12/2025, 5:23:13 PM
# # Definition for a binary tree node.
# # class TreeNode:
# #     def __init__(self, val=0, left=None, right=None):
# #         self.val = val
# #         self.left = left
# #         self.right = right
# class Solution:
#     def maxSumBST(self, root: Optional[TreeNode]) -> int:
#         @cache
#         def isbst(node):
#             if not node:
#                 return True
#             return isbst(node.left) and isbst(node.right) and node.val > ran(node.left)[1] and node.val < ran(node.right)[0]

#         def ran(node):
#             if not node:
#                 return inf, -inf 
#             # print(node.val)
#             small, big = node.val, node.val
#             small_l, big_l = ran(node.left)
#             small_r, big_r = ran(node.right)
#             return min(small, min(small_l, small_r)), max(big, max(big_l, big_r))
#         res = 0
#         def summ(node):
#             if not node:
#                 return 0
#             if isbst(node):
#                 return summ(node.left) + summ(node.right) + node.val   
#             return 0 

#         def dfs(node):
#             nonlocal res
#             if not node:
#                 return
#             elif isbst(node):
#                 res = max(res, summ(node))
#             dfs(node.left)
#             dfs(node.right)

#         dfs(root)
#         return res

class Solution:
    def maxSumBST(self, root: Optional[TreeNode]) -> int:
        res = 0

        # return status, sum, leftbound, rightbound
        def dfs(node):
            nonlocal res
            if not node:
                return 1, 0, inf, -inf

            ls, l, ll, lr = dfs(node.left)
            rs, r, rl, rr = dfs(node.right)
            if ls == 1 and rs == 1 and lr < node.val < rl:
                s = node.val + l + r
                res = max(res, s)
                return 1, s, (ll if ll != inf else node.val), (rr if rr != -inf else node.val)
            return 0, 0, 0, 0
        dfs(root)
        return res