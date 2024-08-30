class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        // Calculate the total number of candies for Alice and Bob
        int sumAlice = 0, sumBob = 0;
        for (int num : aliceSizes) {
            sumAlice += num;
        }
        for (int num : bobSizes) {
            sumBob += num;
        }
        
        // Calculate the delta (difference divided by 2)
        int delta = (sumAlice - sumBob) / 2;
        
        // Store all candy sizes of Bob in a HashSet for quick lookup
        HashSet<Integer> bobSet = new HashSet<>();
        for (int num : bobSizes) {
            bobSet.add(num);
        }
        
        // Find the correct pair (x, y) such that x - y = delta
        for (int x : aliceSizes) {
            int y = x - delta;
            if (bobSet.contains(y)) {
                return new int[]{x, y};
            }
        }
        
        // No answer found (though the problem guarantees that one exists)
        return new int[]{};
    }
}