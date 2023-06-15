import java.util.*;
public class Solution {

	public static int longestIncreasingSubsequence(int arr[]) {

		int n = arr.length;

		int[] dp=new int[n];

		Arrays.fill(dp,1);

		int[] hash=new int[n];

		Arrays.fill(hash,1);
		
		for(int i=0; i<=n-1; i++){
			hash[i] = i; 
			for(int prev_index = 0; prev_index <=i-1; prev_index ++){
				if(arr[prev_index]<arr[i] && 1 + dp[prev_index] > dp[i]){
					dp[i] = 1 + dp[prev_index];
					hash[i] = prev_index;
				}
			}
		}
		
		int ans = -1;

		int lastIndex =-1;
		
		for(int i=0; i<=n-1; i++){
			if(dp[i]> ans){
				ans = dp[i];
				lastIndex = i;
			}
		}
		
		ArrayList<Integer> temp=new ArrayList<>();

		temp.add(arr[lastIndex]);
		
		while(hash[lastIndex] != lastIndex){
			lastIndex = hash[lastIndex];
			temp.add(arr[lastIndex]);    
		}
		
		for(int i=temp.size()-1; i>=0; i--){
			System.out.print(temp.get(i)+" ");
		}

		System.out.println();
		
		return ans;

	}

}
