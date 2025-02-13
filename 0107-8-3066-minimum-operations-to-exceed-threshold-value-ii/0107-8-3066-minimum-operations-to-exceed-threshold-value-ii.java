class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(int i: nums) pq.offer(i);
        int res = 0;
        while(pq.peek() < k){
            int x = pq.poll();
            int y = pq.poll();
            pq.offer(Math.min(1000000001, (Math.min(1000000001, Math.min(x, y) * 2) + Math.min(1000000001, Math.max(x, y)))));
            res++;
            System.out.println("top: " + pq.peek());
        }
        return res;
    }
}