class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true; // Already equal

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // If sorted arrays are not equal, return false
        if (!Arrays.equals(arr1, arr2)) return false;

        // Count mismatches
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) cnt++;
        }
        return cnt <= 2; // At most one swap (2 mismatches)
    }
}