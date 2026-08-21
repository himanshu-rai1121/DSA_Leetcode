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

    private int solveTab(int target, int coins[], int[][] dp) {

        for(int i=0;i<coins.length;i++)
            dp[i][0] = 1;
        // Base case for first coin
        for (int amount = 0; amount <= target; amount++) {
            if (amount % coins[0] == 0) {
                dp[0][amount] = 1;
            }
        }

        for(int index = 1;index<coins.length;index++) {
            for(int amount = 0;amount<=target;amount++) {
                int take = 0;
                if(amount>=coins[index])
                    take = dp[index][amount-coins[index]];

                int notTake = dp[index-1][amount];
                dp[index][amount] = take + notTake;
            }
        }        
        return dp[coins.length-1][target];
    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];

        return solveTab(amount, coins, dp);

        // for(int[] arr: dp)
        //     Arrays.fill(arr, 0);
        // return solve(amount, coins, coins.length-1, dp);
    }
}