class Solution {

    // public static int helper(int[][] grid, int sr, int sc){

    //     if(sr == 0 && sc == 0){
    //         return grid[sr][sc];
    //     }

    //     if(dp[sr][sc]!=null){
    //         return dp[sr][sc];
    //     }

    //     int top = Integer.MAX_VALUE;

    //     if(sr-1>=0){
    //         top = Math.min(top, helper(grid, sr-1, sc));
    //     }

    //     int left = Integer.MAX_VALUE;

    //     if(sc-1>=0){
    //         left = Math.min(left, helper(grid, sr, sc-1));
    //     }

    //     return dp[sr][sc] = Math.min(left, top) + grid[sr][sc];

    // }

    // public static Integer[][] dp;

    public int minPathSum(int[][] grid) {

        // ***** Memoization ***** - 

        // dp = new Integer[grid.length][grid[0].length];
        
        // int ans = helper(grid, grid.length-1, grid[0].length-1);

        // return ans;

        // ***** Tabulation ***** - 

        // int[][] dp = new int[grid.length][grid[0].length];

        // for(int i=0; i<grid.length; i++){
        //     for(int j=0; j<grid[0].length; j++){
        //         if(i == 0 && j == 0){
        //             dp[i][j] = grid[i][j];
        //         }
        //         else{
        //             int top = Integer.MAX_VALUE;

        //             if(i-1>=0){
        //                 top = Math.min(top, dp[i-1][j]);
        //             }

        //             int left = Integer.MAX_VALUE;

        //             if(j-1>=0){
        //                 left = Math.min(left, dp[i][j-1]);
        //             }

        //             dp[i][j] = Math.min(left, top) + grid[i][j];
        //         }
        //     }
        // }

        // return dp[dp.length-1][dp[0].length-1];

        // ***** Space Optimized ***** - 

        int[] prev = new int[grid[0].length];

        for(int i=0; i<grid.length; i++){
            int[] curr = new int[grid[0].length];
            for(int j=0; j<grid[0].length; j++){
                if(i == 0 && j == 0){
                    curr[j] = grid[i][j];
                }
                else{
                    int top = Integer.MAX_VALUE;

                    if(i-1>=0){
                        top = Math.min(top, prev[j]);
                    }

                    int left = Integer.MAX_VALUE;

                    if(j-1>=0){
                        left = Math.min(left, curr[j-1]);
                    }

                    curr[j] = Math.min(left, top) + grid[i][j];
                }
            }
            prev = curr;
        }

        return prev[grid[0].length-1];

    }

}
