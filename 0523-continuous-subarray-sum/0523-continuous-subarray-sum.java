class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1); // remainder -> index mapping
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            int r = total % k;

            if (r < 0) {
                r += k;
            }

            if (!remainderMap.containsKey(r)) {
                remainderMap.put(r, i);
            } else if (i - remainderMap.get(r) > 1) {
                return true;
            }
        }

        return false;
    }
}
