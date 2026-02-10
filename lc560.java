public class lc560 {
    public int subarraySum(int[] nums, int k) {
        int[] prefix = new int[nums.length+1];
        int cnt = 0;
        prefix[0] = 0;
        for(int i=1;i<=nums.length;i++){
            prefix[i] = prefix[i-1]+nums[i-1];
        }
        for(int i=1;i<=nums.length;i++){
            for(int j=0;j<i;j++){
                if(prefix[i]-prefix[j]==k) cnt++;
            }
        }
        return cnt;
    }
}
