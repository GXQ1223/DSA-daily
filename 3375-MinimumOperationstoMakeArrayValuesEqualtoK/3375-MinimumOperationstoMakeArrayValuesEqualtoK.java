// Last updated: 4/8/2025, 9:19:36 PM
class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer>set = new HashSet<>(); boolean yes = false;
        for(int i: nums){set.add(i); if(i < k) return -1; if(i == k) yes = true;}
        return yes? set.size() - 1 : set.size() ;
    }
}