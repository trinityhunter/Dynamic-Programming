class Solution {
    
    // public static int helper(int[] arr, int ind){
        
    //     if(ind<0){
    //         return 0;
    //     }
        
    //     if(dp[ind]!=null){
    //         return dp[ind];
    //     }
        
    //     int notPick = helper(arr, ind-1);
        
    //     int pick = arr[ind] + helper(arr, ind-2);
        
    //     return dp[ind] = Math.max(pick, notPick);
        
    // }
    
    // public static Integer[] dp;
    
    int findMaxSum(int arr[], int n) {
        
        // ***** Memoization ***** - 
        
        // dp = new Integer[n];
        
        // int ans = helper(arr, n-1);
        
        // return ans;
        
        // ***** Tabulation ***** - 
        
        // int[] dp = new int[n];
        
        // for(int i=0; i<n; i++){
        //     if(i == 0){
        //         dp[i] = arr[i];
        //     }
        //     else if(i==1){
        //         dp[i] = Math.max(dp[i-1], arr[i]);
        //     }
        //     else{
        //         int notPick = dp[i-1];
        
        //         int pick = arr[i] + dp[i-2];
                
        //         dp[i] = Math.max(pick, notPick);
        //     }
        // }
        
        // return dp[n-1];
        
        // ***** Space Optimized ***** - 
        
        int ans = arr[0];
        
        int prev = arr[0];
        
        int prevprev = 0;
        
        for(int i=1; i<n; i++){
            int notPick = prev;
    
            int pick = arr[i] + prevprev;
            
            ans = Math.max(pick, notPick);
            prevprev = prev;
            prev = ans;
        }
        
        return ans;
        
    }
    
}
