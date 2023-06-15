class Solution {

    // public static int helper(int[] prices, int ind, int buy, int transactions){

    //     if(transactions == 0){
    //         return 0;
    //     }

    //     if(ind == prices.length-1){
    //         if(buy == 1){
    //             return Math.max(-prices[ind], 0);
    //         }
    //         else{
    //             return Math.max(prices[ind], 0);
    //         }
    //     }

    //     if(dp[ind][buy][transactions]!=null){
    //         return dp[ind][buy][transactions];
    //     }

    //     if(buy == 1){
    //         return dp[ind][buy][transactions] = Math.max(-prices[ind] + helper(prices, ind+1, 0, transactions), helper(prices, ind+1, 1, transactions));
    //     }
    //     else{
    //         return dp[ind][buy][transactions] = Math.max(prices[ind] + helper(prices, ind+1, 1, transactions-1), helper(prices, ind+1, 0, transactions));
    //     }

    // }

    // public static Integer[][][] dp;

    public int maxProfit(int[] prices) {

        // ***** Memoization ***** - 

        // dp = new Integer[prices.length][2][3];
        
        // int ans = helper(prices, 0, 1, 2);

        // return ans;

        // ***** Tabulation ***** - 

        // int[][][] dp = new int[prices.length][2][3];

        // for(int i=prices.length-1; i>=0; i--){
        //     for(int j=1; j>=0; j--){
        //         for(int k=2; k>=0; k--){
        //             if(k == 0){
        //                 dp[i][j][k] = 0;
        //             }
        //             else{
        //                 if(i == prices.length-1){
        //                     if(j == 1){
        //                         dp[i][j][k] = Math.max(-prices[i], 0);
        //                     }
        //                     else{
        //                         dp[i][j][k] = Math.max(prices[i], 0);
        //                     }
        //                 }
        //                 else{
        //                     if(j == 1){
        //                         dp[i][j][k] = Math.max(-prices[i] + dp[i+1][0][k], dp[i+1][1][k]);
        //                     }
        //                     else{
        //                         dp[i][j][k] = Math.max(prices[i] + dp[i+1][1][k-1], dp[i+1][0][k]);
        //                     }
        //                 }
        //             }
        //         }
        //     }
        // }

        // return dp[0][1][2];

        // ***** Space Optimized ***** - 

        int[][] next = new int[2][3];

        for(int i=prices.length-1; i>=0; i--){
            int[][] curr = new int[2][3];
            for(int j=1; j>=0; j--){
                for(int k=2; k>=0; k--){
                    if(k == 0){
                        curr[j][k] = 0;
                    }
                    else{
                        if(i == prices.length-1){
                            if(j == 1){
                                curr[j][k] = Math.max(-prices[i], 0);
                            }
                            else{
                                curr[j][k] = Math.max(prices[i], 0);
                            }
                        }
                        else{
                            if(j == 1){
                                curr[j][k] = Math.max(-prices[i] + next[0][k], next[1][k]);
                            }
                            else{
                                curr[j][k] = Math.max(prices[i] + next[1][k-1], next[0][k]);
                            }
                        }
                    }
                }
            }
            next = curr;
        }

        return next[1][2];

    }

}
