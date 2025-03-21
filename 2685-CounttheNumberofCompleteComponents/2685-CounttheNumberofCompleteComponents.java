class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // step1: find all scc; use a list to hold all the connected vertices 
        // and use boolean visited[] to mark all visited vertices. 
        // step2: after found an scc, we find the number of all edges in this SCC, then count
        // select {n, 2} = n * (n - 1) / 2

        int res = 0;
        boolean[]visitedVertices = new boolean[n];
        boolean[]visitedEdges = new boolean[edges.length];

        // find scc
        for(int i = 0; i < n; i++){
            if(!visitedVertices[i]){
                int markedEdges = 0;
                int markedVertices = 0;
                visitedVertices[i] = true; // mark all connected vertices as true
                markedVertices++;
                int marked = 1;
                while(marked > 0){
                    marked = 0;
                    for(int j = 0; j < edges.length; j++){
                        int[]edge = edges[j];
                        if(visitedEdges[j] || (!visitedVertices[edge[0]] && !visitedVertices[edge[1]])) continue;
                        visitedEdges[j] = true;
                        markedEdges++; marked ++;
                        if(visitedVertices[edge[0]] != visitedVertices[edge[1]]) {
                            visitedVertices[edge[0]] = true;
                            visitedVertices[edge[1]] = true;
                            markedVertices ++; marked ++;
                        }
                    }
                }
                // System.out.println("vertices: ");
                // for(boolean x: visitedVertices){
                //     System.out.print("; " + x);
                // }System.out.println();
                // System.out.println("Edges: ");
                // for(boolean x: visitedEdges){
                //     System.out.print("; " + x);
                // }System.out.println();
                // System.out.println();

                if((markedVertices * (markedVertices - 1) / 2) == markedEdges)res++;
            }
            

        }

        return res;
    }
}