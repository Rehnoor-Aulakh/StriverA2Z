public class RotateArrayKTimes{
    public static void rotateArray(int[] nums, int k) {
        k=k%nums.length;
        //first we need to store the first k indices i.e 0 to k-1 in a temporary array and then shift the ith index from k to i-k
        int[] temp=new int[k];
        for(int i=0;i<k;i++){
            temp[i]=nums[i];
        }
        for(int i=k;i<nums.length;i++){
            nums[i-k]=nums[i];
        }
        //now copy the temp array back, from nums.length-k to nums.length
        int j=0;
        for(int i=nums.length-k;i<nums.length;i++){
            nums[i]=temp[j++];
        }

    }
    public void reverse(int[] nums, int l, int h){
        //reverse from l to h
        while(l<h){
            int t=nums[l];
            nums[l]=nums[h];
            nums[h]=t;
            l++;
            h--;
        }
    }
    public void rotateArrayOptimized(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        reverse(nums,0,nums.length-1);
        
    }
    public static void main(String[] args) {
        
    }
}