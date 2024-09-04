class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum =0, rsum =0, max =0,sum =0;
        int n = cardPoints.length;
        for(int i=0;i<k;i++){
            lsum = lsum + cardPoints[i];
        }
        max = lsum;
        for (int i = 0; i < k; i++) {
            lsum -= cardPoints[k-1-i];
            rsum += cardPoints[cardPoints.length -1-i];
            sum = lsum+rsum;
            if(sum>max){
                max = sum;
            }
        }
        return max;
    }
}