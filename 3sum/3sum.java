class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Set<int[]> set = new HashSet<>();
        
        //record the first occurrence of each different number
        Map<Integer, Integer>map = new HashMap<>(); 
        Map<Integer, Integer>count = new HashMap<>(); 
        Arrays.sort(nums);
        // for(int i: nums) System.out.print(";" + i);
        for(int i = 0; i < n; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
                count.put(nums[i],0);
            }
            count.put(nums[i], count.get(nums[i]) + 1);
        }
            
                
            
        
        for(int i = 0; i < n; i++){
            for(int j = n - 1; j > i+1; j--){
                int c = -nums[i]-nums[j];
                if(map.containsKey(c) && (map.get(c) > i && map.get(c) < j)){
                    set.add(new int[]{nums[i], c, nums[j]});
                    System.out.println ("notcontain:" + nums[i] + ";" + c + ";" + nums[j]);
                    System.out.println();
                } else if(map.containsKey(c) && map.get(c) == i && count.get(c) > 1) {
                    set.add(new int[]{nums[i], c, nums[j]});
                    System.out.println( "contains:" + nums[i] + ";" + c + ";" + nums[j]);
                    System.out.println();
                }
                while(j-1>=0 && nums[j-1] == nums[j]) j--;
            }
            while(i+1<n && nums[i+1] == nums[i])i++;
        }
        for(int[] list: set){
            List<Integer> l = new LinkedList<>();
            for(int i = 0; i < 3; i++) l.addLast(list[i]);
            res.add(l);
        }
        
        return res;
    }
}