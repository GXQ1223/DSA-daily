# Last updated: 6/17/2025, 3:59:15 PM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrderBottom(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root:
            return []
        q = [root]
        res = []
        print("q: ",q[0].val)
        while q:
            length = len(q)
            order = []
            for _ in range(length):
                cur = q.pop(0)
                order.append(cur.val)
                if cur.left: q.append(cur.left)
                if cur.right: q.append(cur.right)
            res.append(order)
        res.reverse()
        return res

        