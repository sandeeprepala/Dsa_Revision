class lc121 {
    public int maxProfit(int[] prices) {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(int i:prices){
            mini = Math.min(mini,i);
            maxi = Math.max(maxi,i-mini);
        }
        return maxi;
    }
}