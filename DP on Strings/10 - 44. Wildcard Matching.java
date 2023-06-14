class Solution {

    // public static boolean helper(String p, String s, int ind1, int ind2){

    //     if(ind1<0 && ind2<0){
    //         return true;
    //     }

    //     if(ind1<0 && ind2>=0){
    //         return false;
    //     }

    //     if(ind2<0 && ind1>=0){
    //         for(int i=0; i<=ind1; i++){
    //             if(p.charAt(i)!='*'){
    //                 return false;
    //             }
    //         }
    //         return true;
    //     }

    //     if(dp[ind1][ind2]!=null){
    //         return dp[ind1][ind2];
    //     }

    //     if(p.charAt(ind1) == s.charAt(ind2) || p.charAt(ind1) == '?'){
    //         return dp[ind1][ind2] = helper(p, s, ind1-1, ind2-1);
    //     }

    //     if(p.charAt(ind1) == '*'){
    //         return dp[ind1][ind2] = helper(p, s, ind1-1, ind2) || helper(p, s, ind1, ind2-1);
    //     }

    //     return false;

    // }

    // public static Boolean[][] dp;

    public boolean isMatch(String s, String p) {

        // ***** Memoization ***** - 

        // dp = new Boolean[p.length()][s.length()];
        
        // boolean ans = helper(p, s, p.length()-1, s.length()-1);

        // return ans;

        // ***** Tabulation ***** - 

        boolean[][] dp = new boolean[p.length()+1][s.length()+1];

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }
                else if(i == 0 && j>=1){
                    dp[i][j] = false;
                }
                else if(j == 0 && i>=1){
                    boolean flag = true;
                    for(int k=1; k<=i; k++){
                        if(p.charAt(k-1)!='*'){
                            flag = false;
                        }
                    }
                    dp[i][j] = flag;
                }
                else{
                    if(p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?'){
                        dp[i][j] = dp[i-1][j-1];
                    }
                    else if(p.charAt(i-1) == '*'){
                        dp[i][j] = dp[i-1][j] || dp[i][j-1];
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
            }
        }

        return dp[dp.length-1][dp[0].length-1];

    }

}
