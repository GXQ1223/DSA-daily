class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int res = 0;
        Map<Integer, List<Integer>> tree1 = toTree(edges1);
        Map<Integer, List<Integer>> tree2 = toTree(edges2);

        int len1 = getMaxLen(tree1);
        int len2 = getMaxLen(tree2);
        res = Math.max(len1, len2);
        res = Math.max((len1+1)/2 + 1 + (len2+1)/2, res);
        return res;
    }

    public Map<Integer, List<Integer>> toTree(int[][] edges){
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for(int[] edge: edges){
            tree.putIfAbsent(edge[0], new ArrayList<>());
            tree.putIfAbsent(edge[1], new ArrayList<>());
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        return tree;
    }

    public int getMaxLen(Map<Integer, List<Integer>> tree){
        if(tree.isEmpty()) return 0;
        int edge = getEdge(tree);
        int res = 0;

        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer>q = new LinkedList<>();
        q.offer(edge);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int cur = q.poll();
                visited.add(cur);
                for(int e: tree.get(cur))
                    if(!visited.contains(e))
                        q.offer(e);
            }
            res++;
        }
        res--;
        return res;
    }

    public int getEdge(Map<Integer, List<Integer>> tree){
        LinkedList<Integer>q = new LinkedList<>();
        q.offer(0);
        Set<Integer> visited = new HashSet<>();
        int res = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            visited.add(cur);
            res = cur;
            for(int e: tree.get(cur))
                if(!visited.contains(e))
                    q.offer(e);
        }
        return res;
    }
}