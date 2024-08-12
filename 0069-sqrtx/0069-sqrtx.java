class Solution {
    public int mySqrt(int n) {
        int low = 1;
        int high = n;
        while (low<=high){
            long mid = low +(high-low)/2;
            long val = mid*mid;
            if(val>(long)(n)){
                high =(int) mid-1;
            }
            else {

                low =(int) mid +1 ;
            }
        }
        return low-1;
    }
}