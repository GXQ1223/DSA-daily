# Last updated: 6/17/2025, 4:38:08 PM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def replaceValueInTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        depth_sums = []
        q = [root]
        while q:
            length = len(q)
            depthsum = 0
            for _ in range(length):
                cur = q.pop(0)
                depthsum += cur.val
                if cur.left: q.append(cur.left)
                if cur.right: q.append(cur.right)
            depth_sums.append(depthsum)
        print(depth_sums) 

        def dfs(node, lvl):
            if not node: return
            child_sum = 0
            if node.left: child_sum += node.left.val
            if node.right: child_sum += node.right.val
            if node.left:
                node.left.val = depth_sums[lvl+1] - child_sum
                dfs(node.left, lvl+1)
            if node.right:
                node.right.val = depth_sums[lvl+1] - child_sum
                dfs(node.right, lvl+1)
        dfs(root, 0)
        root.val = 0
        return root