class Solution {
    public void moveZeroes(int[] nums) {
        int numOfZeroes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numOfZeroes++;
            } else if (numOfZeroes > 0) {
                int x = nums[i];
                nums[i] = 0;
                nums[i - numOfZeroes] = x; //we shift non-zero elements left in one pass. 
                                        // The zeros are naturally pushed to the right because every time
                                        //a swap happens, a zero gets written to nums[i].
            }
        }
    }
}