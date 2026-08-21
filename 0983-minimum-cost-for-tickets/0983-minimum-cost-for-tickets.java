class Solution {

    private int calculateIndex(int index, int[] days, int passDuration) {
        int newIndex = 1;
        int newDate = days[index] - passDuration;
        int i = index;
        while(true) {
            i--;
            if(i>=0 && days[i]>newDate)
                newIndex++;
            else
                break;
        }
        return index-newIndex;
    }

    private int solve(int[]days, int[] costs, int index, int[] dp) {
        // Base case

        if(index<0)
            return 0;
        if(dp[index] != -1)
            return dp[index];
        


        // 1 Day pass
        int one = costs[0] + solve(days, costs, index-1, dp);

        // 7 day pass
        int seven = costs[1] + solve(days, costs, calculateIndex(index, days, 7), dp);

        // 30 day pass
        int thirty = costs[2] + solve(days, costs, calculateIndex(index, days, 30), dp);

        return dp[index] = Math.min(Math.min(one, seven), thirty);


    }

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length+1];
        Arrays.fill(dp, -1);

        return solve(days, costs, days.length-1, dp);
    }
}