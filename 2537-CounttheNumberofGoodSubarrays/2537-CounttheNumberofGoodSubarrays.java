// Last updated: 4/15/2025, 9:55:00 PM
class Solution {
    public long countGood(int[] nums, int k) {
        long res = 0;
        int i = 0, j = 0, cur = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        while(i < n && j <= n){



            //two pointer
            while(j < n && cur < k){
                //add to the frequency
                map.putIfAbsent(nums[j], 0);
                map.put(nums[j], map.get(nums[j])+1); // count + 1
                // if count is more than or equal to 2, 
                if(map.get(nums[j]) == 2){
                    cur++;
                } else if (map.get(nums[j]) > 2){
                    int freq = map.get(nums[j]);
                    cur -= (freq - 1) * (freq - 2) / 2;
                    cur += (freq - 0) * (freq - 1) / 2;
                }
                // System.out.println("map: " + map);
                
                // System.out.println("res: " + res);
                j++;
            }
            //now j is fixed. print (n - j)

            if(cur >= k){
                // System.out.println("i: " + i + "; j: " + j + ";cur: " + cur);
                // System.out.println("more: " + (n - j + 1));
                res += (n - j + 1);
            }
            
            if(map.get(nums[i]) == 2){
                cur--;
            } else if (map.get(nums[i]) > 2){
                int freq = map.get(nums[i]);
                cur += (freq - 1) * (freq - 2) / 2;
                cur -= (freq - 0) * (freq - 1) / 2;
                // System.out.println("curr: " + cur);
            }
            map.put(nums[i], map.get(nums[i]) - 1);

            
            i++;
        }
        return res;
    }
}