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
    public TreeNode recoverFromPreorder(String t) {
        /*
        what's the logic? 
        traversal = "1-401--349---90--88"
        1: no dash, means the level is 0
        root - 1
        -401, 401 is the leftchild. (if a node has only one child, it's guarentee to be the left child)
        --349, 401 is the current node. so current node has a left child of 349
        ---90, 349 is the curr, and has level of 2. 90 has level of 3, means it's the child of curr. must be left of 349
        --88, has level of 2. this is the child that has a level of 1.which is 401's right child
         */
        //first int is level, 2nd linkedlist are all treenodes in this level
        Map<Integer, LinkedList<TreeNode>> map = new HashMap<>(); 
        int i = 0;
        while(i < t.length()){
            int lvl = 0;
            int val = 0;
            // get the level
            while(i < t.length() && t.charAt(i) == '-') {lvl++; i++;}
            while(i < t.length() && t.charAt(i) >= '0' && t.charAt(i) <= '9'){
                val *= 10;
                val += (t.charAt(i) - '0');
                i++;
            }
            // System.out.println("val: " + val + "; lvl:" + lvl);
            map.putIfAbsent(lvl, new LinkedList<>());
            TreeNode node = new TreeNode(val);
            map.get(lvl).push(node);
            //find parent
            if(lvl>0){
                TreeNode parent = map.get(lvl-1).peek();
                // System.out.println("parent: " + parent.val + "; node: " + node.val + "; lvl: " + lvl);
                if(parent.left == null) parent.left = node;
                else if(parent.right == null && lvl > 1) {
                    parent.right = node; 
                    map.get(lvl-1).poll();
                } else if(parent.right == null && lvl == 1) {
                    parent.right = node; 
                }
            }
        }
        TreeNode root = map.get(0).get(0);
        return root;
    }
}