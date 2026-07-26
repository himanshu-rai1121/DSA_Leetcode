class Solution {
    int solve(int row, int i, List<List<Integer>> triangle, int[][]dp)
    {
        if(row==triangle.size()-1)
            return triangle.get(row).get(i);
        if(dp[row][i]!=-1)
            return dp[row][i];
        int same = triangle.get(row).get(i) + solve(row+1, i, triangle, dp);
        int increase = triangle.get(row).get(i) + solve(row+1, i+1, triangle, dp);
        return dp[row][i] = Math.min(same, increase);
        
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int[] i : dp)
            Arrays.fill(i, -1);
        return solve(0, 0, triangle, dp);
    }
}