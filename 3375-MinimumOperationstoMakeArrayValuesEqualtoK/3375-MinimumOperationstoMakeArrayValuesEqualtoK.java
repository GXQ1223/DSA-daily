// Last updated: 4/8/2025, 9:17:11 PM
class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        if(k > nums[0])return -1;
        Set<Integer>set = new HashSet<>();
        for(int i: nums)set.add(i);
        return k == nums[0]? set.size() - 1 : set.size() ;
    }
}