import java.util.* ;
import java.io.*; 

public class Solution{

    // public static int helper(int[] weight, int[] value, int ind, int maxWeight){

    //     if(ind == 0){
    //         if(maxWeight-weight[ind]>=0){
    //             return value[ind];
    //         }
    //         return 0;
    //     }

    //     if(dp[ind][maxWeight]!=null){
    //         return dp[ind][maxWeight];
    //     }

    //     int notPick = helper(weight, value, ind-1, maxWeight);

    //     int pick = 0;

    //     if(maxWeight-weight[ind]>=0){
    //         pick = value[ind] + helper(weight, value, ind-1, maxWeight-weight[ind]);
    //     }

    //     return dp[ind][maxWeight] = Math.max(pick, notPick);

    // }

    // public static Integer[][] dp;

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        // ***** Memoization ***** - 

        // dp = new Integer[n][maxWeight+1];
        
        // int ans = helper(weight, value, n-1, maxWeight);

        // return ans;

        // ***** Tabulation ***** - 

        // int[][] dp = new int[n][maxWeight+1];

        // for(int i=0; i<n; i++){
        //     for(int j=0; j<maxWeight+1; j++){
        //         if(i == 0){
        //             if(j-weight[i]>=0){
        //                 dp[i][j] = value[i];
        //             }
        //             else{
        //                 dp[i][j] = 0;
        //             }
        //         }
        //         else{
        //             int notPick = dp[i-1][j];

        //             int pick = 0;

        //             if(j-weight[i]>=0){
        //                 pick = value[i] + dp[i-1][j-weight[i]];
        //             }

        //             dp[i][j] = Math.max(pick, notPick);
        //         }
        //     }
        // }

        // return dp[n-1][maxWeight];

        // ***** Space Optimized ***** - 

        int[] prev = new int[maxWeight+1];

        for(int i=0; i<n; i++){
            for(int j=maxWeight; j>=0; j--){
                if(i == 0){
                    if(j-weight[i]>=0){
                        prev[j] = value[i];
                    }
                    else{
                        prev[j] = 0;
                    }
                }
                else{
                    int notPick = prev[j];

                    int pick = 0;

                    if(j-weight[i]>=0){
                        pick = value[i] + prev[j-weight[i]];
                    }

                    prev[j] = Math.max(pick, notPick);
                }
            }
        }

        return prev[maxWeight];

    }

}
