# Last updated: 6/12/2025, 4:22:55 PM
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def delNodes(self, root: Optional[TreeNode], to_delete: List[int]) -> List[TreeNode]:
        to_delete = set(to_delete)
        res, q = [], deque([root])

        def dfs(node):
            nonlocal q
            if not node:
                return None
            if node.val in to_delete:
                # print("ahah")
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
                return None
            node.left = dfs(node.left)
            node.right = dfs(node.right)
            return node

        while q:
            # print("q: ",q)
            cur = q.popleft()
            cur = dfs(cur)
            if cur:
                res.append(cur)
        return res

        #what would be the logic?
        """use a queue to store the nodes to process
        need to record its parent.
        if a node's value is to deleted, put this node's left and right children to queue; set the node to null.
        
        """