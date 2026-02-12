import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class lc90memo {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        helper(0,nums,res,list,set);
        return res;
    }
    public void helper(int ind,int[] nums,List<List<Integer>>res,List<Integer>list,HashSet<String> set){
        if(ind>=nums.length){
            Collections.sort(list);
            if(!set.contains(list.toString())){
                
                res.add(list);
                
            } 
            set.add(list.toString());
            return;
        }
        list.add(nums[ind]);
        helper(ind+1,nums,res,new ArrayList(list),set);
        list.remove(list.size()-1);
        helper(ind+1,nums,res,new ArrayList(list),set);
    }
}
