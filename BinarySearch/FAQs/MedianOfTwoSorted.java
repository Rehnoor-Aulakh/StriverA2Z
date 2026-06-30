public class MedianOfTwoSorted{
    public static double median(int[] arr1, int[] arr2) {
        int n1=arr1.length;
        int n2=arr2.length;
        //I want the binary search on shorted array for lesser time
        if(n1>n2){
            //clever approach
            return median(arr2,arr1);
        }
        //now arr1 is always the smaller one
        //high is the smaller array's size, since the maximum I can pick from arr1
        int low=0;
        int high=n1;
        int left=(n1+n2+1)/2;
        
        while(low<=high){
            int mid1=(low+high)/2;
            int mid2= left-mid1;
            int l1= Integer.MIN_VALUE, l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE, r2=Integer.MAX_VALUE;
            if(mid1<n1){
                r1=arr1[mid1];
            }
            if(mid2<n2){
                r2=arr2[mid2];
            }
            if(mid1-1>=0){
                l1=arr1[mid1-1];
            }
            if(mid2-1>=0){
                l2=arr2[mid2-1];
            }
            //now just need to figure out where to go
            if(l1<=r2 && l2<=r1){
                if((n1+n2)%2==1){
                    return Math.max(l1,l2);
                }
                else{
                    //return average 
                    return (double)(Math.max(l1,l2)+Math.min(r1, r2))/2.0;
                }
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
    public static double medianLinear(int[] arr1, int[] arr2) {
        int n=arr1.length;
        int m=arr2.length;
        int curr=0;
        int prev=0;
        int left=0;
        int right=0;
        for(int i=0;i<=(n+m)/2;i++){
            prev=curr;
            //take from arr1 if it is smaller, or if right is exhausted
            if(left<n && (right>=m || arr1[left]<=arr2[right])){
                curr=arr1[left++];
            }
            else{
                curr=arr2[right++];
            }
        }
        if((n+m)%2==0){
            return ((double)curr+(double)prev)/2;
        }
        else{
            return (double)curr;
        }
    }
    public static void main(String[] args) {
        int[] arr1={2, 4, 6};
        int[] arr2={1, 3, 4};
        System.out.println(median(arr1, arr2));
    }
}