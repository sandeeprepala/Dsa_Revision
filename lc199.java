import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class lc199 {
    // Basically we can do level order traversal
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> curLevel = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode cur = q.poll();
                curLevel.add(cur.val);
                if(cur.left!=null)
                {
                    q.offer(cur.left);
                }
                if(cur.right!=null){
                    q.offer(cur.right);
                }    
            }
            res.add(curLevel.get(curLevel.size()-1));
        }
        return res;
    }
}
