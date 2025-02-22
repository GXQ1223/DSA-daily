class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        LinkedList<Integer>list = new LinkedList<>();
        int len = 0;
        for(int i: nums){
            if(i == 1){
                len++;
            } else if(i == 0 && len > 0) {
                list.add(len);
                len = 0;
            }
        }
        if(len>0) list.add(len);
        len = 0;
        LinkedList<Integer> brk = new LinkedList<>();
        if(nums[0] == 1) brk.add(0);
        for(int i: nums){
            if(i == 0){
                len++;
            } else if(i == 1 && len > 0) {
                brk.add(len);
                len = 0;
            }
        }
        brk.add(len);
        // System.out.println(list);
        // System.out.println(brk);

        int res = 0; 
        if(list.size() == 0){
            if(brk.get(0) > 0) return 1;
            else return 0;
        }
        // list length is only 1
        if(list.size() == 1){
            if(brk.get(0)>0 || brk.get(1)>0)return list.get(0)+1;
            return list.get(0);
        }
        for(int i = 1; i < list.size(); i++){
            if(brk.get(i) == 1)
                res = Math.max(res, 1 + list.get(i) + list.get(i-1));
            else
                res = Math.max(res, Math.max(list.get(i) + 1, list.get(i-1) + 1));
        }
        return res;
    }
}