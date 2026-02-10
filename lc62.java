class lc62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return helper(m-1,n-1,dp);
    }
    public int helper(int row,int col,int[][] dp){
        if(row<=0 || col<=0){
            return 1;
        }
        if(dp[row][col]!=-1) return dp[row][col];
        int left = helper(row,col-1,dp);
        int right = helper(row-1,col,dp);
        return dp[row][col] = left+right;
    }
}