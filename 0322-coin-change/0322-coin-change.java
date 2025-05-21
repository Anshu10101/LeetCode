class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // Initialize all values to a large number
        Arrays.fill(dp, (int)1e9);
        dp[0] = 0; // Base case: 0 coins to make amount 0

        // Build the DP array
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], 1 + dp[j - coin]);
            }
        }

        return dp[amount] >= (int)1e9 ? -1 : dp[amount];
    }
}
