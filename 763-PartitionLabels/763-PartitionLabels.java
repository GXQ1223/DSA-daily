// Last updated: 3/29/2025, 8:38:36 PM
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[][]grid = new int[s.length()][26];
        for(int i = 0; i < s.length(); i++){
            grid[i][s.charAt(i) - 'a']++;
        }
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b) -> a[0] - b[0]); //order by the start number of each num
        for(int i = 0; i < 26; i++){
            int start = -1;
            int end = -1;
            for(int j = 0; j < s.length(); j++){
                if(grid[j][i] == 1 && start < 0) start = j;
                if(grid[j][i] == 1) end = j;
            }
            // System.out.println("start: " + start + "; end: " + end);
            if(start >= 0) pq.offer(new int[]{start, end});
        }

        // for(int i = 0; i )
        List<Integer> res = new LinkedList<>();
        int end = pq.peek()[1];
        int currentLen = 0;
        while(!pq.isEmpty()){
            if(pq.peek()[0] > end) {
                int top = pq.peek()[0]; 
                if(res.size() != 0) 
                    top -= currentLen;; 
                res.add(top);
                currentLen += top;
            }
            end = Math.max(end, pq.poll()[1]); 
        }
        res.add(end - currentLen + 1);
        return res;
    }
}