class Solution {
    public boolean hasSameDigits(String s) {
        int n = s.length();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = s.charAt(i) - '0';
        }

        while (n > 2) {
            for (int i = 0; i < n - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            n--;
        }

        return nums[0] == nums[1];
    }
}
