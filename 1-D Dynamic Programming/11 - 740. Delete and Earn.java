class Solution {

    // public static int helper(int[] freq, int ind){

    //     if(ind>freq.length-1){
    //         return 0;
    //     }

    //     if(dp[ind]!=null){
    //         return dp[ind];
    //     }

    //     int notPick = helper(freq, ind+1);

    //     int pick = (ind * freq[ind]) + helper(freq, ind+2);

    //     return dp[ind] = Math.max(pick, notPick);

    // }

    // public static Integer[] dp;

    public int deleteAndEarn(int[] nums) {

        // ***** Memoization ***** - 
        
        // Arrays.sort(nums);

        // int max = nums[nums.length-1];

        // int[] freq = new int[max+1];

        // for(int i=0; i<nums.length; i++){
        //     freq[nums[i]]++;
        // }

        // dp = new Integer[max+2];

        // int ans = helper(freq, 0);

        // return ans;

        // ***** Tabulation ***** - 

        Arrays.sort(nums);

        int max = nums[nums.length-1];

        int[] freq = new int[max+1];

        for(int i=0; i<nums.length; i++){
            freq[nums[i]]++;
        }

        int[] dp = new int[max+2];

        for(int i=freq.length-1; i>=0; i--){

            int notPick = 0;

            if(i+1<freq.length){
                notPick += dp[i+1];
            }

            int pick = (i * freq[i]);

            if(i+2<freq.length){
                pick += dp[i+2];
            }

            dp[i] = Math.max(pick, notPick);

        }

        return dp[0];

    }

}
