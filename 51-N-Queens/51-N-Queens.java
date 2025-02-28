class Solution {
    Set<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new HashSet<>();
        int[][] matrix = new int[n][n];

        // Arrays to track if a queen can be placed in a row, column, or diagonal
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[n];
        boolean[] ups = new boolean[2 * n - 1]; // upper diagonals
        boolean[] dns = new boolean[2 * n - 1]; // lower diagonals

        backtrack(0, matrix, rows, cols, ups, dns, n);

        List<List<String>> resList = new ArrayList<>();
        for (List<String> r : res) resList.add(r);
        return resList;
    }

    // Try placing a queen in the current row
    public void backtrack(int row, int[][] matrix, boolean[] rows, boolean[] cols, 
        boolean[] ups, boolean[] dns, int n) {

        // If all queens are placed
        if (row == n) {
            res.add(makingList(matrix)); // Save the solution
            return;
        }

        // Try all columns for the current row
        for (int col = 0; col < n; col++) {
            // Check if it's safe to place the queen at (row, col)
            if (!rows[row] && !cols[col] && !ups[row + col] && !dns[col - row + n - 1]) {
                matrix[row][col] = 1; // Place queen
                rows[row] = true;      // Mark row as filled
                cols[col] = true;      // Mark column as filled
                ups[row + col] = true; // Mark upper diagonal as filled
                dns[col - row + n - 1] = true; // Mark lower diagonal as filled

                // Move to the next row
                backtrack(row + 1, matrix, rows, cols, ups, dns, n);

                // Backtrack, reset the matrix and boolean arrays
                matrix[row][col] = 0;
                rows[row] = false;
                cols[col] = false;
                ups[row + col] = false;
                dns[col - row + n - 1] = false;
            }
        }
    }

    // Convert the matrix to a List of strings
    public List<String> makingList(int[][] matrix) {
        int n = matrix.length;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(matrix[i][j] == 1 ? 'Q' : '.');
            }
            res.add(sb.toString());
        }
        return res;
    }
}
