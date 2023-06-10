class Solution {

    public static int helper(int[] arr, int d, int ind){

        if(dp[ind]!=null){
            return dp[ind];
        }

        int right = 0;

        for(int i=ind+1; i<=ind+d && i<arr.length; i++){
            if(arr[i]>=arr[ind]){
                break;
            }
            right = Math.max(right, helper(arr, d, i));
        }

        int left = 0;

        for(int i=ind-1; i>=ind-d && i>=0; i--){
            if(arr[i]>=arr[ind]){
                break;
            }
            left = Math.max(left, helper(arr, d, i));
        }

        return dp[ind] = Math.max(left, right) + 1;

    }

    public static Integer[] dp;

    public int maxJumps(int[] arr, int d) {

        // ***** Memoization ***** - 

        dp = new Integer[arr.length];
        
        int ans = 0;

        for(int i=0; i<arr.length; i++){
            ans = Math.max(ans, helper(arr, d, i));
        }

        return ans;

    }

}
