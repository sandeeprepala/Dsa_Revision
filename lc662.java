import java.util.*;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Pair{
    TreeNode node;
    int ind;
    Pair(TreeNode node,int ind){
        this.node = node;
        this.ind = ind;
    }
}
public class lc662{
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        int res = Integer.MIN_VALUE;
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int l = 0;
            int r = 0;
            for(int i=0;i<size;i++){
                Pair pr = q.poll();
                TreeNode cur = pr.node;
                int ind = pr.ind;
                if(i==0){
                    l = ind;
                }
                if(i==size-1){
                    r = ind;
                }
                if(cur.left!=null){
                    q.offer(new Pair(cur.left,ind*2+1));
                }
                if(cur.right!=null){
                    q.offer(new Pair(cur.right,ind*2+2));
                }
            }
            res = Math.max(res,r-l+1);
        }
        return res;
    }
}