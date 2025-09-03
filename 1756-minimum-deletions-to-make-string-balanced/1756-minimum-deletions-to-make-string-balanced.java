class Solution {
    public int minimumDeletions(String s) {
        int countB = 0; // count of 'b' seen so far
        int deletions = 0; // min deletions so far

        for (char ch : s.toCharArray()) {
            if (ch == 'b') {
                countB++;
            } else { // ch == 'a'
                // Option 1: delete this 'a' (deletions + 1)
                // Option 2: delete a previous 'b' (countB)
                deletions = Math.min(deletions + 1, countB);
            }
        }
        return deletions;
    }
}
