import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Step 1: Create an array of pairs to keep track of the original indices
        int[][] pair = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            pair[i][0] = nums[i]; // store the number
            pair[i][1] = i;       // store the original index
        }

        // Step 2: Sort the pair array based on the number values
        Arrays.sort(pair, Comparator.comparingInt(a -> a[0]));

        // Step 3: Two-pointer approach to find the two numbers
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int sum = pair[l][0] + pair[r][0];
            if (sum == target) {
                // Return the original indices of the two numbers
                return new int[] { pair[l][1], pair[r][1] };
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }

        // If no solution is found, return an empty array or any error code
        return new int[] { -1, -1 };
    }
}
