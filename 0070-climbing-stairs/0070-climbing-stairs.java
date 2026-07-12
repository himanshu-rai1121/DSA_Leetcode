class Solution {

    int solve(int curPos, int[] dp){
        if(curPos == 0){
            return 1;
        }
        if(curPos < 0){
            return 0;
        }
        if(dp[curPos]!=-1){
            return dp[curPos];
        }
        return dp[curPos] = solve(curPos-1, dp) + solve(curPos-2, dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
        
    }
}