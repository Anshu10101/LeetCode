import java.util.*;

public class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 1)
            return points.length;

        int maxPoints = 1;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeCount = new HashMap<>();
            int duplicates = 0;
            int localMax = 0;

            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    duplicates++;
                    continue;
                }

                int gcd = getGCD(dx, dy);
                dx /= gcd;
                dy /= gcd;

                // Handle -ve slope consistently
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                }

                String slope = dx + "_" + dy;
                slopeCount.put(slope, slopeCount.getOrDefault(slope, 0) + 1);
                localMax = Math.max(localMax, slopeCount.get(slope));
            }

            maxPoints = Math.max(maxPoints, localMax + duplicates + 1);
        }

        return maxPoints;
    }

    private int getGCD(int a, int b) {
        if (b == 0)
            return a;
        return getGCD(b, a % b);
    }
}
