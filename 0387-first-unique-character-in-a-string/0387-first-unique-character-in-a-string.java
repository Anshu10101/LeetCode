import java.util.HashMap;
import java.util.Map;

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int uniqueIdx = 0;

        // Count frequencies
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Find the first unique character
        while (uniqueIdx < s.length() && freqMap.get(s.charAt(uniqueIdx)) > 1) {
            uniqueIdx++;
        }

        return (uniqueIdx == s.length()) ? -1 : uniqueIdx;
    }
}
