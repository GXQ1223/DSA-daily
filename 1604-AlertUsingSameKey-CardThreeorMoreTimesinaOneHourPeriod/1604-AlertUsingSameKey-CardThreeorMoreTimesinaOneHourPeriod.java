class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> res = new ArrayList<>();

        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(int i = 0; i < keyName.length; i++){
            map.putIfAbsent(keyName[i], new PriorityQueue());
            map.get(keyName[i]).offer(keyTime[i]);
        }
        System.out.println(map);

        for(String name: map.keySet()){
            if(map.get(name).size() < 3) continue;
            PriorityQueue<String> pq = map.get(name);
            String curr = pq.poll();
            String next = pq.poll();
            while(!pq.isEmpty()){
                if(timeDiff(curr, pq.peek())){
                    res.add(name); break;
                }
                curr = next;
                next = pq.poll();
            }
        }
        Collections.sort(res);
        return res;
    }

    public boolean timeDiff(String curr, String next){
        int hr1 = curr.charAt(1) - '0' + (curr.charAt(0) - '0') * 10;
        int hr2 = next.charAt(1) - '0' + (next.charAt(0) - '0') * 10;
        int min1 = curr.charAt(4) - '0' + (curr.charAt(3) - '0') * 10;
        int min2 = next.charAt(4) - '0' + (next.charAt(3) - '0') * 10;
        if(hr1 == hr2) return true;
        if(hr2 - hr1 == 1 && min2 <= min1) return true;
        return false;
    }
}