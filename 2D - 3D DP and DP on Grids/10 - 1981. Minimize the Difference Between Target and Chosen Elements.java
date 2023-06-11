class Solution {

    public static int helper(int[][] mat, int ind, int val, int target){

        if(ind == mat.length){
            return Math.abs(val - target);
        }

        if(dp[ind][val]!=null){
            return dp[ind][val];
        }
        
        int res = Integer.MAX_VALUE;

        for(int i=0; i<mat[0].length; i++){
            res = Math.min(res, helper(mat, ind + 1, val + mat[ind][i], target));
        }
        
        return dp[ind][val] = res;

    }

    public static Integer[][] dp;

    public int minimizeTheDifference(int[][] mat, int target) {

        // ***** Memoization ***** - 

        dp = new Integer[mat.length][5001];

        return helper(mat, 0, 0, target);

    }

}
