class Solution {

    private int solve(int[] nums, int target, int index) {

        if(index==0){
            if(target == 0 && nums[index]==0) return 2;
            if(target == 0 || nums[index]==target) return 1;
            return 0;
        }

        int take = 0;
        if(nums[index]<=target)
            take = solve(nums, target-nums[index], index-1);
        int notTake = solve(nums, target, index-1);

        return take + notTake;

    }

    public int findTargetSumWays(int[] nums, int target) {

        // s1 - s2 = D  
        // s1, s2 is total positive and negative sum 
        // D = target
        // similar problem => Count partitions with given difference

        int totalSum = 0;
        for(int i=0;i<nums.length;i++)
            totalSum += nums[i];

        // s1-s2 = D
        // s1 + s2 = totalSum
        // s2 = totalsum -s1
        // 2s1 = D+totalSum
        // s1 = (D+totalSum)/2

        //target =  (D+totalSum)/2     
        //sol => find the number of ways to find the target  
        if(target>totalSum || (target+totalSum)%2 !=0)
            return 0;
        return solve(nums, (target+totalSum)/2, nums.length-1);

    }
}