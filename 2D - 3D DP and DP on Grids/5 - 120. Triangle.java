class Solution {

    // public static int helper(List<List<Integer>> triangle, int sr, int sc){

    //     if(sr == triangle.size()-1){
    //         return triangle.get(sr).get(sc);
    //     }

    //     if(dp[sr][sc]!=null){
    //         return dp[sr][sc];
    //     }

    //     int min = 100000;

    //     if(sr+1<=triangle.size()-1 && sc+1<=triangle.get(sr+1).size()){
    //         min = Math.min(min, helper(triangle, sr+1, sc+1));
    //     }

    //     if(sr+1<=triangle.size()-1){
    //         min = Math.min(min, helper(triangle, sr+1, sc));
    //     }

    //     return dp[sr][sc] = min + triangle.get(sr).get(sc);

    // }

    // public static Integer[][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {

        // ***** Memoization ***** - 

        // dp = new Integer[triangle.size()][triangle.get(triangle.size()-1).size()];

        // int ans = helper(triangle, 0, 0);

        // return ans;

        // ***** Tabulation ***** - 

        // int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];

        // for(int i=triangle.size()-1; i>=0; i--){
        //     for(int j=triangle.get(i).size()-1; j>=0; j--){
        //         if(i == triangle.size()-1){
        //             dp[i][j] =  triangle.get(i).get(j);
        //         }
        //         else{
        //             int min = 100000;

        //             if(i+1<=triangle.size()-1 && j+1<=triangle.get(i+1).size()){
        //                 min = Math.min(min, dp[i+1][j+1]);
        //             }

        //             if(i+1<=triangle.size()-1){
        //                 min = Math.min(min, dp[i+1][j]);
        //             }

        //             dp[i][j] = min + triangle.get(i).get(j);
        //         }
        //     }
        // }

        // return dp[0][0];

        // ***** Space Optimized ***** - 

        int[] next = new int[triangle.get(triangle.size()-1).size()];

        for(int i=triangle.size()-1; i>=0; i--){
            int[] curr = new int[triangle.get(triangle.size()-1).size()];
            for(int j=triangle.get(i).size()-1; j>=0; j--){
                if(i == triangle.size()-1){
                    curr[j] =  triangle.get(i).get(j);
                }
                else{
                    int min = 100000;

                    if(i+1<=triangle.size()-1 && j+1<=triangle.get(i+1).size()){
                        min = Math.min(min, next[j+1]);
                    }

                    if(i+1<=triangle.size()-1){
                        min = Math.min(min, next[j]);
                    }

                    curr[j] = min + triangle.get(i).get(j);
                }
            }
            next = curr;
        }

        return next[0];

    }

}
