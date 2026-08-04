class Solution {

    private int solve(int index, int[] nums, int sumReq, int[][] dp) {
        int n = nums.length;
        if(index==n-1) {
            return sumReq == nums[index] ? 1 : 0;
        }
        if(sumReq>=0 && dp[index][sumReq] != -1) {
            return dp[index][sumReq];
        }if(sumReq<0)
            return 0;

        int  returnVal = 0;
        if(sumReq-nums[index] == 0)
            returnVal = 1;

        returnVal = returnVal | solve(index + 1, nums, sumReq-nums[index], dp); // take
        returnVal = returnVal | solve(index + 1, nums, sumReq, dp); // not take
        return dp[index][sumReq] = returnVal;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum%2 !=0 )
            return false;
        int[][] dp = new int[nums.length][sum];
        for(int[] arr: dp)
            Arrays.fill(arr, -1);
            
        return solve(0, nums, sum/2, dp) == 0 ? false : true;
    }
}