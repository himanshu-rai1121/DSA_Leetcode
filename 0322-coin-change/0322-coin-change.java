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

    private int solveTab(int[] coins, int amount, int[][]dp) {

        for(int target=0;target<=amount;target++){
            if(target%coins[0] == 0) dp[0][target] = target/coins[0];
            else dp[0][target] = 10000008;
        }


        for(int index = 1; index<coins.length; index++) {
            for(int target=0; target<=amount;target++) {

                int take = 10000008;
                if(coins[index]<=target) 
                take = 1 + dp[index][target-coins[index]];

                int notTake = dp[index-1][target];

                dp[index][target] = Math.min(take, notTake);
            }
        }
        return dp[coins.length-1][amount];
    }

    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount+1];
        for(int[] arr: dp)
            Arrays.fill(arr, -1);

        int ans = solveTab(coins, amount, dp);

        // int ans =  solve(coins, amount, coins.length-1, dp);
        if(ans>=10000008)
            return -1;
        return ans;
    }
}