import java.util.*;

class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        // Special case: Starting position is blocked
        if (forest.get(0).get(0) == 0) return -1;

        // Initialize priority queue to sort trees by height
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int m = forest.size();
        int n = forest.get(0).size();

        // Add all trees to the priority queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int height = forest.get(i).get(j);
                if (height > 1) { // Only add trees (height > 1)
                    pq.offer(new int[]{height, i, j});
                }
            }
        }

        // Start from the initial position (0, 0)
        int[] start = new int[]{0, 0};
        int totalSteps = 0;

        // Process trees in order of height
        while (!pq.isEmpty()) {
            int[] nextTree = pq.poll();
            int[] end = new int[]{nextTree[1], nextTree[2]};

            // Perform BFS to find the shortest path from start to end
            int steps = bfs(forest, start, end);
            if (steps == -1) return -1; // If no path exists, return -1

            totalSteps += steps; // Add steps to the total
            start = end; // Move to the next tree
        }

        return totalSteps;
    }

    private int bfs(List<List<Integer>> forest, int[] start, int[] end) {
        int m = forest.size();
        int n = forest.get(0).size();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right
        boolean[][] visited = new boolean[m][n]; // Track visited cells
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(start);
        visited[start[0]][start[1]] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();

                // If we reach the target, return the number of steps
                if (current[0] == end[0] && current[1] == end[1]) {
                    return steps;
                }

                // Explore all four directions
                for (int[] dir : directions) {
                    int newRow = current[0] + dir[0];
                    int newCol = current[1] + dir[1];

                    // Check if the new position is valid and not blocked
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                        !visited[newRow][newCol] && forest.get(newRow).get(newCol) >= 1) {
                        queue.offer(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true; // Mark as visited
                    }
                }
            }
            steps++; // Increment steps after processing each level
        }

        // If the target is not reachable, return -1
        return -1;
    }
}