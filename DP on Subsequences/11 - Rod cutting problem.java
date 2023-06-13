public class Solution {

	// public static int helper(int[] price, int ind, int n){

	// 	if(ind == 0){
	// 		return n * price[ind];
	// 	}

	// 	if(dp[ind][n]!=null){
	// 		return dp[ind][n];
	// 	}

	// 	int notPick = helper(price, ind-1, n);

	// 	int pick = Integer.MIN_VALUE;

	// 	int rodLength = ind+1;

	// 	if(n-rodLength>=0){
	// 		pick = price[ind] + helper(price, ind, n-rodLength);
	// 	}

	// 	return dp[ind][n] = Math.max(pick, notPick);

	// }

	// public static Integer[][] dp;

	public static int cutRod(int price[], int n) {

		// ***** Memoization ***** - 

		// dp = new Integer[n][n+1];
		
		// int ans = helper(price, n-1, n);

		// return ans;

		// ***** Tabulation ***** - 

		// int[][] dp = new int[n][n+1];

		// for(int i=0; i<n; i++){
		// 	for(int j=0; j<n+1; j++){
		// 		if(i == 0){
		// 			dp[i][j] = j * price[i];
		// 		}
		// 		else{
		// 			int notPick = dp[i-1][j];

		// 			int pick = Integer.MIN_VALUE;

		// 			int rodLength = i+1;

		// 			if(j-rodLength>=0){
		// 				pick = price[i] + dp[i][j-rodLength];
		// 			}

		// 			dp[i][j] = Math.max(pick, notPick);
		// 		}
		// 	}
		// }

		// return dp[n-1][n];

		// ***** Space Optimized ***** - 

		int[] prev = new int[n+1];

		for(int i=0; i<n; i++){
			int[] curr = new int[n+1];
			for(int j=0; j<n+1; j++){
				if(i == 0){
					curr[j] = j * price[i];
				}
				else{
					int notPick = prev[j];

					int pick = Integer.MIN_VALUE;

					int rodLength = i+1;

					if(j-rodLength>=0){
						pick = price[i] + curr[j-rodLength];
					}

					curr[j] = Math.max(pick, notPick);
				}
			}
			prev = curr;
		}

		return prev[n];

	}

}
