# Last updated: 6/17/2025, 4:03:16 PM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthLargestLevelSum(self, root: Optional[TreeNode], k: int) -> int:
        q = [root]
        res = []
        while q:
            length = len(q)
            s = 0
            for _ in range(length):
                cur = q.pop(0)
                s += cur.val
                if cur.left: q.append(cur.left)
                if cur.right: q.append(cur.right)
            res.append(s)
        res.sort()
        return -1 if len(res) < k else res[-k]