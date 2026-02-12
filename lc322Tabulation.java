import java.util.Arrays;

public class lc322Tabulation {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int INF = (int)1e9;
        Arrays.fill(dp,INF);
        dp[0] = 0; //Initial base case
        for(int i=1;i<=amount;i++){
            for(int coin:coins){
                if(i-coin>=0 && dp[i-coin]!=Integer.MAX_VALUE){ // Check if coin can be used
                    dp[i] = Math.min(dp[i-coin]+1,dp[i]); // Use Min coins
                }
            }
        }
        return dp[amount] == INF?-1:dp[amount];
    }
}
