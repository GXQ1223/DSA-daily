class Solution {
    Set<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new HashSet<>();
        int[][]matrix = new int[n][n];

        boolean[]cols = new boolean[n];
        boolean[]ups = new boolean[n * 2 - 1];
        boolean[]dns = new boolean[n * 2 - 1];

        backtrack(0, matrix, cols, ups, dns, n);
        
        List<List<String>> resList = new ArrayList<>();
        for(List<String>r: res) resList.add(r);
        return resList;
    }

    public void backtrack(
        int row, 
        int[][]matrix, 
        boolean[]cols, 
        boolean[]ups, boolean[]dns, int n){
        if(row == n){
            res.add(makingList(matrix));
            return;
        }

        for(int c = 0; c < n; c++){
            if(!cols[c] && !ups[row + c] && !dns[c - row + n - 1]){
                matrix[row][c] = 1;
                cols[c] = true;
                ups[row + c] = true;
                dns[c - row + n - 1] = true;

                backtrack(row+1,matrix, cols, ups, dns, n);

                matrix[row][c] = 0;
                cols[c] = false;
                ups[row + c] = false;
                dns[c - row + n - 1] = false;
            }
        }
    }

    public List<String> makingList(int[][]matrix){
        int n = matrix.length;
        List<String> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++)
                sb.append(matrix[i][j] == 1 ? 'Q' : '.');
            res.add(sb.toString());
        }
        return res;
    }
}