public class Solution {
   public int majorityElement(int[] nums) {
       HashMap<Integer, Integer> map = new HashMap<>(); 
       int n = nums.length;

       //frequencies of each element
       for (int i = 0; i < n; i++) {
           if(map.containsKey(nums[i])){
               map.put(nums[i], map.get(nums[i])+1);
           }
           else{
              map.put(nums[i], 1);
           }
       }

       // Find the majority element
       for (int key : map.keySet()) {
           if (map.get(key) > n / 2) {
               return key; // Return the key if it's the majority element
           }
       }

       // The problem guarantees that there will always be a majority element, so this return should never be reached
       return -1;
   }
}
