class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2]; // initial sum

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                // update if this sum is closer to target
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }

                if (sum < target) {
                    j++; // need a larger sum
                } else if (sum > target) {
                    k--; // need a smaller sum
                } else {
                    return sum; // perfect match
                }
            }
        }

        return closest;
    }
}
