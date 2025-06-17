# Last updated: 6/17/2025, 4:52:51 PM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res = []
        if not root: return res
        def dfs(node, path, dif):
            nonlocal res
            if not node:
                return 
            if dif == 0 and not node.left and not node.right:
                res.append(path[:])
                return
            if node.left:
                path.append(node.left.val)
                dfs(node.left, path, dif - node.left.val)
                path.pop()
            if node.right:
                path.append(node.right.val)
                dfs(node.right, path, dif - node.right.val)
                path.pop()
        dfs(root, [root.val], targetSum - root.val)
        return res