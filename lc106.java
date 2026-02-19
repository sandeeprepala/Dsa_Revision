import java.util.HashMap;

public class lc106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
    }
    public TreeNode helper(int[] postorder,int pstart,int pend,int[]inorder,int instart,int inend,HashMap<Integer,Integer>map){
        if(pstart>pend || instart>inend) return null;

        TreeNode root = new TreeNode(postorder[pend]);
        int inRoot = map.get(postorder[pend]);
        int numsLeft = inRoot - instart;

        root.left = helper(postorder,pstart,pstart+numsLeft-1,inorder,instart,inRoot-1,map);
        root.right = helper(postorder,pstart+numsLeft,pend-1,inorder,inRoot+1,inend,map);

        return root;
    }
}
