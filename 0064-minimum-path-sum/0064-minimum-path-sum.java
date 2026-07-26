import java.util.*;
class Solution {

    private int solveTab(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m+1][n+1];
        for(int[] temp : dp)
            Arrays.fill(temp, Integer.MAX_VALUE);

        for(int row=m-1;row>=0;row--) {
            for(int col = n-1;col>=0;col--) {
                if(row == m-1 && col ==n-1) {
                    dp[row][col] = grid[row][col];
                    continue;
                }
                dp[row][col] = grid[row][col] + Math.min(dp[row][col+1], dp[row+1][col]);
            }
        }

        return dp[0][0];
        
    }
    public int minPathSum(int[][] grid) {
        return solveTab(grid);
    }
}