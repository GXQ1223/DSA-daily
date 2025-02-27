class Solution {
    int index;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        index = 0;
        return construct(preorder, postorder, 0, preorder.length - 1);
    }
    private TreeNode construct(int[] preorder, int[] postorder, int l, int r){
        // System.out.println("left: " + l + ";r: " + r);
        if(l > r) return null;

        TreeNode root = new TreeNode(preorder[index++]);
        if(l == r) return root;

        int i;
        for(i = l; i <= r; i++){
            if(postorder[i] == preorder[index]) break;
        }
        root.left = construct(preorder, postorder, l, i);
        root.right = construct(preorder, postorder, i + 1, r - 1);
        return root;
    }
}
