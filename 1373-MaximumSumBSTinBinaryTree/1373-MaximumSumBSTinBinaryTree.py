# Last updated: 6/12/2025, 5:55:09 PM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getDirections(self, root: Optional[TreeNode], startValue: int, destValue: int) -> str:
        pa = []
        success = ""
        # get the path from root to a value equals to val
        def dfs(node, target):
            nonlocal pa
            nonlocal success
            if not node:
                return
            if node.val == target:
                success = "".join(pa)
                return
            pa += ['L']
            dfs(node.left, target)
            pa.pop()
            pa +=['R']
            dfs(node.right, target)
            pa.pop()
        dfs(root, startValue)
        start = list(success)
        dfs(root, destValue)
        dest = list(success)
        # print(start, dest)
        stop = 0
        if start and dest:
            for i in range(0, min(len(start), len(dest))):
                if start[i] == dest[i]:
                    stop = i+1
                else:
                    break
        # print(start, dest)
        start = start[stop:]
        start = ['U' for i in start]
        dest = dest[stop:]
        return "".join(start + dest)