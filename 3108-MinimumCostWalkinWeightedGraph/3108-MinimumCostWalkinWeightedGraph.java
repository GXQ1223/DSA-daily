class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
      
      int[]res = new int[query.length];
      int[]scc = new int[n];
      int[]cst = new int[n];
      Arrays.fill(scc, -1);
      Arrays.fill(cst, -1);
      for(int i = 0; i < query.length; i++){
        // for(int j: scc)System.out.print("; " + j); System.out.println();for(int j: cst)System.out.print("; " + j);System.out.println();
        res[i] = calcMinCost(n, edges, query[i], scc, cst, i);
      } 

      return res;
    
    } 

    public int calcMinCost(int n, int[][] edges, int[] query, int[]scc, int[]cst, int index){
        int start = query[0];
        int end = query[1];
        if(scc[start] == scc[end] && scc[start] != -1) return cst[start];
        if(scc[start] != scc[end]) return -1;
        int res = -1; // -1 has all 1 in it
        boolean[]visited = new boolean[n];
        visited[start] = true;
        int var = 1;
        while(var != 0){
            var = 0;
            for(int[]edge: edges){
                if(visited[edge[0]] != visited[edge[1]]){
                    visited[edge[0]] = true;
                    visited[edge[1]] = true;
                    scc[edge[0]] = index;
                    scc[edge[1]] = index;
                    var++;
                }
            }
        }
        for(int[] edge: edges){
            if(visited[edge[0]] && visited[edge[1]]) res &= edge[2]; 
        }
        // System.out.println("res: " + res);
        for(int i = 0; i < scc.length; i++){
            if(scc[i] == index) cst[i] = res;
        }
        if(scc[start] != scc[end]) return -1;
        // System.out.println("res: " + res);
        return res;
    }
}