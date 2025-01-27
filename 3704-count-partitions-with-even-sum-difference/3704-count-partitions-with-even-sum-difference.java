class Solution {
    public int countPartitions(int[] nums) {
    
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];

            if ((2 * leftSum) % 2 == totalSum % 2) {
                count++;
            }
        }

        return count;
    }
}
