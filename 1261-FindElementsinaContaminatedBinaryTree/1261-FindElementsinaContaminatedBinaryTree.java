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
class FindElements {
    TreeNode r;
    Set<Integer> set;

    public FindElements(TreeNode root) {
        this.r = root;
        root.val = 0;
        this.set = new HashSet<>();
        this.set.add(0);
        dfs(root);
    }
    
    public boolean find(int target) {
        return this.set.contains(target);
    }

    public void dfs(TreeNode root){
        if(root.left != null && root.left.val < 0){
            root.left.val = root.val * 2 + 1;
            this.set.add(root.left.val);
            // System.out.println("root left: " + root.left.val);
            dfs(root.left);
        }
        if(root.right != null && root.right.val < 0){
            root.right.val = root.val * 2 + 2;
            this.set.add(root.right.val);
            // System.out.println("root right: " + root.right.val);
            dfs(root.right);
        }
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */