import java.util.* ;
import java.io.*; 
public class Solution {

	public static int minSubsetSumDifference(int[] arr, int n) {

		// ***** Space Optimized ***** - 

		int total = 0;

		for(int i=0; i<arr.length; i++){
			total += arr[i];
		}
		
		int k = total;
		
		boolean[] next = new boolean[k+1];

        for(int i=arr.length-1; i>=0; i--){
            boolean[] curr = new boolean[k+1];
            for(int j=k; j>=0; j--){
                if(j == 0){
                    curr[j] = true;
                }
                else{
                    if(i == arr.length-1){
                        if(j == arr[i]){
                            curr[j] = true;
                        }
                        else{
                            curr[j] = false;
                        }
                    }
                    else{
                        boolean notPick = next[j];

                        if(notPick){
                            curr[j] = true;
                        }
                        else{
                            boolean pick = false; 

                            if(j-arr[i]>=0){
                                pick = next[j-arr[i]];
                            }

                            if(pick){
                                curr[j] = true;
                            }
                            else{
                                curr[j] = false;
                            }
                        }
                        
                    }
                }
            }
            next = curr;
        }

		int min = Integer.MAX_VALUE;

		for(int i=0; i<=total/2; i++){
			if(next[i]){
				min = Math.min(min, Math.abs((total-i)-i));
			}
		}

		return min;

	}

}
