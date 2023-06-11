class Solution {

    // public static int helper(int sr, int sc){

    //     if(sr == 0 && sc == 0){
    //         return 1;
    //     }

    //     if(dp[sr][sc]!=null){
    //         return dp[sr][sc];
    //     }

    //     int ans = 0;

    //     if(sr-1>=0){
    //         ans += helper(sr-1, sc);
    //     }

    //     if(sc-1>=0){
    //         ans += helper(sr, sc-1);
    //     }

    //     return dp[sr][sc] = ans;

    // }

    // public static Integer[][] dp;

    public int uniquePaths(int m, int n) {

        // ***** Memoization ***** - 

        // dp = new Integer[m][n];

        // int ans = helper(m-1, n-1);

        // return ans;

        // ***** Tabulation ***** - 

        // int[][] dp = new int[m][n];

        // for(int i=0; i<m; i++){
        //     for(int j=0; j<n; j++){
        //         if(i == 0 && j == 0){
        //             dp[i][j] = 1;
        //         }
        //         else{
        //             int ans = 0;

        //             if(i-1>=0){
        //                 ans += dp[i-1][j];
        //             }

        //             if(j-1>=0){
        //                 ans += dp[i][j-1];
        //             }

        //             dp[i][j] = ans;
        //         }
        //     }
        // }

        // return dp[m-1][n-1];

        // ***** Space Optimized ***** - 

        int[] prev = new int[n];

        for(int i=0; i<m; i++){
            int[] curr = new int[n];
            for(int j=0; j<n; j++){
                if(i == 0 && j == 0){
                    curr[j] = 1;
                }
                else{
                    int ans = 0;

                    if(i-1>=0){
                        ans += prev[j];
                    }

                    if(j-1>=0){
                        ans += curr[j-1];
                    }

                    curr[j] = ans;
                }
            }
            prev = curr;
        }

        return prev[n-1];

    }

}
