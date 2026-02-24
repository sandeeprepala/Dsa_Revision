import java.util.Arrays;

public class lc64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int res = helper(grid,m-1,n-1,dp);
        return res==Integer.MAX_VALUE?-1:res;
    }
    public int helper(int[][]grid,int m,int n,int[][]dp){
        if(m==0 && n==0) return grid[0][0];
        if(m<0 || n<0) return Integer.MAX_VALUE;
        if(dp[m][n]!=-1) return dp[m][n];
        int left = helper(grid,m,n-1,dp);
        int top = helper(grid,m-1,n,dp);

        return dp[m][n] = grid[m][n] + Math.min(left,top);
    }
}
