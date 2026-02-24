public class lc62tabu {
    public int uniquePaths(int m, int n) {
    //     int[][] dp = new int[m][n];
    //     for(int[] row:dp){
    //         Arrays.fill(row,-1);
    //     }
    //     return helper(m-1,n-1,dp);
    // }
    // public int helper(int row,int col,int[][] dp){
    //     if(row<=0 || col<=0){
    //         return 1;
    //     }
    //     if(dp[row][col]!=-1) return dp[row][col];
    //     int left = helper(row,col-1,dp);
    //     int right = helper(row-1,col,dp);
    //     return dp[row][col] = left+right;
        int[][] dp = new int[m][n];
        for(int i=0;i<n;i++){
            dp[0][i] = 1;
        }
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
