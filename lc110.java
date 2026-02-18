public class lc110 {
    public boolean isBalanced(TreeNode root) {
        int res = helper(root);
        if(res==-1) return false;
        return true;
    }
    public int helper(TreeNode root){
        if(root==null) return 0;
        
        int left = helper(root.left);
        if(left==-1) return -1;
        int right = helper(root.right);
        if(right==-1) return -1;        
        if(Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left,right)+1;
    }
}
