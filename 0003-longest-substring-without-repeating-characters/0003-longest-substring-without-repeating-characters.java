class Solution {
    public int lengthOfLongestSubstring(String s) {
        // HashSet to store characters in the current window
        HashSet<Character> set = new HashSet<>();
        int left = 0;  // Left pointer of the sliding window
        int maxLen = 0; // Variable to track the longest substring

        // Iterate over the string with the right pointer
        for (int right = 0; right < s.length(); right++) {
            // If the character is already in the set, move the left pointer
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left)); // Remove character at left pointer
                left++; // Move left pointer to the right
            }

            // Add the current character to the set
            set.add(s.charAt(right));

            // Update the maximum length of substring found
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
