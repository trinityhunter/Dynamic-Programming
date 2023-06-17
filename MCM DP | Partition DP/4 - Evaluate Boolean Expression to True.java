import java.util.* ;
import java.io.*; 

public class Solution {

    public static int mod = 1000000007;

    public static int evaluateExp(String exp) {

        // ***** Tabulation ***** - 
        
        int n = exp.length();
        
        int[][][] dp = new int[n][n][2];
        
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<=n-1; j++){

                if(i > j){
                    continue;
                }

                for(int isTrue=0; isTrue<=1; isTrue++){
                    
                    if(i == j){
                        if(isTrue == 1){
                            if(exp.charAt(i) == 'T'){
                                dp[i][j][isTrue] = 1;
                            }
                        }
                        else{
                            if(exp.charAt(i) == 'F'){
                                dp[i][j][isTrue] = 1;
                            }
                        }
                        continue;
                    }
                    
                    long ways = 0;

                    for(int ind=i+1; ind<=j-1; ind+=2){
                        long lT = dp[i][ind - 1][1];
                        long lF = dp[i][ind - 1][0];
                        long rT = dp[ind + 1][j][1];
                        long rF = dp[ind + 1][j][0];

                        if(exp.charAt(ind) == '&'){
                            if(isTrue == 1){
                                ways = (ways + (lT * rT) % mod) % mod;
                            }
                            else{
                                ways = (ways + (lF * rT) % mod + (lT * rF) % mod + (lF * rF) % mod) % mod;
                            }
                        }
                        else if(exp.charAt(ind) == '|'){
                            if(isTrue == 1){
                                ways = (ways + (lF * rT) % mod + (lT * rF) % mod + (lT *
                            rT) % mod) % mod;
                            }
                            else{
                                ways = (ways + (lF * rF) % mod) % mod;
                            }
                        }
                        else{
                            if(isTrue == 1){
                                ways = (ways + (lF * rT) % mod + (lT * rF) % mod) % mod;
                            }
                            else{
                                ways = (ways + (lF * rF) % mod + (lT * rT) % mod) % mod;
                            }
                        }
                    }
                    dp[i][j][isTrue] = (int)ways;
                }
            }
        }

        return dp[0][n - 1][1];
        
    }

}
