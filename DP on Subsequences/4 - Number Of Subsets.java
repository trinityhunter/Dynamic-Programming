import java.util.* ;
import java.io.*; 
public class Solution {

    public static int helper(int[] nums, int ind, int target){

        if(target == 0){
            return 1;
        }

        if(ind == 0){
            if(target == 0 && nums[ind] == 0){
                return 2;
            }
            if(target == nums[ind]){
                return 1;
            }
            return 0;
        }

        if(dp[ind][target]!=null){
            return dp[ind][target];
        }

        int notPick = helper(nums, ind-1, target);

        int pick = 0;

        if(target-nums[ind]>=0){
            pick = helper(nums, ind-1, target-nums[ind]);
        }

        return dp[ind][target] = pick + notPick;

    }

    public static Integer[][] dp;

    public static int findWays(int num[], int tar) {

        // ***** Memoization ***** - 

        dp = new Integer[num.length][tar+1];
    
        int ans = helper(num, num.length-1, tar);

        return ans;
    
    }

}
