class Solution {

    // public static int helper(String x, String y, int ind1, int ind2){

    //     if(ind1<0){
    //         return ind2+1;
    //     }

    //     if(ind2<0){
    //         return ind1+1;
    //     }

    //     if(dp[ind1][ind2]!=null){
    //         return dp[ind1][ind2];
    //     }

    //     if(x.charAt(ind1) == y.charAt(ind2)){
    //         return dp[ind1][ind2] = helper(x, y, ind1-1, ind2-1);
    //     }
    //     else{
    //         return dp[ind1][ind2] = Math.min(1 + helper(x, y, ind1-1, ind2-1), Math.min(1 + helper(x, y, ind1-1, ind2), 1 + helper(x, y, ind1, ind2-1)));
    //     }

    // }

    // public static Integer[][] dp;

    public int minDistance(String word1, String word2) {

        // ***** Memoization ***** - 

        // dp = new Integer[word1.length()][word2.length()];
        
        // int ans = helper(word1, word2, word1.length()-1, word2.length()-1);

        // return ans;

        // ***** Tabulation ***** - 

        // int[][] dp = new int[word1.length()+1][word2.length()+1];

        // for(int i=0; i<dp.length; i++){
        //     for(int j=0; j<dp[0].length; j++){
        //         if(i == 0){
        //             dp[i][j] = j;
        //         }
        //         else if(j == 0){
        //             dp[i][j] = i;
        //         }
        //         else{
        //             if(word1.charAt(i-1) == word2.charAt(j-1)){
        //                 dp[i][j] = dp[i-1][j-1];
        //             }
        //             else{
        //                 dp[i][j] = Math.min(1 + dp[i-1][j-1], Math.min(1 + dp[i-1][j], 1 + dp[i][j-1]));
        //             }
        //         }
        //     }
        // }

        // return dp[dp.length-1][dp[0].length-1];

        // ***** Space Optimized ***** - 

        int[] prev = new int[word2.length()+1];

        for(int i=0; i<word1.length()+1; i++){
            int[] curr = new int[word2.length()+1];
            for(int j=0; j<word2.length()+1; j++){
                if(i == 0){
                    curr[j] = j;
                }
                else if(j == 0){
                    curr[j] = i;
                }
                else{
                    if(word1.charAt(i-1) == word2.charAt(j-1)){
                        curr[j] = prev[j-1];
                    }
                    else{
                        curr[j] = Math.min(1 + prev[j-1], Math.min(1 + prev[j], 1 + curr[j-1]));
                    }
                }
            }
            prev = curr;
        }

        return prev[word2.length()];

    }

}
