class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n + 1][amount + 1];

        // Initialize: 0 coins to make positive amount = INF
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = (int) 1e9; // A large number, since Integer.MAX_VALUE can cause overflow
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    // We can take it or leave it (unbounded knapsack)
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][amount] >= (int) 1e9 ? -1 : dp[n][amount];
    }
}
