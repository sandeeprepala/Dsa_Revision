class lc105{
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<preorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }
    public TreeNode helper(int[]preorder,int pstart,int pend,int[]inorder,int istart,int iend,HashMap<Integer,Integer>map){
        if(pstart>pend || istart>iend) return null;

        TreeNode root = new TreeNode(preorder[pstart]);
        int inRoot = map.get(preorder[pstart]);
        int numsLeft = inRoot-istart;

        root.left = helper(preorder,pstart+1,pstart+numsLeft,inorder,istart,inRoot-1,map);
        root.right = helper(preorder,pstart+numsLeft+1,pend,inorder,inRoot+1,iend,map);

        return root;
    }
}