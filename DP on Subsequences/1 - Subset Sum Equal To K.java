import java.util.* ;
import java.io.*; 

public class Solution {

    // public static boolean helper(int[] arr, int ind, int target){

    //     if(target == 0){
    //         return true;
    //     }

    //     if(ind == arr.length-1){
    //         if(target == arr[ind]){
    //             return true;
    //         }
    //         return false;
    //     }

    //     if(dp[ind][target]!=null){
    //         return dp[ind][target];
    //     }

    //     boolean notPick = helper(arr, ind+1, target);

    //     if(notPick){
    //         return dp[ind][target] = true;
    //     }

    //     boolean pick = false; 

    //     if(target-arr[ind]>=0){
    //         pick = helper(arr, ind+1, target-arr[ind]);
    //     }

    //     if(pick){
    //         return dp[ind][target] = true;
    //     }

    //     return dp[ind][target] = false;

    // }

    // public static Boolean[][] dp;
    public static boolean subsetSumToK(int n, int k, int arr[]){

        // ***** Memoization ***** - 

        // dp = new Boolean[arr.length][k+1];
        
        // boolean ans = helper(arr, 0, k);

        // return ans;

        // ***** Tabulation ***** - 

        // boolean[][] dp = new boolean[arr.length][k+1];

        // for(int i=arr.length-1; i>=0; i--){
        //     for(int j=k; j>=0; j--){
        //         if(j == 0){
        //             dp[i][j] = true;
        //         }
        //         else{
        //             if(i == arr.length-1){
        //                 if(j == arr[i]){
        //                     dp[i][j] = true;
        //                 }
        //                 else{
        //                     dp[i][j] = false;
        //                 }
        //             }
        //             else{
        //                 boolean notPick = dp[i+1][j];

        //                 if(notPick){
        //                     dp[i][j] = true;
        //                 }
        //                 else{
        //                     boolean pick = false; 

        //                     if(j-arr[i]>=0){
        //                         pick = dp[i+1][j-arr[i]];
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

        // return dp[0][k];

        // ***** Space Optimized ***** - 

        boolean[] next = new boolean[k+1];

        for(int i=arr.length-1; i>=0; i--){
            boolean[] curr = new boolean[k+1];
            for(int j=k; j>=0; j--){
                if(j == 0){
                    curr[j] = true;
                }
                else{
                    if(i == arr.length-1){
                        if(j == arr[i]){
                            curr[j] = true;
                        }
                        else{
                            curr[j] = false;
                        }
                    }
                    else{
                        boolean notPick = next[j];

                        if(notPick){
                            curr[j] = true;
                        }
                        else{
                            boolean pick = false; 

                            if(j-arr[i]>=0){
                                pick = next[j-arr[i]];
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
            next = curr;
        }

        return next[k];

    }

}
