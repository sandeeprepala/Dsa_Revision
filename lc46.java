import java.util.ArrayList;
import java.util.List;

public class lc46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(nums,res,list,used);
        return res;
    }
    public void helper(int[]nums,List<List<Integer>>res,List<Integer>list,boolean[]used){
        if(list.size()==nums.length){
            res.add(list);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            list.add(nums[i]);
            used[i] = true;
            helper(nums,res,new ArrayList<>(list),used);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }
}
