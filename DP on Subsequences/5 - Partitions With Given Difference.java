import java.util.* ;
import java.io.*; 
public class Solution {

	// public static int helper(int[] nums, int ind, int target){

	// 	if(ind == 0){
	// 		if(target == 0 && nums[ind] == 0){
	// 			return 2;
	// 		}
	// 		if(target == 0 || nums[ind] == target){
	// 			return 1;
	// 		}
	// 		return 0;
	// 	}

	// 	if(dp[ind][target]!=null){
	// 		return dp[ind][target];
	// 	}

	// 	int notPick = helper(nums, ind-1, target)%1000000007;

	// 	int pick = 0;

	// 	if(target-nums[ind]>=0){
	// 		pick = helper(nums, ind-1, target-nums[ind])%1000000007;
	// 	}

	// 	return dp[ind][target] = (pick + notPick)%1000000007;

	// }

	// public static Integer[][] dp;

	public static int countPartitions(int n, int d, int[] arr) {

		// ***** Memoization ***** - 
	
		// int total = 0;

		// for(int i=0; i<arr.length; i++){
		// 	total += arr[i];
		// }

		// if((total-d)%2!=0 || total-d<0){
		// 	return 0;
		// }

		// int target = (total-d)/2;

		// dp = new Integer[arr.length][target+1];

		// int ans = helper(arr, n-1, target);

		// return ans%1000000007;

		// ***** Tabulation ***** - 

		// int total = 0;

		// for(int i=0; i<arr.length; i++){
		// 	total += arr[i];
		// }

		// if((total-d)%2!=0 || total-d<0){
		// 	return 0;
		// }

		// int target = (total-d)/2;

		// int[][] dp = new int[arr.length][target+1];

		// for(int i=0; i<arr.length; i++){
		// 	for(int j=0; j<target+1; j++){
		// 		if(i == 0){
		// 			if(j == 0 && arr[i] == 0){
		// 				dp[i][j] = 2;
		// 			}
		// 			else if(j == 0 || arr[i] == j){
		// 				dp[i][j] = 1;
		// 			}
		// 			else{
		// 				dp[i][j] = 0;
		// 			}
		// 		}
		// 		else{
		// 			int notPick = (dp[i-1][j])%1000000007;

		// 			int pick = 0;

		// 			if(j-arr[i]>=0){
		// 				pick = (dp[i-1][j-arr[i]])%1000000007;
		// 			}

		// 			dp[i][j] = (pick + notPick)%1000000007;
		// 		}
		// 	}
		// }

		// return dp[n-1][target];

		// ***** Space Optimized

		int total = 0;

		for(int i=0; i<arr.length; i++){
			total += arr[i];
		}

		if((total-d)%2!=0 || total-d<0){
			return 0;
		}

		int target = (total-d)/2;

		int[] prev = new int[target+1];

		for(int i=0; i<arr.length; i++){
			int[] curr = new int[target+1];
			for(int j=0; j<target+1; j++){
				if(i == 0){
					if(j == 0 && arr[i] == 0){
						curr[j] = 2;
					}
					else if(j == 0 || arr[i] == j){
						curr[j] = 1;
					}
					else{
						curr[j] = 0;
					}
				}
				else{
					int notPick = (prev[j])%1000000007;

					int pick = 0;

					if(j-arr[i]>=0){
						pick = (prev[j-arr[i]])%1000000007;
					}

					curr[j] = (pick + notPick)%1000000007;
				}
			}
			prev = curr;
		}

		return prev[target];

	}

}
