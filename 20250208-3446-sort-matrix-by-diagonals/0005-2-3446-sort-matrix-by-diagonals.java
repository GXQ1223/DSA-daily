class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        
        //right (0,n-1)
        for(int i = n-1; i>=1; i--){
            int length = n-i;
            int[]sorted = new int[length];
            //input diagonally
            for(int j = 0; n-length+j < n; j++){
                // System.out.println("j: " + j + ";n-length: " + (n-length));
                sorted[j] = grid[j][n-length+j];
            }
            Arrays.sort(sorted);
            System.out.println();
            System.out.println("sorted: ");
            for(int x: sorted)System.out.print(x + ";");
            //put back diagonally

            for(int j = 0; n-length+j < n; j++){
                // System.out.println("j: " + j + ";n-length: " + (n-length));
                 grid[j][n-length+j] = sorted[j];
            }     
        }

        //left
        for(int i = 0; i < n; i++){
            int length = n-i;
            int[]sorted = new int[length];
            //input diagonally
            for(int j = 0; j < length; j++){
                // System.out.println("j: " + j + ";n-length: " + (n-length));
                sorted[j] = grid[i+j][j];
            }
            Arrays.sort(sorted);
            System.out.println();
            System.out.println("sorted: ");
            for(int x: sorted)System.out.print(x + ";");
            //put back diagonally

            for(int j = length-1; j >= 0; j--){
                // System.out.println("j: " + j + ";n-length: " + (n-length));
                 grid[i+j][j] = sorted[length-j-1];
            } 
        }

        return grid;
    }
}