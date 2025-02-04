class Solution {
    public int maxAscendingSum(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0; 

        int maxSum = nums[0]; 
        int currentSum = nums[0]; 

        for (int i = 1; i < length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentSum += nums[i];
            } else {
                currentSum = nums[i]; 
            }
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}