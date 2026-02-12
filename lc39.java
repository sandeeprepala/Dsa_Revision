import java.util.ArrayList;
import java.util.List;

public class lc39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(0,candidates,target,res,list);
        return res;
    }
    public void helper(int ind,int[]candidates,int target,List<List<Integer>> res,List<Integer> list){
        if(ind==candidates.length){
            if(target==0) res.add(new ArrayList<>(list));
            return;
        }
        if(candidates[ind]<=target){
            list.add(candidates[ind]);
            helper(ind,candidates,target-candidates[ind],res,new ArrayList<>(list));
            list.remove(list.size()-1);
        }    
        helper(ind+1,candidates,target,res,new ArrayList<>(list));
    }
}
