class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> countGap = new HashMap<>();

        for (List<Integer> row : wall) {
            int total = 0;
            // Skip the last brick to avoid the edge of the wall
            for (int i = 0; i < row.size() - 1; i++) {
                total += row.get(i);
                countGap.put(total, countGap.getOrDefault(total, 0) + 1);
            }
        }

        int maxGaps = 0;
        for (int gapCount : countGap.values()) {
            maxGaps = Math.max(maxGaps, gapCount);
        }

        return wall.size() - maxGaps;
    }
}
