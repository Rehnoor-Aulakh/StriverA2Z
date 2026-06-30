public class MedianMatrix{
    private static int upperBound(int[] nums, int target){
        int low=0;
        int ans=nums.length;
        int high=ans-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>target){
                //it is a possible candidate
                ans=Math.min(ans,mid);
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    private static int blackBox(int[][]matrix, int mid){
        int count=0;
        for(int i=0;i<matrix.length;i++){
            count+=upperBound(matrix[i], mid);
        }
        return count;
    }
    public static int findMedian(int[][] matrix) {
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        //low will be minimum of first column
        //high will be maximum of last column
        int rows=matrix.length;
        int cols=matrix[0].length;
        for(int i=0;i<rows;i++){
            low=Math.min(low,matrix[i][0]);
            high=Math.max(high,matrix[i][cols-1]);
        }
        int target=(rows*cols)/2;
        while(low<=high){
            int mid=(low+high)/2;
            if(blackBox(matrix, mid)>target){
                //it is a possible candidate
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[][] matrix={{1, 4, 9}, {2, 5, 6}, {3, 7, 8} };
        System.out.println(findMedian(matrix));
    }
}