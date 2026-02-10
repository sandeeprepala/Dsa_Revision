import java.util.HashSet;

public class lc128 {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        HashSet<Integer> set = new HashSet<>();
        int res = 1;
        for(int i:nums){
            set.add(i);
        }
        for(int i:set){
            if(!set.contains(i-1)){
                int cur = i;
                int len = 1;
                while(set.contains(cur+1)){
                    cur++;
                    len++;
                }
                res = Math.max(res,len);
            }
        }
        return res;
    }
}
