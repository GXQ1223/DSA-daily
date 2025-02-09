class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long good = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put((long)(nums[n-1] - (n-1)), 0);
        for(int i = n-2; i >= 0; i--){
            long dif = nums[i] - i;
            if(!map.containsKey(dif)){
                map.put(dif, 0);
                continue;
            }
            map.put(dif, map.get(dif) + 1);
            good+=map.get(dif);
        }
        // System.out.println("good: " + good);
        return (long)n*(n-1)/2 - good;
    }
}