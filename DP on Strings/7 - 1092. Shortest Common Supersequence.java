class Solution {

    public String shortestCommonSupersequence(String str1, String str2) {

        // ***** Tabulation ***** - 
        
        int n = str1.length();
        int m = str2.length();
        
        int[][] t = new int[n+1][m+1];
        
        for(int i=1; i<t.length; i++){
            for(int j=1; j<t[0].length; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        
        int i = n, j = m;
        
        StringBuilder str = new StringBuilder();
        
        while(i > 0 && j > 0 ){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                str.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else{ 
                if(t[i-1][j] > t[i][j-1]){
                    str.append(str1.charAt(i-1));
                    i--;
                }   
                else if(t[i][j-1] >= t[i-1][j]) {
                    str.append(str2.charAt(j-1));
                    j--;
                } 
            }
        }
        
        while(i > 0){
            str.append(str1.charAt(i-1));
            i--;
        }
        
        while(j > 0){
            str.append(str2.charAt(j-1));
            j--;
        }
        
        return str.reverse().toString();
        
    }

}
