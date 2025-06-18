class Solution {

    public int lessEqualToK(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }

        int l = 0;
        int r = 0;
        int ans = 0;
        int n = nums.length;
        int sum = 0;

        while (r < n) {
            sum += nums[r];

            while (sum > goal) {
                sum -= nums[l];
                l++;
            }

            ans += (r - l + 1);
            r++;
        }

        return ans;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return lessEqualToK(nums, goal) - lessEqualToK(nums, goal - 1);
    }
}
