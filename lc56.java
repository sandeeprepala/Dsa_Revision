import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            if(res.isEmpty() || res.get(res.size()-1).get(1)<intervals[i][0]){
                List<Integer> list = new ArrayList<>();
                list.add(intervals[i][0]);
                list.add(intervals[i][1]);
                res.add(list);
            }else{
                res.get(res.size()-1).set(1,Math.max(intervals[i][1],res.get(res.size()-1).get(1)));
            }
        }
        int[][] result = new int[res.size()][2];
        int i=0;
        for(List<Integer> lis:res){
            result[i][0] = lis.get(0);
            result[i][1] = lis.get(1);
            i++;
        }
        return result;
    }
}
