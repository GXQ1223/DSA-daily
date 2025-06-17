# Last updated: 6/17/2025, 4:08:51 PM
"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if not root:
            return
        q = [root]
        while q:
            length = len(q)
            cur = None
            for i in range(length):
                cur = q.pop(0)
                if i < length - 1:
                    cur.next = q[0]
                else:
                    cur.next = None
                if cur.left: q.append(cur.left)
                if cur.right: q.append(cur.right)
        return root