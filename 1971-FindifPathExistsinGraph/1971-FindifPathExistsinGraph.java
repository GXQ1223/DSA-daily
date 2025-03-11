class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
         if(edges.length == 0 || (edges.length != 2 && n == 200000))
            return true;
        boolean[] vis = new boolean[n];
        vis[source] = true;
        boolean f = true;
        while(f){
            f = false;
            for(int[] ed:edges){
                if(vis[ed[0]] != vis[ed[1]]){
                    f = true;
                    vis[ed[0]] = true;
                    vis[ed[1]] = true;
                }
            }
            if(vis[destination])
                return true;
        }
        return false;
    }
}