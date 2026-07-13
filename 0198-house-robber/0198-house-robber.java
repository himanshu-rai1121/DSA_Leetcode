class Solution {
    int solve(int[] nums, int pos, int n, int[] dp) {
        if(pos==n-1){
            return nums[pos];
        }
        if(pos>=n){
            return 0;
        }

        if(dp[pos]!=-1){
            return dp[pos];
        }

        return dp[pos] = Math.max(nums[pos] + solve(nums, pos+2, n, dp), solve(nums, pos+1, n, dp));
    }
    public int rob(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(nums, 0, nums.length, dp);
    }
}