/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> list;
    List<TreeNode> stack;
    public List<Integer> rightSideView(TreeNode root) {
        list = new LinkedList<>();
        stack = new LinkedList<>();
        if(root==null) return list;
        stack.add(root);
        bfs(stack);
        return list;
    }

    private void bfs(List<TreeNode>stack){
        while(!stack.isEmpty()){
            int size = stack.size();
            TreeNode node=null;
            for (int i=0;i<size;i++){
                node = stack.removeLast();
                // System.out.println("node.val: "+node.val);
                if(node.left!=null)
                    stack.addFirst(node.left);
                if(node.right!=null)
                    stack.addFirst(node.right);
            }
            list.add(node.val);
        }
    }
}