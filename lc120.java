import java.util.Arrays;
import java.util.List;

public class lc120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n+1][n+1];
        for(int[] row:dp){
            Arrays.fill(row,Integer.MIN_VALUE);
        }
        return helper(triangle,0,0,dp);
    }
    public int helper(List<List<Integer>>triangle,int row,int col,int[][]dp){
        if(col>=triangle.get(row).size()){
            return Integer.MAX_VALUE;
        }
        if(row==triangle.size()-1){
            return triangle.get(row).get(col);
        }
        if(dp[row][col]!=Integer.MIN_VALUE) return dp[row][col];
        int left =  helper(triangle,row+1,col,dp);
        int right = helper(triangle,row+1,col+1,dp);
        return dp[row][col] = triangle.get(row).get(col)+Math.min(left,right);
    }
}
