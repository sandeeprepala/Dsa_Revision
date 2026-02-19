public class lc1008 {
    public int ind = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(Integer.MAX_VALUE,preorder);
    }
    public TreeNode helper(int ub,int[]preorder){
        if(ind==preorder.length) return null;
        if(preorder[ind]>=ub) return null;
        TreeNode root = new TreeNode(preorder[ind]);
        ind++;
        root.left = helper(root.val,preorder);
        root.right = helper(ub,preorder);

        return root;
    }
}
