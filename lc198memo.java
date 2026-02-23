import java.util.Arrays;

public class lc198memo {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(nums,n-1,dp);
    }
    public int helper(int[]nums,int ind,int[]dp){
        if(ind==0) return nums[ind];
        if(ind<0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int dontTake = helper(nums,ind-1,dp);
        int take = nums[ind]+helper(nums,ind-2,dp);
        return dp[ind] = Math.max(dontTake,take);
    }
}
