public class lc124 {
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        helper(root,res);
        return res[0];
    }
    public int helper(TreeNode root,int[]res){
        if(root==null) return 0;
        
        int left = helper(root.left,res);
        int right = helper(root.right,res);

        res[0] = Math.max(res[0],left+right+root.val);

        return Math.max(Math.max(left,right)+root.val,0);
    }
}
