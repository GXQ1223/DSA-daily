# Last updated: 6/12/2025, 3:56:53 PM
class Solution(object):
    def closestNodes(self, root, queries):
        def dfs(root, arr):
            if not root: return
            dfs(root.left, arr)
            arr.append(root.val)
            dfs(root.right, arr)
        arr = []
        dfs(root, arr)
        ans = []
        n = len(arr)
        for key in queries:
            left, right = 0, n - 1
            while right >= left:
                mid = (right + left) // 2
                if arr[mid] == key:
                    break
                elif arr[mid] > key:
                    right = mid - 1
                else:
                    left = mid + 1
            if arr[mid] == key:
                ans.append([arr[mid], arr[mid]])
            elif arr[mid] > key:
                if (mid - 1) >= 0:
                    ans.append([arr[mid - 1], arr[mid]])
                else:
                    ans.append([-1, arr[mid]])
            else:
                if (mid + 1) < n:
                    ans.append([arr[mid], arr[mid + 1]])
                else:
                    ans.append([arr[mid], -1])
        return ans