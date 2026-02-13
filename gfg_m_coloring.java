import java.util.ArrayList;
import java.util.List;

class gfg_m_coloring{
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> color = new ArrayList<>();
        for (int i = 0; i < v; i++) {
        list.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++)
        {
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        for (int i = 0; i < v; i++) {
        color.add(-1);
        }
        return helper(0,v,edges,list,color,m);
    }
    public boolean helper(int ind,int V,int[][]edges,List<List<Integer>>list,List<Integer>color,int m)
    {
        if(ind==V)
        {
            return true;
        }
        for(int i=0;i<m;i++)
        {
            if(isPossible(list,ind,color,i))
            {
                color.set(ind,i);
                if(helper(ind+1,V,edges,list,color,m))
                {
                    return true;
                }
                color.set(ind,-1);
            }
        }
        return false;
    }
    public boolean isPossible(List<List<Integer>>list,int ind,List<Integer>color,int cur)
    {
        for(int i:list.get(ind))
        {
            if(color.get(i)==cur)
            {
                return false;
            }
        }
        return true;
    }
}