public class MaxPointsFromCards{
    public int maxScore(int[] cardScore, int k) {
        int lsum=0, rsum=0;
        int maxSum=0;
        for(int i=0;i<k;i++){
            lsum+=cardScore[i];
        }
        maxSum=lsum;
        int rIndex= cardScore.length-1;
        for(int i=k-1;i>=0;i--){
            lsum-=cardScore[i];
            rsum+=cardScore[rIndex--];
            maxSum=Math.max(maxSum, lsum+rsum);
        }
        return maxSum;

    }
    public static void main(String[] args) {
        
    }
}