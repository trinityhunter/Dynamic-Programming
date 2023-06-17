class Solution {

    // public static int helper(int[] nums, int i, int j){

    //     if(i>j){
    //         return 0;
    //     }

    //     if(dp[i][j]!=null){
    //         return dp[i][j];
    //     }

    //     int max = Integer.MIN_VALUE;

    //     for(int k=i; k<=j; k++){
    //         int ans = (nums[i-1] * nums[k] * nums[j+1]) + helper(nums, i, k-1) + helper(nums, k+1, j);

    //         max = Math.max(max, ans);
    //     }

    //     return dp[i][j] = max;

    // }

    // public static Integer[][] dp;

    public int maxCoins(int[] nums) {

        // ***** Memoization ***** - 

        // int[] nc = new int[nums.length+2];

        // nc[0] = 1;

        // for(int i=0; i<nums.length; i++){
        //     nc[i+1] = nums[i];
        // }

        // nc[nc.length-1] = 1;

        // dp = new Integer[nums.length+2][nums.length+2];

        // int ans = helper(nc, 1, nums.length);

        // return ans;

        // ***** Tabulation ***** - 

        int[] nc = new int[nums.length+2];

        nc[0] = 1;

        for(int i=0; i<nums.length; i++){
            nc[i+1] = nums[i];
        }

        nc[nc.length-1] = 1;

        int[][] dp = new int[nums.length+2][nums.length+2];

        for(int i=nums.length; i>=1; i--){
            for(int j=1; j<=nums.length; j++){

                if(i>j) continue;

                int max = Integer.MIN_VALUE;

                for(int k=i; k<=j; k++){
                    int cost = (nc[i-1] * nc[k] * nc[j+1]) + dp[i][k-1] + dp[k+1][j];

                    max = Math.max(max, cost);
                }

                dp[i][j] = max;
            }
        }

        return dp[1][nums.length];

    }

}
