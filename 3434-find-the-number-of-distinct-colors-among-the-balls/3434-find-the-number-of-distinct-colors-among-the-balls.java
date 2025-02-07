import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        Map<Integer, Integer> colorFreq = new HashMap<>(); // Frequency of each color
        Map<Integer, Integer> ballColor = new HashMap<>(); // Color of each ball
        int[] res = new int[n]; // Use an array instead of a List

        for (int i = 0; i < n; ++i) {
            int ball = queries[i][0];
            int color = queries[i][1];

            // If the ball was already painted, remove its previous color
            if (ballColor.containsKey(ball)) {
                int prevColor = ballColor.get(ball);
                colorFreq.put(prevColor, colorFreq.get(prevColor) - 1); // Reduce frequency
                if (colorFreq.get(prevColor) == 0) {
                    colorFreq.remove(prevColor); // Remove if frequency becomes 0
                }
            }

            // Paint the ball with the new color
            ballColor.put(ball, color);
            colorFreq.put(color, colorFreq.getOrDefault(color, 0) + 1);

            // Add the number of distinct colors to the result
            res[i] = colorFreq.size();
        }

        return res;
    }
}