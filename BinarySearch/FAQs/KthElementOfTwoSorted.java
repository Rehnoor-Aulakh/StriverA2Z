public class KthElementOfTwoSorted{
    public static int kthElement(int[] arr1, int[] arr2, int k) {
        int n=arr1.length;
        int m=arr2.length;
        if(n>m){
            return kthElement(arr2, arr1, k);
        }
        int low=0;
        int high=n;
        int left=k;
        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=left-mid1;
            int l1=Integer.MIN_VALUE;
            int l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE;
            int r2=Integer.MAX_VALUE;
            //assign l1,l2,r1,r2
            if(mid1-1>=0){
                l1=arr1[mid1-1];
            }
            if(mid1<n){
                r1=arr1[mid1];
            }
            if(mid2-1>=0){
                l2=arr2[mid2-1];
            }
            if(mid2<m){
                r2=arr2[mid2];
            }
            //check condition
            if(l1<=r2 && l2<=r1){
                return Math.max(l1,l2);
            }
            else if(l1>r2){
                high=mid1-1;
            }
            else{
                low=mid1+1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int arr1[]={2, 3, 6, 7, 9};
        int arr2[]={1, 4, 8, 10};
        System.out.println(kthElement(arr1,arr2,5));
    }
}