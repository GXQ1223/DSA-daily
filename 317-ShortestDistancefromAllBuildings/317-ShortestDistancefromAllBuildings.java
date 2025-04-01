// Last updated: 4/1/2025, 1:35:09 AM
class Solution {
    int m;
    int n;
    int buildings;
    boolean[][]visited;
    int[][]steps;
    int[][]directions;
    public int shortestDistance(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[][]score = new int[m][n];
        visited = new boolean[m][n];
        directions = new int[][]{{0,-1}, {-1,0}, {0,1}, {1,0}};
        int res = Integer.MAX_VALUE;
        buildings = 0;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(grid[i][j] == 1)buildings++;
        // System.out.println("Buildings: " + buildings);

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    int newRes = bfs(i, j, grid);
                    res = newRes < 0 ? res : Math.min(res, newRes);

                }
                // for(int l = 0; l < m; l++){
                //     for(int o = 0; o < n; o++){
                //         System.out.print(steps[l][o] + ";");
                //     }System.out.println();
                // }System.out.println();
            }
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int bfs(int i, int j , int[][]grid){
        for(int k = 0; k < m; k++) {
            Arrays.fill(visited[k], false);
        }
        int res = 0;
        int building = 0;
        Queue<int[]>q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        int steps = 0;
        while(!q.isEmpty() && building != buildings){
            int size = q.size();
            while(size>0){
                int[]cur = q.poll();
                size--;
                for(int[]dir: directions){
                    int row = cur[0]+dir[0];
                    int col = cur[1]+dir[1];
                    if(row >= 0 && row < m && col >= 0 && col < n){
                        if(!visited[row][col] && grid[row][col] == 0){
                            q.offer(new int[]{row, col}); 
                            visited[row][col] = true; 
                        } else if (grid[row][col] == 1 && !visited[row][col]){
                            res += steps + 1;
                            visited[row][col] = true;
                            building++;
                            // System.out.println("updated res: " + res);
                            // System.out.println("updated building: " + building);
                        }
                    }
                }
            }
            steps++;
        }
        // System.out.println("res: " + res);
        return (res == 0 || building < buildings) ? Integer.MAX_VALUE: res;
    }
}

// class Solution {
//     public int shortestDistance(int[][] grid) {
//         int rows = grid.length;
//         int cols = grid[0].length;
//         int totalHouses = 0;
        
//         // Count total houses
//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 if (grid[i][j] == 1) {
//                     totalHouses++;
//                 }
//             }
//         }
        
//         int minDistance = Integer.MAX_VALUE;
        
//         // Directions: up, right, down, left
//         int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
//         // Find the minimum distance sum for each empty cell
//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 if (grid[i][j] == 0) {
//                     minDistance = Math.min(minDistance, bfs(grid, i, j, totalHouses, directions));
//                 }
//             }
//         }
        
//         return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
//     }
    
//     private int bfs(int[][] grid, int startRow, int startCol, int totalHouses, int[][] directions) {
//         int rows = grid.length;
//         int cols = grid[0].length;
        
//         Queue<int[]> queue = new LinkedList<>();
//         boolean[][] visited = new boolean[rows][cols];
        
//         queue.offer(new int[]{startRow, startCol});
//         visited[startRow][startCol] = true;
        
//         int steps = 0;
//         int distanceSum = 0;
//         int housesReached = 0;
        
//         while (!queue.isEmpty() && housesReached != totalHouses) {
//             int size = queue.size();
            
//             // Process all cells at the current distance level
//             for (int i = 0; i < size; i++) {
//                 int[] current = queue.poll();
//                 int row = current[0];
//                 int col = current[1];
                
//                 // If this is a house, add distance and continue
//                 if (grid[row][col] == 1) {
//                     distanceSum += steps;
//                     housesReached++;
//                     continue;
//                 }
                
//                 // Explore all four directions
//                 for (int[] dir : directions) {
//                     int nextRow = row + dir[0];
//                     int nextCol = col + dir[1];
                    
//                     // Check if the next cell is valid and not visited
//                     if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && 
//                         !visited[nextRow][nextCol] && grid[nextRow][nextCol] != 2) {
                        
//                         visited[nextRow][nextCol] = true;
//                         queue.offer(new int[]{nextRow, nextCol});
//                     }
//                 }
//             }
            
//             // Increment steps after processing all cells at current level
//             steps++;
//         }
        
//         // If we couldn't reach all houses, mark all visited empty cells as unreachable (2)
//         if (housesReached != totalHouses) {
//             for (int i = 0; i < rows; i++) {
//                 for (int j = 0; j < cols; j++) {
//                     if (grid[i][j] == 0 && visited[i][j]) {
//                         grid[i][j] = 2;
//                     }
//                 }
//             }
//             return Integer.MAX_VALUE;
//         }
        
//         return distanceSum;
//     }
// }