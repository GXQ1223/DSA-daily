class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        for(int i = 1; i < n; i++){
            // the stack is in decreasing order, with smaller elements at the top
            if(nums[i] < nums[stack.peek()]) stack.push(i);
        }
        System.out.println("stack:" + stack);
        
        int res = 0;
        for(int i = n - 1; i >= 0; i--){
            
            while(nums[i] >= nums[stack.peek()]){
                res = Math.max(res, i - stack.peek());
                stack.pop();
                if(stack.isEmpty())break;
            }
            if(stack.isEmpty())break;
        }

        return res;
    }
}