public class Solution {

    // public static int helper(int[][] points, int ind, int prev){

    //     if(ind>points.length-1){
    //         return 0;
    //     }

    //     if(dp[ind][prev]!=null){
    //         return dp[ind][prev];
    //     }

    //     int max = 0;

    //     for(int j=0; j<points[0].length; j++){
    //         if(j != prev){
    //             max = Math.max(max, points[ind][j] + helper(points, ind+1, j));
    //         }
    //     }

    //     return dp[ind][prev] = max;
        
    // }

    // public static Integer[][] dp;
    public static int ninjaTraining(int n, int points[][]) {

        // ***** Memoization ***** - 

        // dp = new Integer[points.length][4];
        
        // int ans = helper(points, 0, 3);

        // return ans;

        // ***** Tabulation ***** - 

        // int[][] dp = new int[points.length][4];

        // dp[0][0] = Math.max(points[0][1], points[0][2]);
        // dp[0][1] = Math.max(points[0][0], points[0][2]);
        // dp[0][2] = Math.max(points[0][0], points[0][1]);
        // dp[0][3] = Math.max(Math.max(points[0][0], points[0][1]), points[0][2]);

        // for(int i=1; i<n; i++){
        //     for(int j=0; j<4; j++){
        //         dp[i][j] = 0;
        //         for(int k=0; k<3; k++){
        //             if(k != j){
        //                 int point = points[i][k] + dp[i-1][k];
        //                 dp[i][j] = Math.max(dp[i][j], point);
        //             }
        //         }
        //     }
        // }

        // return dp[n-1][3];

        // ***** Space Optimized ***** - 

        int[] prev = new int[4];

        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(Math.max(points[0][0], points[0][1]), points[0][2]);

        for(int i=1; i<n; i++){
            int[] temp = new int[4];
            for(int j=0; j<4; j++){
                temp[j] = 0;
                for(int k=0; k<3; k++){
                    if(k != j){
                        temp[j] = Math.max(temp[j], points[i][k] + prev[k]);
                    }
                }
            }
            prev = temp;
        }

        return prev[3];
        
    }

}
