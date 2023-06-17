import java.util.* ;
import java.io.*; 

public class Solution {

	// public static int helper(int[] arr, int ind, int end){

	// 	if(ind == end){
	// 		return 0;
	// 	}

	// 	if(dp[ind][end]!=null){
	// 		return dp[ind][end];
	// 	}

	// 	int min = Integer.MAX_VALUE;

	// 	for(int j=ind; j<=end-1; j++){
	// 		int ans = helper(arr, ind, j) + helper(arr, j+1, end) + arr[ind-1]*arr[j]*arr[end];

	// 		min = Math.min(min, ans);
	// 	}

	// 	return dp[ind][end] = min;

	// }

	// public static Integer[][] dp;

	public static int matrixMultiplication(int[] arr , int N) {

		// ***** Memoization ***** - 

		// dp = new Integer[N][N];
		
		// int ans = helper(arr, 1, arr.length-1);

		// return ans;

		// ***** Tabulation ***** - 

		int[][] dp = new int[N][N];

		for(int i=N-1; i>=1; i--){
			for(int j=i+1; j<N; j++){

				int mini = Integer.MAX_VALUE;
				
				for(int k = i; k<= j-1; k++){
					int ans = dp[i][k]+ dp[k+1][j] + arr[i-1]*arr[k]*arr[j];
					mini = Math.min(mini,ans);
				}
				
				dp[i][j] = mini;
		
			}
		}
		
		return dp[1][N-1];

	}

}
