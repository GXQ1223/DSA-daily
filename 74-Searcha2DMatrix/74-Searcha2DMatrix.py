# Last updated: 6/25/2025, 8:40:19 PM
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])

        # find which row its in matrix[i][0] for i in range(0,m)
        l,r = 0, m-1
        while l <= r:
            mid = (l+r)//2
            if matrix[mid][0] <= target:
                l = mid+1
            else:
                r = mid-1
        print(l, ";", r)

        # find which col its in matrix[row][i] for i in range(0,n)
        row = r
        l,r = 0, n-1
        print(l, ";", r,"; row: ",row)
        while l <= r:
            mid = (l+r)//2
            print("matrix[row][mid]: ", matrix[row][mid])
            if matrix[row][mid] == target or matrix[row][l] == target:
                return True
            elif matrix[row][mid] < target:
                l = mid+1
            else:
                r = mid-1
            print(l, "; ",mid,"; ", r)
        return False

