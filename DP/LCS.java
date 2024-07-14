package DP;

/*Longest common Subsequence 
 LEETCODE - 1143* 
*/
public class LCS {

    public static void main(String[] args) {

        String text1 = "abcde";
        String text2 = "ace";

        int resultNoDP = longestCommonSubsequenceNoDP(text1, text2);
        System.out.println(resultNoDP);

        int result = longestCommonSubsequence(text1, text2);
        System.out.println("Result with DP : "+result);
    }

    public static int longestCommonSubsequenceNoDP(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        return lcsNoDP(m, n, text1, text2);
    }

    public static int lcsNoDP(int m, int n, String text1, String text2)  {

        //If either of text pair doesn't have any element
        if (m==0 || n==0) {
            return 0;
        }

        /*If last element of both of the strings are same, 
        then drop the last element and repeat for rest of the string
        Add 1 to the remaining calculation*/

        if (text1.charAt(m-1) == text2.charAt(n-1)) {
            return 1 + lcsNoDP(m-1, n-1, text1, text2);
        } else {    //Else process two branches, 1. drop last element from first string, 2. drop last element from second string, then return the max from both
            return Math.max(lcsNoDP(m-1, n, text1, text2), lcsNoDP(m, n-1, text1, text2));
        }
    }

    /*With Memorisation support - DP */
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1];  // matrix, with all -1, with 0th row and 0th column with 0
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                dp[i][j] = -1;
            }
        }
        return lcs(m, n, text1, text2, dp);
    }

    public static int lcs(int m, int n, String text1, String text2, int[][] dp) {

        if (m==0 || n==0) {
            return 0;
        }
        if (dp[m][n] != -1) {    //if result is available, return it from the dp matrix
            return dp[m][n];
        }

        if (text1.charAt(m-1) == text2.charAt(n-1)) {
            dp[m][n] = 1 + lcs(m-1, n-1, text1, text2, dp);
            return dp[m][n];
        } else {
            dp[m][n] = Math.max(lcs(m-1, n, text1, text2, dp),
            lcs(m, n-1, text1, text2, dp));
            return dp[m][n];
        }
    }    
}