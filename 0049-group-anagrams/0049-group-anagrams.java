class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(); 

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars); 
            String sortedWord = new String(chars); // storing the sorted words as key in mp

            if (!map.containsKey(sortedWord)) { //verifying if it's in the mp or not
                map.put(sortedWord, new ArrayList<>()); // putting the word in arraylist
            }

            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values()); //Returns a Collection view of the values contained in this map.
    }
}