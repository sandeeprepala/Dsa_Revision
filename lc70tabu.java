public class lc70tabu {
    public int climbStairs(int n) {
    //     int[] dp = new int[n+1];
    //     Arrays.fill(dp,-1);
    //     return helper(n,dp);
    // }
    // public int helper(int n,int[]dp){
    //     if(n==0) return 1;
    //     if(n<0) return 0;
    //     if(dp[n]!=-1) return dp[n];
    //     int one = helper(n-1,dp);
    //     int two = helper(n-2,dp);

    //     return dp[n] = one+two;
        int[] dp = new int[n+1];
        if(n==0) return 1;
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
