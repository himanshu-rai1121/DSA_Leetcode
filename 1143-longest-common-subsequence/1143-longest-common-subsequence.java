class Solution {

    private int solve(String text1, int index1, String text2, int index2, int[][] dp) {
        if(index1<0 || index2<0) {
            return 0;
        }

        if(dp[index1][index2] != -1)
            return dp[index1][index2];

        // match
        if(text1.charAt(index1) == text2.charAt(index2))
            return dp[index1][index2] = 1 + solve(text1, index1-1, text2, index2-1, dp);
        
        //not match
        else
            return dp[index1][index2] = Math.max(solve(text1, index1-1, text2, index2, dp), solve(text1, index1, text2, index2-1, dp));
    }
    private int solveTab(String text1, int n, String text2, int m) {
        
        int[][] dp = new int[n+1][m+1];

        for(int index1 = 1;index1<=n;index1++) {
            for(int index2 = 1;index2<=m;index2++) {
                // match
                if(text1.charAt(index1-1) == text2.charAt(index2-1))
                    dp[index1][index2] = 1 + dp[index1-1][index2-1];
                
                //not match
                else
                    dp[index1][index2] = Math.max(dp[index1-1][index2], dp[index1][index2-1]);
            }
        }
        return dp[n][m];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n][m];

        return solveTab(text1, n, text2, m);

        // for(int[] arr : dp)
        //     Arrays.fill(arr, -1);
        // return solve(text1, n-1, text2, m-1, dp);
    }
}