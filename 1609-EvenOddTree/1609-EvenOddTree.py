# Last updated: 6/17/2025, 4:26:12 PM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isEvenOddTree(self, root: Optional[TreeNode]) -> bool:
        q = [root]
        even = False
        while q:
            length = len(q)
            even = not even
            seq = []
            for _ in range(length):
                cur = q.pop(0)
                seq.append(cur.val)
                if cur.left: q.append(cur.left)
                if cur.right: q.append(cur.right)
            original = tuple(seq)
            seq.sort()
            if not even: seq.reverse()
            seq = tuple(seq)
            for i in range(len(seq)):
                if i > 0 and seq[i]== seq[i-1]: return False
                if even and seq[i] % 2 == 0: return False
                if not even and seq[i] % 2 == 1: return False
                if original[i] != seq[i]: return False
        return True