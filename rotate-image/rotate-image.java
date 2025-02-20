class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        /*
        0 1 2
        3 4 5
        6 7 8
        
        6 3 0
        7 4 1
        8 5 2
        
        0,0   0,1   0,2   ... 0,n-1
        1,0   1,1   1,2   ... 1,n-1
        
        
        ...
        ...        
        ...
        ...
        ...
        n-2,0
        n-1,0 n-1,1 n-1,2 ... n-1,n-1
                        n-1,n-2
        
        */
        if(n%2 == 1)
            for(int i = 0; i < (n-1)/2; i++){
                for(int j = 0; j < (n+1)/2; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n-1-j][i];
                    matrix[n-1-j][i] = matrix [n-1-i][n-1-j];
                    matrix [n-1-i][n-1-j] = matrix[j][n-1-i];
                    matrix [j][n-1-i] = temp;
                }
            }
        else
            for(int i = 0; i < (n)/2; i++){
                for(int j = 0; j < (n)/2; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n-1-j][i];
                    matrix[n-1-j][i] = matrix [n-1-i][n-1-j];
                    matrix [n-1-i][n-1-j] = matrix[j][n-1-i];
                    matrix [j][n-1-i] = temp;
                }
            }
        
    }
}