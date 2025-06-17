# Last updated: 6/17/2025, 4:13:09 PM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def deepestLeavesSum(self, root: Optional[TreeNode]) -> int:
        q = [root]
        res = 0
        while q:
            res = 0
            length = len(q)
            for _ in range(length):
                cur = q.pop(0)
                res += cur.val
                if cur.left: q.append(cur.left)
                if cur.right: q.append(cur.right)
        return res

        