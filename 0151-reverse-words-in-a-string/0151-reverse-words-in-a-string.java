class Solution {
    public String reverseWords(String s) {
        // Step 1: Trim leading and trailing spaces and split the string into words
        String[] words = s.trim().split("\\s+"); // Regex "\\s+" handles multiple spaces
        
        // Step 2: Reverse the words array
        int left = 0, right = words.length - 1;
        while (left < right) {
            // Swap words[left] and words[right]
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        
        // Step 3: Join the reversed words with a single space
        return String.join(" ", words);
    }
}
