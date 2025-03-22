// Last updated: 3/21/2025, 10:10:04 PM
class Solution {
    public int minimumDistance(int n, List<List<Integer>> edges, int s, int[] marked) {
        Set<Integer> markedSet = new HashSet<>();
        for(int mark: marked)markedSet.add(mark);
        int res = -1;
        boolean[]visited = new boolean[n];
        boolean[]visitedEdge = new boolean[edges.size()];
        int[]dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        dist[s] = 0;
        visited[s] = true;
        int move = 1;
        while(move > 0){
            move = 0;
            for(int i = 0; i < edges.size(); i++){
                List<Integer>edge = edges.get(i);
                int start = edge.get(0);
                int end = edge.get(1);
                visitedEdge[i] = true;
                int weight = edge.get(2);
                visited[end] = true;
                int prev = dist[end];
                dist[end] = Math.min(dist[start] + weight, dist[end]);
                if(prev != dist[end]) move++;
                else continue;
                if(markedSet.contains(end))
                    res = (res < 0) ? dist[end] : Math.min(res, dist[end]);
            }
        }
        return res == (Integer.MAX_VALUE / 2) ? -1: res;
    }
}
