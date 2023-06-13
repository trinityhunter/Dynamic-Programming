import java.util.* ;
import java.io.*; 
public class Solution {

    // public static int helper(int[] weight, int[] profit, int ind, int w){

    //     if(ind == 0){
    //         if(w >= weight[ind]){
    //             return (w/weight[ind]) * profit[ind];
    //         }
    //         return 0;
    //     }

    //     if(dp[ind][w]!=null){
    //         return dp[ind][w];
    //     }

    //     int notPick = helper(weight, profit, ind-1, w);

    //     int pick = 0;

    //     if(w-weight[ind]>=0){
    //         pick = profit[ind] + helper(weight, profit, ind, w-weight[ind]);
    //     }

    //     return dp[ind][w] = Math.max(pick, notPick);

    // }

    // public static Integer[][] dp;

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {

        // ***** Memoization ***** - 
        
        // dp = new Integer[n][w+1];

        // int ans = helper(weight, profit, n-1, w);

        // return ans;

        // ***** Tabulation ***** - 

        // int[][] dp = new int[n][w+1];

        // for(int i=0; i<n; i++){
        //     for(int j=0; j<w+1; j++){
        //         if(i == 0){
        //             if(j >= weight[i]){
        //                 dp[i][j] = (j/weight[i]) * profit[i];
        //             }
        //             else{
        //                 dp[i][j] = 0;
        //             }
        //         }
        //         else{
        //             int notPick = dp[i-1][j];

        //             int pick = 0;

        //             if(j-weight[i]>=0){
        //                 pick = profit[i] + dp[i][j-weight[i]];
        //             }

        //             dp[i][j] = Math.max(pick, notPick);
        //         }
        //     }
        // }

        // return dp[n-1][w];

        // ***** Space Optimized ***** - 

        int[] prev = new int[w+1];

        for(int i=0; i<n; i++){
            int[] curr = new int[w+1];
            for(int j=0; j<w+1; j++){
                if(i == 0){
                    if(j >= weight[i]){
                        curr[j] = (j/weight[i]) * profit[i];
                    }
                    else{
                        curr[j] = 0;
                    }
                }
                else{
                    int notPick = prev[j];

                    int pick = 0;

                    if(j-weight[i]>=0){
                        pick = profit[i] + curr[j-weight[i]];
                    }

                    curr[j] = Math.max(pick, notPick);
                }
            }
            prev = curr;
        }

        return prev[w];

    }

}
