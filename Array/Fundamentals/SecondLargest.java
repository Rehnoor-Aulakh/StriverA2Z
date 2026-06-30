public class SecondLargest{
    public static int secondLargest(int[] nums){
        int max=Integer.MIN_VALUE;
        int secMax=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                secMax=max;
                max=nums[i];
            }
            //when element is smaller than max but larger than secMax
            else if(nums[i]<max && nums[i]>secMax){
                secMax=nums[i];
            }
        }
        return secMax;
    }
    public static void main(String[] args) {
        int arr[]={8, 8, 7, 6, 5};
        System.out.println(secondLargest(arr));

    }
}