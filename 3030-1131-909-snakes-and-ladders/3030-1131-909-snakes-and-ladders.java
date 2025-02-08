class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[]cells = new int[n * n + 1];
        int[]res = new int[n * n + 1]; 
        boolean right = true;
        int ind = 1;
        Arrays.fill(res, -1);
        res[1] = 0;
        for(int u = n-1; u >= 0; u--){
            if(right){
                for(int v = 0; v < n & ind <= n * n; v++){
                    cells[ind] = board[u][v];  //System.out.print(cells[ind] + ";");
                    ind++;
                }
            } else {
                for(int v = n-1; v >= 0 & ind <= n * n; v--){
                    cells[ind] = board[u][v];  //System.out.print(cells[ind] + ";");
                    ind++;
                }
            }
            right = ! right;//System.out.println();
        }

        //doing bfs
        LinkedList<Integer> q = new LinkedList<>();
        q.offer(1);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int curr = q.poll(); //System.out.println("curr: "+curr);
                for(int j = 1; j <= 6 && curr + j <= n*n; j++){
                    if(cells[curr + j] == -1){// just go a step forward, mark it as res+1; throw it to queue
                        if(res[curr + j] == -1) {
                            q.offer(curr + j);
                            res[curr + j] = res[curr] + 1;
                        }
                    } else { // jump to next step
                        int jump = cells[curr + j];
                        if(res[jump] == -1){
                            q.offer(jump);
                            res[jump] = res[curr] + 1;
                        }

                    } 

                }
            }
        }
        
        return res[n*n];
    }
}