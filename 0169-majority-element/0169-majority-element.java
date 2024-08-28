public class Solution {
   public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int majorityCount = nums.length / 2;

        // Iterate through the array and count frequencies
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

            // Check if this element is the majority element
            if (countMap.get(num) > majorityCount) {
                return num;
            }
        }

        // The problem guarantees that there will always be a majority element,
        // so this return statement should never be reached.
        return -1; 
    } 
}