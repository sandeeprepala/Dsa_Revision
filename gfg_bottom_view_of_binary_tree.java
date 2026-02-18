import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
class Pair{
    Node node;
    int index;
    Pair(Node node,int index){
        this.node = node;
        this.index = index;
    }
}

public class gfg_bottom_view_of_binary_tree {
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair pr = q.poll();
                map.put(pr.index,pr.node.data);
                if(pr.node.left!=null){
                    q.offer(new Pair(pr.node.left,pr.index-1));
                }
                if(pr.node.right!=null){
                    q.offer(new Pair(pr.node.right,pr.index+1));
                }
            }
        }
        Map<Integer,Integer> sortedMap = new TreeMap<>(map);
        for(int num:sortedMap.values()){
            list.add(num);
        }
        return list;
    }
}
