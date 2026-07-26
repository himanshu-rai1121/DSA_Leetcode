class Solution {

    private int solveTab(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m+1][n+1];

        if(obstacleGrid[m-1][n-1] != 1)
            dp[m-1][n-1] = 1;

        for(int row = m-1;row>=0;row--) {
            for( int col = n-1;col>=0;col--) {
                if(row==m-1 && col==n-1) 
                    continue;
                int way = dp[row][col+1] + dp[row+1][col];
                dp[row][col] = way;

                if(obstacleGrid[row][col] ==1)
                    dp[row][col] = 0;
                
            }
        }
        return dp[0][0];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return solveTab(obstacleGrid);
    }
}