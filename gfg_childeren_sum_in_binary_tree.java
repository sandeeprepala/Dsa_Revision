public class gfg_childeren_sum_in_binary_tree {
    public boolean isSumProperty(Node root) {
        //  code here
        if(root==null) return true;
        return helper(root);
    }
    public boolean helper(Node root){
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;
        
        int sum = 0;
        if(root.left!=null){
            sum += root.left.data;
        }
        if(root.right!=null){
            sum += root.right.data;
        }
        if(sum!=root.data) return false;
        
        return helper(root.left) && helper(root.right);
    }
}
