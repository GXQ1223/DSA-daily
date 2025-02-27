class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        //special case
        if(forest.get(0).get(0) == 0) return -1;
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int m = forest.size();
        int n = forest.get(0).size();
        int[][]matrix = new int[m][n];

        //initialize the matrix and pq
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int cur = forest.get(i).get(j);
                matrix[i][j] = cur;
                if(cur > 1) pq.offer(new int[]{cur, i, j});
            }
        }

        int res = bfs(new int[]{1,0,0}, pq.peek(), matrix);
        while(pq.size() > 1){
            int step = bfs(pq.poll(), pq.peek(), matrix);
            // System.out.println("step: " + step);
            if(step == -1) return -1;
            res += step;
        }
        return res;

    }

    private int bfs(int[]cur, int[]next, int[][]matrix){
        int[]start = new int[]{cur[1], cur[2]};
        int[]end = new int[]{next[1], next[2]};
        int m = matrix.length;
        int n = matrix[0].length;
        // System.out.println("start: " + start[0] + ";" + start[1]);
        // System.out.println("end: " + end[0] + ";" + end[1]);
        int res = 0;
        String target = end[0] + "," + end[1];
        boolean[][] visited = new boolean[m][n];
        LinkedList<int[]>toVisit = new LinkedList<>();
        visited[start[0]][start[1]] = true;
        toVisit.add(start);

        while(!toVisit.isEmpty()){
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right

            int len = toVisit.size();
            // System.out.println("len: " + len);
            for(int i = 0; i < len; i++){
                int[]top = toVisit.poll();

                if((top[0] + "," + top[1]).equals(target)) return res ;
                // System.out.println("res:" + res);

                int row = top[0];
                int col = top[1];
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                        !visited[newRow][newCol] && matrix[newRow][newCol] >= 1) {
                        toVisit.offer(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
            res++;
        }
        return -1;
    }
}