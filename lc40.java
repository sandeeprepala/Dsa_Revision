import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0,candidates,target,list,res);
        return res;
    }
    void helper(int start, int[] candidates, int target,List<Integer> list, List<List<Integer>> res) {
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) break;
            list.add(candidates[i]);
            helper(i + 1, candidates, target - candidates[i], list, res);
            list.remove(list.size() - 1);
        }
    }
}
