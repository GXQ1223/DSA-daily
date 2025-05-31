# Last updated: 5/31/2025, 3:04:48 PM
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def minCameraCover(self, root):
        ret_val = 0
        node_to_is_cameraed_map = {None: False}
        node_to_is_monitored_map = {None: True}

        def is_leaf_node(node):
            if (node is None):
                return False

            return node.left is None and node.right is None
        
        def dfs(node):
            nonlocal ret_val
            nonlocal node_to_is_cameraed_map
            nonlocal node_to_is_monitored_map
            
            if (is_leaf_node(node)):
                node_to_is_cameraed_map[node] = False
                node_to_is_monitored_map[node] = False
                return

            if (node.left is not None):
                dfs(node.left)
            if (node.right is not None):
                dfs(node.right)

            node_to_is_cameraed_map[node] = False
            node_to_is_monitored_map[node] = True if (node_to_is_cameraed_map[node.left] or node_to_is_cameraed_map[node.right]) else False
            if (not node_to_is_monitored_map[node.left] or not node_to_is_monitored_map[node.right]):
                node_to_is_cameraed_map[node] = True
                node_to_is_monitored_map[node] = True
                ret_val += 1

        dfs(root)
        ret_val += 1 if (not node_to_is_monitored_map[root]) else 0

        return ret_val