import java.util.Arrays;

public class lc416_memo {
    public boolean canPartition(int[] nums) {
        int ttl = 0;
        for(int i:nums){
            ttl+=i;
        }
        Boolean[][] dp = new Boolean[nums.length+1][ttl+1];
        for(Boolean[] row:dp){
            Arrays.fill(row,null);
        }
        if(ttl%2!=0) return false;
        return helper(nums,ttl/2,nums.length-1,dp);
    }
    public boolean helper(int[]nums,int sum,int ind,Boolean[][]dp){
        if(sum==0) return true;
        if(ind<0 || sum<0) return false;
        if(dp[ind][sum]!=null) return dp[ind][sum];
        boolean take = helper(nums,sum-nums[ind],ind-1,dp);
        boolean dontTake = helper(nums,sum,ind-1,dp);

        return dp[ind][sum] = take || dontTake;

    }
}
