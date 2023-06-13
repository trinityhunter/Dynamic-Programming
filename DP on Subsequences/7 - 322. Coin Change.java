class Solution {

    // public static int helper(int[] coins, int ind, int amount){

    //     if(ind == 0){
    //         if(amount%coins[ind] == 0){
    //             return amount/coins[ind];
    //         }
    //         return Integer.MAX_VALUE-1;
    //     }

    //     if(dp[ind][amount]!=null){
    //         return dp[ind][amount];
    //     }

    //     int notPick = helper(coins, ind-1, amount);

    //     int pick = Integer.MAX_VALUE;

    //     if(amount-coins[ind]>=0){
    //         pick = 1 + helper(coins, ind, amount-coins[ind]);
    //     }

    //     return dp[ind][amount] = Math.min(pick, notPick);

    // }

    // public static Integer[][] dp;

    public int coinChange(int[] coins, int amount) {

        // ***** Memoization ***** - 

        // dp = new Integer[coins.length][amount+1];

        // int ans = helper(coins, coins.length-1, amount);

        // if(ans == Integer.MAX_VALUE-1){
        //     return -1;
        // }

        // return ans;

        // ***** Tabulation ***** - 

        // int[][] dp = new int[coins.length][amount+1];

        // for(int i=0; i<coins.length; i++){
        //     for(int j=0; j<amount+1; j++){
        //         if(i == 0){
        //             if(j%coins[i] == 0){
        //                 dp[i][j] = j/coins[i];
        //             }
        //             else{
        //                 dp[i][j] = Integer.MAX_VALUE-1;
        //             }
        //         }
        //         else{
        //             int notPick = dp[i-1][j];

        //             int pick = Integer.MAX_VALUE;

        //             if(j-coins[i]>=0){
        //                 pick = 1 + dp[i][j-coins[i]];
        //             }

        //             dp[i][j] = Math.min(pick, notPick);
        //         }
        //     }
        // }

        // int ans = dp[coins.length-1][amount];

        // if(ans == Integer.MAX_VALUE-1){
        //     return -1;
        // }

        // return ans;

        // ***** Space Optimized ***** - 

        int[] prev = new int[amount+1];

        for(int i=0; i<coins.length; i++){
            int[] curr = new int[amount+1];
            for(int j=0; j<amount+1; j++){
                if(i == 0){
                    if(j%coins[i] == 0){
                        curr[j] = j/coins[i];
                    }
                    else{
                        curr[j] = Integer.MAX_VALUE-1;
                    }
                }
                else{
                    int notPick = prev[j];

                    int pick = Integer.MAX_VALUE;

                    if(j-coins[i]>=0){
                        pick = 1 + curr[j-coins[i]];
                    }

                    curr[j] = Math.min(pick, notPick);
                }
            }
            prev = curr;
        }

        int ans = prev[amount];

        if(ans == Integer.MAX_VALUE-1){
            return -1;
        }

        return ans;

    }

}
