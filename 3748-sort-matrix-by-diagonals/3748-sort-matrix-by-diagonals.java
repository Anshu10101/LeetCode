public class Solution {
    public static int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        for (int diff = 0; diff < n; diff++) {
            int i = diff, j = 0;
            List<Integer> diagonal = new ArrayList<>();
            while (i < n && j < n) {
                diagonal.add(grid[i][j]);
                i++;
                j++;
            }

            Collections.sort(diagonal, Collections.reverseOrder());

            i = diff;
            j = 0;
            int index = 0;
            while (i < n && j < n) {
                grid[i][j] = diagonal.get(index++);
                i++;
                j++;
            }
        }

        for (int sum = 1; sum < n; sum++) {
            int i = 0, j = sum;
            List<Integer> diagonal = new ArrayList<>();
            while (i < n && j < n) {
                diagonal.add(grid[i][j]);
                i++;
                j++;
            }

            Collections.sort(diagonal);

            i = 0;
            j = sum;
            int index = 0;
            while (i < n && j < n) {
                grid[i][j] = diagonal.get(index++);
                i++;
                j++;
            }
        }

        return grid;
    }
}