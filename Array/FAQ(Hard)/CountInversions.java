public class CountInversions{
    private static int[] merge(long[] ans, int[] arr1, int[] arr2){
        //before merging check for how many pairs
        int i=0;
        int j=0;
        int len1=arr1.length;
        int len2=arr2.length;
        while(i<len1 && j<len2){
            if(arr1[i] <= arr2[j]){
                i++;
            }else{
                ans[0]+=(len1-i);
                j++;
            }
        }

        i=0;
        j=0;
        int[] arr= new int[arr1.length+arr2.length];
        int k=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                arr[k]=arr1[i];
                i++;
            }
            else if(arr1[i]>arr2[j]){
                arr[k]=arr2[j];
                j++;
            }
            else{
                arr[k]=arr1[i];
                k++;
                arr[k]=arr2[j];
                i++;
                j++;
            }
            k++;
        }
        while(i!=arr1.length){
                arr[k]=arr1[i];
                i++;
                k++;
            }
        
            while(j!=arr2.length){
                arr[k]=arr2[j];
                j++;
                k++;
            }
        
        return arr;
    }
    private static int[] mergeSort(long[] ans, int[] nums, int low, int high){
        //just one element
        if(low==high){
            return new int[]{nums[low]};
        }
        //divide the array recursively
        int mid=(low+high)/2;
        return merge(ans,mergeSort(ans,nums, low,mid),mergeSort(ans,nums,mid+1,high));
    }
    public static long numberOfInversions(int[] nums){
        //merge sort
        long ans[]=new long[1];
        mergeSort(ans, nums,0,nums.length-1);
        return ans[0];

    }
    public static void main(String[] args) {
        int nums[]={2, 3, 7, 1, 3, 5};
        System.out.println(numberOfInversions(nums));
    }
}