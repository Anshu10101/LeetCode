class Solution {
    public boolean isPalindrome(String s) {

        // Remove all unwanted characters and make the string lowercase for case insensitivity
        String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int low = 0;
        int high = str.length() - 1;

        // Check if the string is a palindrome
        while (low < high) {
            if (str.charAt(low) != str.charAt(high)) { 
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
