import java.util.* ;
import java.io.*; 

public class Solution {

	public static int lcs(String str1, String str2) {

		// ***** Tabulation ***** - 

		// int[][] dp = new int[str1.length()+1][str2.length()+1];
        
        // int max = 0;
        
        // for(int i=0; i<dp.length; i++){
        //     for(int j=0; j<dp[0].length; j++){
        //         if(i == 0){
        //             dp[i][j] = 0;
        //         }
        //         else if(j == 0){
        //             dp[i][j] = 0;
        //         }
        //         else{
        //             if(str1.charAt(i-1) == str2.charAt(j-1)){
        //                 dp[i][j] = 1 + dp[i-1][j-1];
        //             }
        //             else{
        //                 dp[i][j] = 0;
        //             }
        //         }
                
        //         max = Math.max(max, dp[i][j]);
                
        //     }
        // }
        
        // return max;

		// ***** Space Optimized ***** - 

		    int[] prev = new int[str2.length()+1];
        
        int max = 0;
        
        for(int i=0; i<str1.length()+1; i++){
			      int[] curr = new int[str2.length()+1];
            for(int j=0; j<str2.length()+1; j++){
                if(i == 0){
                    curr[j] = 0;
                }
                else if(j == 0){
                    curr[j] = 0;
                }
                else{
                    if(str1.charAt(i-1) == str2.charAt(j-1)){
                        curr[j] = 1 + prev[j-1];
                    }
                    else{
                        curr[j] = 0;
                    }
                }
                
                max = Math.max(max, curr[j]);
                
            }
			      prev = curr;
        }
        
        return max;
		
	}

}
