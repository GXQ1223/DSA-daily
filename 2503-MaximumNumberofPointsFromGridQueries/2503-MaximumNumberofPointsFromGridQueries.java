// Last updated: 3/27/2025, 11:25:54 PM
class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;
        int[] result = new int[queries.length];
        int[][]DIRECTIONS = {{0,1}, {1,0}, {0,-1},{-1,0}};
        int[][] sort = new int[queries.length][2];
        for(int i = 0; i < queries.length; i++){
            sort[i][0] = queries[i]; // value
            sort[i][1] = i; // index
        }
        Arrays.sort(sort, (a, b) -> (a[0] - b[0]));

        //minHeap to process cells in increasing order of value
        PriorityQueue<int[]>minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][]visited = new boolean[m][n];

        int totalPoints = 0;
        minHeap.add(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        //process queries in sorted order
        for(int[] query: sort){
            int queryValue = query[0], queryIndex = query[1];

            //expand the cells that are smaller than the current query value
            while(!minHeap.isEmpty() && minHeap.peek()[0] < queryValue){
                int[]top = minHeap.poll();
                int cellValue = top[0], currentRow = top[1], currentCol = top[2];
                //increment count of valid cells
                totalPoints++;

                //explore all 4 possible directions
                for(int [] dir: DIRECTIONS){
                    int newRow = currentRow + dir[0];
                    int newCol = currentCol + dir[1];
                    if(
                        newRow >= 0 && 
                        newCol >= 0 &&
                        newRow < m && 
                        newCol < n && 
                        !visited[newRow][newCol]
                    ){
                        minHeap.add(new int[]{grid[newRow][newCol], newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
            result[queryIndex] = totalPoints;
        }
        return result;
    }
}