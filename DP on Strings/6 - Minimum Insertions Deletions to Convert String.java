import java.util.* ;
import java.io.*; 
public class Solution {

    // public static int helper(String x, String y, int m, int n){

    //     if(m == 0 || n == 0){
    //         return 0;
    //     }

    //     if(dp[m][n]!=null){
    //         return dp[m][n];
    //     }

    //     if(x.charAt(m-1) == y.charAt(n-1)){
    //         return dp[m][n] = 1 + helper(x, y, m-1, n-1);
    //     }

    //     return dp[m][n] = Math.max(helper(x, y, m-1, n), helper(x, y, m, n-1));

    // }

    // public static Integer[][] dp;

    public static int canYouMake(String str, String ptr) {

        // ***** Memoization ***** - 

        // dp = new Integer[str.length()+1][ptr.length()+1];
        
        // int ans = helper(str, ptr, str.length(), ptr.length());

        // return str.length() + ptr.length() - 2*ans;

        // ***** Tabulation ***** - 

        // int[][] dp = new int[str.length()+1][ptr.length()+1];

        // for(int i=0; i<str.length()+1; i++){
        //     for(int j=0; j<ptr.length()+1; j++){
        //         if(i == 0|| j == 0){
        //             dp[i][j] = 0;
        //         }
        //         else{
        //             if(str.charAt(i-1) == ptr.charAt(j-1)){
        //                 dp[i][j] = 1 + dp[i-1][j-1];
        //             }
        //             else{
        //                 dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        //             }
        //         }
        //     }
        // }

        // return str.length() + ptr.length() - 2*dp[str.length()][ptr.length()];

        // ***** Space Optimized ***** - 

        int[] prev = new int[ptr.length()+1];

        for(int i=0; i<str.length()+1; i++){
            int[] curr = new int[ptr.length()+1];
            for(int j=0; j<ptr.length()+1; j++){
                if(i == 0|| j == 0){
                    curr[j] = 0;
                }
                else{
                    if(str.charAt(i-1) == ptr.charAt(j-1)){
                        curr[j] = 1 + prev[j-1];
                    }
                    else{
                        curr[j] = Math.max(prev[j], curr[j-1]);
                    }
                }
            }
            prev = curr;
        }

        return str.length() + ptr.length() - 2*prev[ptr.length()];

    }

}
