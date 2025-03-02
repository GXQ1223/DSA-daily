class Solution {
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new LinkedList<>();

        int[][]matrix = new int[n][n];
        boolean[]cols = new boolean[n];
        boolean[]rows = new boolean[n];
        boolean[]ups = new boolean[n * 2 + 1];
        boolean[]dns = new boolean[n * 2 + 1];

        backtrack(0, rows, cols, ups, dns, matrix, n);
        return res;
    }

    public void backtrack(int currRow, boolean[]rows, boolean[]cols, boolean[]ups, boolean[]dns, int[][]matrix, int n){
        if(currRow == n){
            res.add(toStringList(matrix));
        }
        for(int i = 0; i < n; i++){
            if(!cols[i] && !ups[currRow + i] && !dns[n - 1 + i - currRow]){ // 4 - 1 + 0 - 3 = 0
                cols[i] = true; ups[currRow + i] = true; dns[n - 1 + i - currRow] = true;
                matrix[currRow][i] = 1;
                backtrack(currRow + 1, rows, cols, ups, dns, matrix, n);
                matrix[currRow][i] = 0;
                cols[i] = false; ups[currRow + i] = false; dns[n - 1 + i - currRow] = false;
            }
        }
    }

    public List<String> toStringList(int[][]matrix){
        List<String>res = new ArrayList<>();
        for(int i = 0; i < matrix.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < matrix.length;j++){
                sb.append(matrix[i][j] == 0 ? '.' : 'Q');
            }
            res.add(sb.toString());
        }
        return res;
    }
}