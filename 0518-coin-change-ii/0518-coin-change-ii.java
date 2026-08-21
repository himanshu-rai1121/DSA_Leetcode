class Solution {

    private int solve(int amount, int coins[], int index, int[][] dp) {
        if(amount==0)
            return 1;
        if(amount<0 || index<0)
            return 0;
        if(dp[index][amount]!=-1)
            return dp[index][amount];

        int take = 0;
        if(amount>=coins[index])
            take = solve(amount-coins[index], coins, index, dp);

        int notTake = solve(amount, coins, index-1, dp);
        return dp[index][amount] = take + notTake;
    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] arr: dp)
            Arrays.fill(arr, -1);

        return solve(amount, coins, coins.length-1, dp);
    }
}