class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        int val = 0;
        int i = 0;
        while(i < traversal.length()){
            int lvl = 0;
            while(i < traversal.length() && traversal.charAt(i) == '-'){
                i++;
                lvl++;
            }
            val = 0;
            while(i < traversal.length() && traversal.charAt(i) != '-'){
                val *= 10;
                val += traversal.charAt(i) - '0';
                i++;
            }
            TreeNode node = new TreeNode(val);

            while(!stack.isEmpty() && stack.size() > lvl) stack.pop();
            
            if(!stack.isEmpty()){
                if(stack.peek().left == null) stack.peek().left = node;
                else stack.peek().right = node;
            }
            stack.push(node);
        }
        return stack.peekLast();
    }
}
