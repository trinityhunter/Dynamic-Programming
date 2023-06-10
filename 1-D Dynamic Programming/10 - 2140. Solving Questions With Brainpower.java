class Solution {

    // public static long helper(int[][] questions, int ind){

    //     if(ind>questions.length-1){
    //         return 0;
    //     }

    //     if(dp[ind]!=null){
    //         return dp[ind];
    //     }

    //     long notPick = helper(questions, ind+1);

    //     long pick = questions[ind][0] + helper(questions, ind + questions[ind][1] + 1);

    //     return dp[ind] = Math.max(pick, notPick);

    // }

    // public static Long[] dp;

    public long mostPoints(int[][] questions) {

        // ***** Memoization ***** - 

        // dp = new Long[questions.length];
        
        // long ans = helper(questions, 0);

        // return ans;

        // ***** Tabulation ***** - 

        long[] dp = new long[questions.length];

        for(int i=questions.length-1; i>=0; i--){

            long notPick = 0;

            if(i+1<questions.length){
                notPick += dp[i+1];
            }

            long pick = questions[i][0];
            
            if(i + questions[i][1] + 1 < questions.length){
                pick += dp[i + questions[i][1] + 1];
            }

            dp[i] = Math.max(pick, notPick);

        }

        return dp[0];

    }

}
