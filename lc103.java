import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        boolean order = true;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> lis = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode cur = q.poll();
                lis.add(cur.val);
                if(cur.left!=null){
                    q.offer(cur.left);
                }
                if(cur.right!=null){
                    q.offer(cur.right);
                }
            }
            if(order){
                res.add(lis);
            }else{
                Collections.reverse(lis);
                res.add(lis);
            }
            order = !order;
        }
        return res;
    }
}
