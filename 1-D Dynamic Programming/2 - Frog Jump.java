import java.util.* ;
import java.io.*; 

public class Solution {

    // public static int helper(int[] heights, int n){

    //     if(n<0){
    //         return 0;
    //     }

    //     if(n == 0){
    //         return 0;
    //     }

    //     if(dp[n]!=null){
    //         return dp[n];
    //     }

    //     int left = Math.abs(heights[n] - heights[n-1]) + helper(heights, n-1);

    //     int right = Integer.MAX_VALUE;

    //     if(n>1){
    //         right = Math.abs(heights[n] - heights[n-2]) + helper(heights, n-2);
    //     }

    //     return dp[n] = Math.min(left, right);

    // }

    // public static Integer[] dp;

    public static int frogJump(int n, int heights[]) {

        // ***** Memoization ***** - 

        // dp = new Integer[n];
        
        // int ans = helper(heights, n-1);

        // return ans;

        // ***** Tabulation ***** - 

        // int[] dp = new int[n];

        // for(int i=0; i<n; i++){
        //     if(i == 0){
        //         dp[i] = 0;
        //     }
        //     else{
        //         int left = Math.abs(heights[i] - heights[i-1]) + dp[i-1];

        //         int right = Integer.MAX_VALUE;

        //         if(i>1){
        //             right = Math.abs(heights[i] - heights[i-2]) + dp[i-2];
        //         }

        //         dp[i] = Math.min(left, right);
        //     }
        // }

        // return dp[n-1];

        // ***** Space Optimized ***** -

        int ans = Integer.MAX_VALUE;

        int prev = 0;

        int prevprev = 0;

        for(int i=0; i<n; i++){
            if(i == 0){
                ans = 0;
            }
            else{
                int left = Math.abs(heights[i] - heights[i-1]) + prev;

                int right = Integer.MAX_VALUE;

                if(i>1){
                    right = Math.abs(heights[i] - heights[i-2]) + prevprev;
                }

                ans = Math.min(left, right);
                prevprev = prev;
                prev = ans;
            }
        }

        return ans;

    }

}
