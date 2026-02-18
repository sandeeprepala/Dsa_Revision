import java.util.*;
public class TreeNode {
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
    int row;
    int col;
    Pair(TreeNode node,int row,int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
class lc987{
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0,0));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair pr = q.poll();
                TreeNode cur = pr.node;
                int row = pr.row;
                int col = pr.col;
                if(!map.containsKey(col)){
                    map.put(col,new TreeMap<>());
                }
                if(!map.get(col).containsKey(row)){
                    map.get(col).put(row,new PriorityQueue<>());
                }
                map.get(col).get(row).offer(cur.val);
                if(cur.left!=null){
                    q.offer(new Pair(cur.left,row+1,col-1));
                }
                if(cur.right!=null){
                    q.offer(new Pair(cur.right,row+1,col+1));
                }
            }
        }
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> colList = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }

            res.add(colList);
        }
        return res;
    }
}