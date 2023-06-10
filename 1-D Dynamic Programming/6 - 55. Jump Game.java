class Solution {

    public static boolean helper(int[] nums, int ind){

        if(ind >= nums.length){
            return false;
        }

        if(ind == nums.length-1){
            return true;
        }

        if(dp[ind]!=null){
            return dp[ind];
        }

        for(int i=1; i<=nums[ind]; i++){
            if(ind+i<nums.length && helper(nums, ind+i)){
                return dp[ind] = true;
            }
        }

        return dp[ind] = false;

    }

    public static Boolean[] dp;

    public boolean canJump(int[] nums) {

        dp = new Boolean[nums.length];
        
        boolean ans = helper(nums, 0);

        return ans;

    }

}
