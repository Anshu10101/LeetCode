class Solution {
    public List<String> commonChars(String[] words) {
        // Step 1: Frequency array for first word
        int[] commonFreq = new int[26];
        Arrays.fill(commonFreq, Integer.MAX_VALUE);

        for (String word : words) {
            int[] wordFreq = new int[26];
            for (char c : word.toCharArray()) {
                wordFreq[c - 'a']++;
            }

            // Step 2: Take min of current word and commonFreq
            for (int i = 0; i < 26; i++) {
                commonFreq[i] = Math.min(commonFreq[i], wordFreq[i]);
            }
        }

        // Step 3: Build result
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (commonFreq[i]-- > 0) {
                result.add(Character.toString((char) (i + 'a')));
            }
        }

        return result;
    }
}
