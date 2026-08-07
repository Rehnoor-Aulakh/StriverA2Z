package FAQs;

public class FindPeakElement {
    public int findPeakElement(int[] arr) {
        // return any of the peak element
        int n = arr.length;
        if(n == 1) return 0;
        int low = 0, high = n-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if((mid==0 || arr[mid]>arr[mid-1]) && (mid+1==n || arr[mid]>arr[mid+1])) return mid;
                // if it is increasing
            else if(arr[mid]<=arr[mid+1]) {
                // then the peak would be on the right only
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return low;
    }
}
