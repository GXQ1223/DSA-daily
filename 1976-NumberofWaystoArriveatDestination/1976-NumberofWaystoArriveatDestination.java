// Last updated: 3/23/2025, 12:01:55 AM
class Solution {
    public int countPaths(int n, int[][] roads) {
        // Create adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }
        
        // Dijkstra's algorithm
        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        
        PriorityQueue<long[]> minHeap = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        minHeap.offer(new long[]{0, 0}); // [node, distance]
        
        int mod = 1_000_000_007;
        
        while (!minHeap.isEmpty()) {
            long[] current = minHeap.poll();
            int node = (int) current[0];
            long distance = current[1];
            
            // Skip if we've found a better path
            if (distance > dist[node]) continue;
            
            // Process neighbors
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                long nextDist = distance + neighbor[1];
                
                // If we found a shorter path
                if (nextDist < dist[nextNode]) {
                    dist[nextNode] = nextDist;
                    ways[nextNode] = ways[node];
                    minHeap.offer(new long[]{nextNode, nextDist});
                } 
                // If we found an equal length path
                else if (nextDist == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % mod;
                }
            }
        }
        
        return (int) ways[n - 1];
    }
}