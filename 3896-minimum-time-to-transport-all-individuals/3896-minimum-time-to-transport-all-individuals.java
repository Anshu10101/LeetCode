import java.util.*;

public class Solution {
    private double[][][][] dp = new double[4096][5][2][4];
    private int[] maxTime = new int[4096];

    private double dfs(int mask, int st, int across, int singles, int k, int m, int[] time, double[] mul) {
        if (mask == 0)
            return 0;

        if (singles > 3)
            return Double.MAX_VALUE;

        if (dp[mask][st][across][singles] == 0) {
            double res = Double.MAX_VALUE;

            if (across == 0) {
                for (int i = 1; i <= mask; i++) {
                    if ((i & mask) == i && Integer.bitCount(i) <= k) {
                        if (maxTime[i] == 0) {
                            for (int j = 0; j < time.length; j++) {
                                if (((1 << j) & i) != 0) {
                                    maxTime[i] = Math.max(maxTime[i], time[j]);
                                }
                            }
                        }

                        double took = mul[st] * maxTime[i];
                        int nextSt = (st + (int) Math.floor(took)) % m;

                        res = Math.min(res, took + dfs(mask - i, nextSt, 1,
                                singles + (Integer.bitCount(i) == 1 ? 1 : 0), k, m, time, mul));
                    }
                }
            } else {
                for (int i = 0; i < time.length; i++) {
                    if (((1 << i) & mask) == 0) {
                        double took = mul[st] * time[i];
                        int nextSt = (st + (int) Math.floor(took)) % m;

                        res = Math.min(res, took + dfs(mask + (1 << i), nextSt, 0, singles, k, m, time, mul));
                    }
                }
            }

            dp[mask][st][across][singles] = res;
        }

        return dp[mask][st][across][singles];
    }

    public double minTime(int n, int k, int m, int[] time, double[] mul) {
        if (k == 1 && n > 1)
            return -1;

        int fullMask = (1 << n) - 1;
        return dfs(fullMask, 0, 0, 0, k, m, time, mul);
    }
}
