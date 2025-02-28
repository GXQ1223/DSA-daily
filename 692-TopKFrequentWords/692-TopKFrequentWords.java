class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word: words){
            map.putIfAbsent(word, 0);
            map.put(word, map.get(word) + 1);
        }

        // System.out.println(map);

        Map<Integer, PriorityQueue<String>> map1 = new HashMap<>();
        PriorityQueue<Integer> freq = new PriorityQueue<>(Collections.reverseOrder());
        for(String word: map.keySet()){
            int frequency = map.get(word);
            freq.offer(frequency);
            map1.putIfAbsent(frequency, new PriorityQueue<>());
            map1.get(frequency).offer(word);
        }

        // System.out.println(freq);
        // System.out.println(map1);

        List<String> res = new ArrayList<>();
        while(k>0){
            int maxFreq = freq.poll();
            PriorityQueue<String> wordsPq = map1.get(maxFreq);
            res.add(wordsPq.poll());
            k--;
        }

        return res;
    }
}