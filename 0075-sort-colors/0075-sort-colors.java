class Solution {
    public static void sortColors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int didSwap = 0;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    
                    didSwap = 1;
                }
            }
            if(didSwap == 0) break;
        }
    }
}