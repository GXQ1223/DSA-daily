# Last updated: 6/9/2025, 1:57:42 PM
# Definition for a rope tree node.
# class RopeTreeNode(object):
#     def __init__(self, len=0, val="", left=None, right=None):
#         self.len = len
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getKthCharacter(self, root: Optional[object], k: int) -> str:
        """
        :type root: Optional[RopeTreeNode]
        """
        def dfs(i):
            if not i:
                return None
            if not i.left and not i.right:
                return i.val
            left = dfs(i.left)
            right = dfs(i.right)
            if not left and right:
                return right
            if not right and left:
                return left
            return left + right
        total = dfs(root)
        return total[k-1]
        