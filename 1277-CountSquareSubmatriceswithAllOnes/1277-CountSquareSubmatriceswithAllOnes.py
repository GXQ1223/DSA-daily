# Last updated: 8/20/2025, 1:31:32 AM
class Solution:
    def countSquares(self, matrix: List[List[int]]) -> int:
        res = sum(sum(x) for x in matrix)
        m,n = len(matrix), len(matrix[0])
        print(res)
        change = True
        for size in range(2, min(m, n) + 1):
            if not change:
                break
            change = False
            for i in range(m-size+1):
                for j in range(n-size+1):
                    if matrix[i][j] != 0 and matrix[i+1][j+1] == matrix[i+1][j] == matrix[i][j+1] == size - 1:
                        matrix[i][j] = size
                        change = True
                        res += 1
        return res
        