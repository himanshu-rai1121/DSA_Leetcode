class Solution {

    private int solve(int[] coins, int remainingTarget, int index, int[][]dp) {
        if(remainingTarget==0)
            return 0;
        if(remainingTarget<0 || index<0)
            return 100000008;

        if(dp[index][remainingTarget] != -1)
            return dp[index][remainingTarget];

        int take = 1 + solve(coins, remainingTarget-coins[index], index, dp);

        int notTake = solve(coins, remainingTarget, index-1, dp);

        return dp[index][remainingTarget] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount+1];
        for(int[] arr: dp)
            Arrays.fill(arr, -1);
            
        int ans =  solve(coins, amount, coins.length-1, dp);
        if(ans==100000008)
            return -1;
        return ans;
    }
}