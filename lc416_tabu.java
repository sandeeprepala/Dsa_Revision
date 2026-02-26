class lc416_tabu{
    public boolean canPartition(int[] nums) {
        int ttl = 0;
        for(int i:nums){
            ttl+=i;
        }
        if(ttl%2!=0) return false;
        int sum = ttl/2;
        boolean[][] dp = new boolean[nums.length][sum+1];
        for(int i=0;i<nums.length;i++){
            dp[i][0] = true;
        }
        for(int i=1;i<nums.length;i++){
            for(int j=1;j<=sum;j++){
                if(j-nums[i]>=0){
                    dp[i][j] = dp[i-1][j-nums[i]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length-1][sum];
    //     int ttl = 0;
    //     for(int i:nums){
    //         ttl+=i;
    //     }
    //     Boolean[][] dp = new Boolean[nums.length+1][ttl+1];
    //     for(Boolean[] row:dp){
    //         Arrays.fill(row,null);
    //     }
    //     if(ttl%2!=0) return false;
    //     return helper(nums,ttl/2,nums.length-1,dp);
    // }
    // public boolean helper(int[]nums,int sum,int ind,Boolean[][]dp){
    //     if(sum==0) return true;
    //     if(ind<0 || sum<0) return false;
    //     if(dp[ind][sum]!=null) return dp[ind][sum];
    //     boolean take = helper(nums,sum-nums[ind],ind-1,dp);
    //     boolean dontTake = helper(nums,sum,ind-1,dp);

    //     return dp[ind][sum] = take || dontTake;

    }
}