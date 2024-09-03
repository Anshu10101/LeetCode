import java.util.*;

class Solution {
    public int thirdMax(int[] nums) {
        // Use a HashSet to store unique elements
        HashSet<Integer> set = new HashSet<>();
        
        // Add all elements of the array to the set
        for (int num : nums) {
            set.add(num);
        }
        
        // Convert the set to a list
        List<Integer> list = new ArrayList<>(set);
        
        // Sort the list in descending order
        Collections.sort(list, Collections.reverseOrder());
        
        // Check if there are at least three distinct numbers
        if (list.size() >= 3) {
            // Return the third maximum number
            return list.get(2);
        } else {
            // Otherwise, return the maximum number
            return list.get(0);
        }
    }
}
