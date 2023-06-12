class Solution {

    // public static boolean helper(int[] nums, int ind, int target){

    //     if(target == 0){
    //         return true;
    //     }

    //     if(ind == 0){
    //         if(target == nums[ind]){
    //             return true;
    //         }
    //         return false;
    //     }

    //     if(dp[ind][target]!=null){
    //         return dp[ind][target];
    //     }

    //     boolean notPick = helper(nums, ind-1, target);

    //     if(notPick){
    //         return dp[ind][target] = true;
    //     }

    //     boolean pick = false;

    //     if(target-nums[ind]>=0){
    //         pick = helper(nums, ind-1, target-nums[ind]);
    //     }

    //     if(pick){
    //         return dp[ind][target] = true;
    //     }

    //     return dp[ind][target] = false;

    // }

    // public static Boolean[][] dp;

    public boolean canPartition(int[] nums) {

        // ***** Memoization ***** - 
        
        // int sum = 0;

        // for(int i=0; i<nums.length; i++){
        //     sum += nums[i];
        // }

        // if(sum%2 == 1){
        //     return false;
        // }

        // int target = sum/2;

        // dp = new Boolean[nums.length][target+1];

        // boolean ans = helper(nums, nums.length-1, target);

        // return ans;

        // ***** Tabulation ***** - 

        // int sum = 0;

        // for(int i=0; i<nums.length; i++){
        //     sum += nums[i];
        // }

        // if(sum%2 == 1){
        //     return false;
        // }

        // int target = sum/2;

        // boolean[][] dp = new boolean[nums.length][target+1];

        // for(int i=0; i<nums.length; i++){
        //     for(int j=target; j>=0; j--){
        //         if(j == 0){
        //             dp[i][j] = true;
        //         }
        //         else{
        //             if(i == 0){
        //                 if(j == nums[i]){
        //                     dp[i][j] = true;
        //                 }
        //                 else{
        //                     dp[i][j] = false;
        //                 }
        //             }
        //             else{
        //                 boolean notPick = dp[i-1][j];

        //                 if(notPick){
        //                     dp[i][j] = true;
        //                 }
        //                 else{
        //                     boolean pick = false;

        //                     if(j-nums[i]>=0){
        //                         pick = dp[i-1][j-nums[i]];
        //                     }

        //                     if(pick){
        //                         dp[i][j] = true;
        //                     }
        //                     else{
        //                         dp[i][j] = false;
        //                     }
        //                 }
        //             }
        //         }
        //     }
        // }

        // return dp[nums.length-1][target];

        // ***** Space Optimized ***** - 

        int sum = 0;

        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }

        if(sum%2 == 1){
            return false;
        }

        int target = sum/2;

        boolean[] prev = new boolean[target+1];

        for(int i=0; i<nums.length; i++){
            boolean[] curr = new boolean[target+1];
            for(int j=target; j>=0; j--){
                if(j == 0){
                    curr[j] = true;
                }
                else{
                    if(i == 0){
                        if(j == nums[i]){
                            curr[j] = true;
                        }
                        else{
                            curr[j] = false;
                        }
                    }
                    else{
                        boolean notPick = prev[j];

                        if(notPick){
                            curr[j] = true;
                        }
                        else{
                            boolean pick = false;

                            if(j-nums[i]>=0){
                                pick = prev[j-nums[i]];
                            }

                            if(pick){
                                curr[j] = true;
                            }
                            else{
                                curr[j] = false;
                            }
                        }
                    }
                }
            }
            prev = curr;
        }

        return prev[target];

    }

}
