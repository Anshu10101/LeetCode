class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // Put all travel days into a set for quick lookup
        Set<Integer> travel = new HashSet<>();
        for (int d : days) travel.add(d);

        int lastDay = days[days.length - 1];  // maximum travel day
        int[] dp = new int[lastDay + 1];

        for (int i = 1; i <= lastDay; i++) {
            if (!travel.contains(i)) {
                // If today is not a travel day â no extra cost
                dp[i] = dp[i - 1];
            } else {
                // Option 1: Buy 1-day pass
                int one = dp[Math.max(0, i - 1)] + costs[0];
                // Option 2: Buy 7-day pass
                int seven = dp[Math.max(0, i - 7)] + costs[1];
                // Option 3: Buy 30-day pass
                int thirty = dp[Math.max(0, i - 30)] + costs[2];

                dp[i] = Math.min(one, Math.min(seven, thirty));
            }
        }
        return dp[lastDay];
    }
}
