class Solution {
    public int subarraySum(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int ans = 0;
        int sum = 0;
        for(int j=0; j<arr.length; j++){
            sum+= arr[j];

            if(map.containsKey(sum-k)){
                ans += map.get(sum-k);
            }
            if(map.containsKey(sum)){
                map.put(sum, map.get(sum)+1);
            }
            else{
                map.put(sum, 1);
            }
        }
        return ans;
    }
}