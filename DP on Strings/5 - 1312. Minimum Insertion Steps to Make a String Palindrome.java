class Solution {

    // public static int helper(String x, String y, int ind1, int ind2){

    //     if(ind1 == 0 || ind2 == 0){
    //         return 0;
    //     }

    //     if(dp[ind1][ind2]!=null){
    //         return dp[ind1][ind2];
    //     }

    //     if(x.charAt(ind1-1) == y.charAt(ind2-1)){
    //         return dp[ind1][ind2] = 1 + helper(x, y, ind1-1, ind2-1);
    //     }

    //     return dp[ind1][ind2] = Math.max(helper(x, y, ind1-1, ind2), helper(x, y, ind1, ind2-1));

    // }

    // public static Integer[][] dp;

    public int minInsertions(String s) {

        // ***** Memoization ***** - 
        
        // StringBuilder sb = new StringBuilder(s);

        // sb = sb.reverse();

        // if(s.equals(sb.toString())){
        //     return 0;
        // }

        // dp = new Integer[s.length()+1][s.length()+1];

        // int ans = helper(s, sb.toString(), s.length(), s.length());

        // return s.length() - ans;

        // ***** Tabulation ***** - 

        // StringBuilder sb = new StringBuilder(s);

        // sb = sb.reverse();

        // if(s.equals(sb.toString())){
        //     return 0;
        // }

        // int[][] dp = new int[s.length()+1][s.length()+1];

        // for(int i=0; i<dp.length; i++){
        //     for(int j=0; j<dp[0].length; j++){
        //         if(i == 0){
        //             dp[i][j] = 0;
        //         }
        //         else if(j == 0){
        //             dp[i][j] = 0;
        //         }
        //         else{
        //             if(s.charAt(i-1) == sb.toString().charAt(j-1)){
        //                 dp[i][j] = 1 + dp[i-1][j-1];
        //             }
        //             else{
        //                 dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        //             }
        //         }
        //     }
        // }

        // return s.length() - dp[dp.length-1][dp[0].length-1]; 

        // ***** Space Optimized ***** - 

        StringBuilder sb = new StringBuilder(s);

        sb = sb.reverse();

        if(s.equals(sb.toString())){
            return 0;
        }

        int[] prev = new int[s.length()+1];

        for(int i=0; i<s.length()+1; i++){
            int[] curr = new int[s.length()+1];
            for(int j=0; j<s.length()+1; j++){
                if(i == 0){
                    curr[j] = 0;
                }
                else if(j == 0){
                    curr[j] = 0;
                }
                else{
                    if(s.charAt(i-1) == sb.toString().charAt(j-1)){
                        curr[j] = 1 + prev[j-1];
                    }
                    else{
                        curr[j] = Math.max(prev[j], curr[j-1]);
                    }
                }
            }
            prev = curr;
        }

        return s.length() - prev[s.length()]; 

    }
    
}
