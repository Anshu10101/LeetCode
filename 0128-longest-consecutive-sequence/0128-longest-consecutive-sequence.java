public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longest = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {// check if there is start of a sequence and if not

                int length = 1; // update the length=1; agar new sequence start hua
                while (numSet.contains(num + length)) {// if hashset contains adjacent number 
                //i.e. num+length(as adding length will ensure we get the adjacent element)
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}