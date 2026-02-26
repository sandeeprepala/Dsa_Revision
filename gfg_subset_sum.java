import java.util.Arrays;

public class gfg_subset_sum {
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        Boolean[][] dp = new Boolean[arr.length+1][sum+1];
        for(Boolean[] row:dp){
            Arrays.fill(row,null);
        }
        return helper(arr,sum,arr.length-1,dp);
    }
    public static boolean helper(int[]arr,int sum,int ind,Boolean[][]dp){
        if(sum<0) return false;
        if(sum==0) return true;
        if(ind<0){
            if(sum==0) return true;
            return false;
        }
        if(dp[ind][sum]!=null) return dp[ind][sum];
        
        boolean take = helper(arr,sum-arr[ind],ind-1,dp);
        boolean dontTake = helper(arr,sum,ind-1,dp);
        
        return dp[ind][sum] = take || dontTake;
    }
}
