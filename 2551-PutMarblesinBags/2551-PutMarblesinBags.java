// Last updated: 3/30/2025, 11:30:41 PM
class Solution {
    public long putMarbles(int[] weights, int k) {
        /*
        weights[1, 3, 5, 1]
        */
        int n = weights.length;
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(); 
        PriorityQueue<Integer> minpq = new PriorityQueue<>(Collections.reverseOrder()); 
        for(int i = 0; i < n-1; i++){
            maxpq.offer(weights[i] + weights[i+1]);
            minpq.offer(weights[i] + weights[i+1]);
        }
        long a = 0;
        long b = 0;
        for(int i = 0; i < k-1; i++){
            if(maxpq.isEmpty())break;
            a += maxpq.poll(); 
            b += minpq.poll();
            // System.out.println("a: " + a + "; b: " + b);
        }
        return(a - b) > 0 ? (a - b) : (b - a);
        /*
        1+4 = 5
        2+2 = 4
        5+5 = 10
        2+2 = 4
        total 23

        1+1 = 2
        4+4 = 8
        2+2 = 4
        5+2 = 7
        total 21
         */
    }
}