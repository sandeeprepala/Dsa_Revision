import java.util.Arrays;

public class gfg_frog_jump_memo {
    public int minCost(int[] height) {
        // code here
        int n = height.length-1;
        int[] dp = new int[n+2];
        Arrays.fill(dp,-1);
        return helper(height,n,dp);
    }
    public int helper(int[]heights,int ind,int[]dp){
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        if(ind>0){
            one = Math.abs(heights[ind]-heights[ind-1]) + helper(heights,ind-1,dp);
        }
        if(ind>1){
            two = Math.abs(heights[ind]-heights[ind-2]) + helper(heights,ind-2,dp);    
        }
        
        return dp[ind] = Math.min(one,two);
        
    }
}
