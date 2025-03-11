class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //dfs
        boolean[]visited = new boolean[n];
        Map<Integer, List<Integer>> tree = new HashMap<>();
        //build the tree
        for(int[] i: edges){
            tree.putIfAbsent(i[0], new ArrayList<>());
            tree.get(i[0]).add(i[1]);
            tree.putIfAbsent(i[1], new ArrayList<>());
            tree.get(i[1]).add(i[0]);
        }
        System.out.println(tree);
        if(dfs(source, destination, visited, tree)) return true;
        return false;
    }

    public boolean dfs(int source, int destination, boolean[] visited, Map<Integer, List<Integer>> tree){
        visited [source] = true;
        if(visited[destination]) return true;
        if(tree.get(source) == null) return false;
        for(int i: tree.get(source)){
            if(!visited[i]) 
                if(dfs(i, destination, visited, tree)) 
                    return true;
        }
        return false;
    }
}

