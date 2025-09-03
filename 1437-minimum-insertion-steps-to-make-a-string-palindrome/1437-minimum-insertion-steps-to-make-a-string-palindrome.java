class Solution {
    // LCS code
    private static int LCS(String a, String b, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    // LPS code
    private int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String rev = sb.toString();

        return LCS(s, rev, s.length(), rev.length());
    }

    // Minimum Insertions to make palindrome
    int minInsertions(String s) {
        int n = s.length();
        int lps = longestPalindromeSubseq(s);
        return n - lps;
    }
}
