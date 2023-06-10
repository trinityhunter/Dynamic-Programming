class Solution {

    // public static int helper(int[] nums, int ind){

    //     if(ind == nums.length-1){
    //         return 0;
    //     }

    //     if(dp[ind]!=null){
    //         return dp[ind];
    //     }

    //     int min = 100000;

    //     for(int i=ind+1; i<=ind+nums[ind]; i++){
    //         if(i<nums.length){
    //             min = Math.min(min, helper(nums, i));
    //         }
    //     }

    //     return dp[ind] = min + 1;

    // }

    // public static Integer[] dp;

    public int jump(int[] nums) {

        // ***** Memoization ***** -

        // dp = new Integer[nums.length];
        
        // int ans = helper(nums, 0);

        // return ans;

        // ***** Tabulation ***** -

        int[] dp = new int[nums.length];

        for(int i=nums.length-1; i>=0; i--){

            if(i == nums.length-1){
                dp[i] = 0;
            }
            else{
                int min = 100000;

                for(int j=i+1; j<=i+nums[i]; j++){
                    if(j<nums.length){
                        min = Math.min(min, dp[j]);
                    }
                }

                dp[i] = min + 1;
            }

        }

        return dp[0];

    }

}
