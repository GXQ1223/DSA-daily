class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for(int i = 0; i < position.length; i++){
            pq.offer(new int []{position[i], speed[i]});
        }
        // while(!pq.isEmpty()) {int[] ha = pq.poll(); System.out.println(ha[0] + ";" + ha[1]);}
        int res = 0;
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int pos = top[0];
            int spd = top[1];
            double time = (target - pos)/(double)spd; //System.out.println("time: " + time);
            while(!pq.isEmpty()){
                top = pq.peek();
                pos = top[0];
                spd = top[1]; //System.out.println("spd: " + spd + "; pos: " + pos);
                if(pos + time * spd >= target){pq.poll();}
                else{break; }
            }
            res++;
        }
        return res;
    }
}