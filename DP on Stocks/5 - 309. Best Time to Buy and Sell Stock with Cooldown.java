class Solution {

    // public static int helper(int[] prices, int ind, int buy){

    //     if(ind>=prices.length){
    //         return 0;
    //     }

    //     if(dp[ind][buy]!=null){
    //         return dp[ind][buy];
    //     }

    //     if(buy == 1){
    //         return dp[ind][buy] = Math.max(-prices[ind] + helper(prices, ind+1, 0), helper(prices, ind+1, 1));
    //     }
    //     else{
    //         return dp[ind][buy] = Math.max(prices[ind] + helper(prices, ind+2, 1), helper(prices, ind+1, 0));
    //     }

    // }

    // public static Integer[][] dp;

    public int maxProfit(int[] prices) {

        // ***** Memoization ***** - 

        // dp = new Integer[prices.length][2];
        
        // int ans = helper(prices, 0, 1);

        // return ans;

        // ***** Tabulation ***** - 

        // int[][] dp = new int[prices.length+2][2];

        // for(int i=prices.length-1; i>=0; i--){
        //     for(int j=1; j>=0; j--){
        //         if(j == 1){
        //             dp[i][j] = Math.max(-prices[i] + dp[i+1][0], dp[i+1][1]);
        //         }
        //         else{
        //             dp[i][j] = Math.max(prices[i] + dp[i+2][1], dp[i+1][0]);
        //         }
        //     }
        // }

        // return dp[0][1];

        // ***** Space Optimized ***** - 

        int[] next1 = new int[2];

        int[] next2 = new int[2];

        for(int i=prices.length-1; i>=0; i--){
            int[] curr = new int[2];
            for(int j=1; j>=0; j--){
                if(j == 1){
                    curr[j] = Math.max(-prices[i] + next1[0], next1[1]);
                }
                else{
                    curr[j] = Math.max(prices[i] + next2[1], next1[0]);
                }
            }
            next2 = next1;
            next1 = curr;
        }

        return next1[1];

    }

}
