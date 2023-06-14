class Solution {

    // public static int helper(String x, String y, int ind1, int ind2){

    //     if(ind2<0){
    //         return 1;
    //     }

    //     if(ind1<0){
    //         return 0;
    //     }

    //     if(dp[ind1][ind2]!=null){
    //         return dp[ind1][ind2];
    //     }

    //     if(x.charAt(ind1) == y.charAt(ind2)){
    //         dp[ind1][ind2] = helper(x, y, ind1-1, ind2-1) + helper(x, y, ind1-1, ind2);
    //     }
    //     else{
    //         dp[ind1][ind2] = helper(x, y, ind1-1, ind2);
    //     }

    //     if(dp[ind1][ind2]>1e9){
    //         return 0;
    //     }

    //     return dp[ind1][ind2];

    // }

    // public static Integer[][] dp;

    public int numDistinct(String s, String t) {

        // ***** Memoization ***** - 

        // dp = new Integer[s.length()][t.length()];
        
        // int ans = helper(s, t, s.length()-1, t.length()-1);

        // return ans;

        // ***** Tabulation ***** - 

        // int[][] dp = new int[s.length()+1][t.length()+1];

        // for(int i=0; i<dp.length; i++){
        //     for(int j=0; j<dp[0].length; j++){
        //         if(i == 0 && j == 0){
        //             dp[i][j] = 1;
        //         }
        //         else if(i == 0){
        //             dp[i][j] = 0;
        //         }
        //         else if(j == 0){
        //             dp[i][j] = 1;
        //         }
        //         else{
        //             if(s.charAt(i-1) == t.charAt(j-1)){
        //                 dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
        //             }
        //             else{
        //                 dp[i][j] = dp[i-1][j];
        //             }
        //             if(dp[i][j]>1e9){
        //                 dp[i][j] = 0;
        //             }
        //         }
        //     }
        // }

        // return dp[dp.length-1][dp[0].length-1];

        // ***** Space Optimized ***** - 

        int[] prev = new int[t.length()+1];

        for(int i=0; i<s.length()+1; i++){
            int[] curr = new int[t.length()+1];
            for(int j=0; j<t.length()+1; j++){
                if(i == 0 && j == 0){
                    curr[j] = 1;
                }
                else if(i == 0){
                    curr[j] = 0;
                }
                else if(j == 0){
                    curr[j] = 1;
                }
                else{
                    if(s.charAt(i-1) == t.charAt(j-1)){
                        curr[j] = prev[j-1] + prev[j];
                    }
                    else{
                        curr[j] = prev[j];
                    }
                    if(curr[j]>1e9){
                        curr[j] = 0;
                    }
                }
            }
            prev = curr;
        }

        return prev[t.length()];

    }

}
