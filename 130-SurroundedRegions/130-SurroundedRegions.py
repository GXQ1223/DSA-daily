# Last updated: 7/24/2025, 7:28:26 PM
class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m,n = len(board), len(board[0])
        directions = ((0,1),(-1,0),(0,-1),(1,0))
        def dfs(i,j):
            board[i][j] = 'I'
            for dir in directions:
                i2,j2 = i+dir[0], j+dir[1]
                if 0 <= i2 < m and 0 <= j2 < n and board[i2][j2] == 'O':
                    dfs(i2,j2)
        for i in range(m):
            if board[i][0] == 'O':
                dfs(i, 0)
            if board[i][n-1] == 'O':
                dfs(i, n-1)
        
        for j in range(1, n-1):
            if board[0][j] == 'O':
                dfs(0, j)
            if board[m-1][j] == 'O':
                dfs(m-1,j)
        for row in board:
            print(row)
        for i in range(m):
            for j in range(n):
                if board[i][j] == "I":
                    board[i][j] = "O"
                elif board[i][j] == "O":
                    board[i][j] = "X"

        