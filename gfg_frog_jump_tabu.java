public class gfg_frog_jump_tabu {
    int minCost(int[] height) {
        // code here
    //     int n = height.length-1;
    //     int[] dp = new int[n+2];
    //     Arrays.fill(dp,-1);
    //     return helper(height,n,dp);
    // }
    // public int helper(int[]heights,int ind,int[]dp){
    //     if(ind==0) return 0;
    //     if(dp[ind]!=-1) return dp[ind];
    //     int one = Integer.MAX_VALUE;
    //     int two = Integer.MAX_VALUE;
    //     if(ind>0){
    //         one = Math.abs(heights[ind]-heights[ind-1]) + helper(heights,ind-1,dp);
    //     }
    //     if(ind>1){
    //         two = Math.abs(heights[ind]-heights[ind-2]) + helper(heights,ind-2,dp);    
    //     }
        
    //     return dp[ind] = Math.min(one,two);
        
        int n = height.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for(int ind=1;ind<n;ind++){
            if(ind==1){
                dp[ind] = Math.abs(height[ind]-height[ind-1])+dp[ind-1];
            }
            else{
            dp[ind] = Math.min(Math.abs(height[ind]-height[ind-1])+dp[ind-1],Math.abs(height[ind]-height[ind-2])+dp[ind-2]);
            }
                
        }
        return dp[n-1];
    }
}
