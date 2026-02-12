import java.util.Arrays;

public class lc322 {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int res = helper(coins.length-1,coins,amount,dp);
        return res==Integer.MAX_VALUE?-1:res;
    }
    public int helper(int ind,int[] coins,int amount,int[][] dp){
        if(ind==0){
            if(amount%coins[0]==0){
                return amount/coins[0];
            }else{
                return Integer.MAX_VALUE;
            }
            
        } 
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        int take = Integer.MAX_VALUE;
        int dontTake = helper(ind-1,coins,amount,dp);
        if(amount>=coins[ind]){
            int sub = helper(ind,coins,amount-coins[ind],dp);
            if(sub!=Integer.MAX_VALUE){
                take = sub+1;
            }
        }
        
        return dp[ind][amount] = Math.min(take,dontTake);
    }
}
