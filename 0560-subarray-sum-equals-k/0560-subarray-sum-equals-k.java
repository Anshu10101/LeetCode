public class Solution {
    public static int subarraySum(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        int preSum = 0, cnt = 0;

        mpp.put(0, 1); // Initialize with prefix sum 0 having one occurrence
        for (int i = 0; i < n; i++) {
            // Add current element to prefix sum
            preSum += arr[i];

            // Calculate the value to find in the map
            int remove = preSum - k;

            // If 'remove' is present in the map, add its count to 'cnt'
            cnt += mpp.getOrDefault(remove, 0);

            // Update the count of 'preSum' in the map
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }
}
