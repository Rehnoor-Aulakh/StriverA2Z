public class ReversePairsBrute{
    private static int[] merge(int[] ans, int[] arr1, int[] arr2){
        //before merging check for how many pairs
        int i=0;
        int j=0;
        int len1=arr1.length;
        int len2=arr2.length;
        int right=0;
        for(i=0;i<len1;i++){
            while(right<arr2.length && (long)arr1[i]>2L * arr2[right]){
                right++;
            }
            //when stopped
            ans[0]+=(right);
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
    private static int[] mergeSort(int[] ans, int[] nums, int low, int high){
        //just one element
        if(low==high){
            return new int[]{nums[low]};
        }
        //divide the array recursively
        int mid=(low+high)/2;
        return merge(ans,mergeSort(ans,nums, low,mid),mergeSort(ans,nums,mid+1,high));
    }
    public static int reversePairsOptimized(int[] nums){
        int ans[]=new int[1];
        mergeSort(ans, nums,0,nums.length-1);
        return ans[0];

    }
    public static int reversePairs(int[] nums){
        int n=nums.length;
        int count=0;
        for(int i=0;i<n-1;i++){
            int j=n-1;
            while(i<j && j>0){
                if((long)nums[i]>2L*(long)nums[j]){
                    count++;
                }
                j--;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums={1,3,2,3,1};
        System.out.println(reversePairsOptimized(nums));

    }
}