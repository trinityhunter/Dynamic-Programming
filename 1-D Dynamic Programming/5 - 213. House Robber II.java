class Solution {

    public static int helper(int[] nums){

        int ans = nums[0];

        int prev = nums[0];

        int prevprev = 0;

        for(int i=1; i<nums.length; i++){
            int notPick = prev;
    
            int pick = nums[i] + prevprev;
            
            ans = Math.max(pick, notPick);
            prevprev = prev;
            prev = ans;
        }

        return ans;

    }

    // public static int helper(int[] nums, int ind, int end){

    //     if(ind<end){
    //         return 0;
    //     }

    //     if(dp[ind]!=null){
    //         return dp[ind];
    //     }

    //     int notPick = helper(nums, ind-1, end);

    //     int pick = helper(nums, ind-2, end) + nums[ind];

    //     return dp[ind] = Math.max(pick, notPick);

    // }

    // public static Integer[] dp;

    public int rob(int[] nums) {

        // ***** Memoization ***** - 
        
        // if(nums.length == 1){
        //     return nums[0];
        // }
        
        // dp = new Integer[nums.length];
        
        // int ans1 = helper(nums, nums.length-1, 1);

        // dp = new Integer[nums.length];
        
        // int ans2 = helper(nums, nums.length-2, 0);

        // return Math.max(ans1, ans2);

        // ***** Space Optimized ***** - 

        if(nums.length == 1){
            return nums[0];
        }

        int[] arr1 = new int[nums.length-1];

        int ii = 0;

        int[] arr2 = new int[nums.length-1];

        int jj = 0;

        for(int i=0; i<nums.length; i++){
            if(i != 0){
                arr1[ii] = nums[i];
                ii++;
            }
            if(i != nums.length-1){
                arr2[jj] = nums[i];
                jj++;
            }
        }

        return Math.max(helper(arr1), helper(arr2));

    }

}
