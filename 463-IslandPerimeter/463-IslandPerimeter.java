class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][]visited = new boolean[m][n];
        int res = 0;

        LinkedList<int[]>q = new LinkedList<>();

        //find first valid island 
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // water or already visited
                if(grid[i][j] == 0 || visited[i][j]) continue; 

                visited[i][j] = true;
                q.offer(new int[]{i, j});
                break;
            }
        }

        //bfs
        while(!q.isEmpty()){
            int[] island = q.poll();
            int i = island[0];
            int j = island[1];
            int peri = 4;
            //test number of adjacent islands
            //left
            if(j-1 >= 0 && grid[i][j-1] == 1) {
                if(!visited[i][j-1]){
                    q.offer(new int[]{i, j-1});
                    visited[i][j-1] = true;
                }
                peri--;
            }

            //right
            if(j+1 < n && grid[i][j+1] == 1) {
                if(!visited[i][j+1]){
                    q.offer(new int[]{i, j+1});
                    visited[i][j+1] = true;
                }
                peri--;
            }

            //up
            if(i-1 >= 0 && grid[i-1][j] == 1){
                if(!visited[i-1][j]){
                    q.offer(new int[]{i-1, j});
                    visited[i-1][j] = true;
                }
                peri--; 
            } 

            //dn
            if(i+1 < m && grid[i+1][j] == 1) {
                if(!visited[i+1][j]){
                    q.offer(new int[]{i+1, j});
                    visited[i+1][j] = true;
                }
                peri--; 
            } 
            res += peri;
            
        }

        return res;
    }
}