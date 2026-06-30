

public class BookAllocation{
    private static boolean check(int[] nums, int m, int maxPages){
        //just find the count of students that can be allocated mid number of pages
        int pages=0;
        int students=1;
        for(int num: nums){
            if(pages+num>maxPages){
                pages=num;
                students++;
                if(students>m) return false;
            }
            else{
                pages+=num;
            }
        }
        return true;
    }
    public static int findPages(int[] nums, int m) {
        if(m>nums.length) return -1;
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int num: nums){
            low=Math.max(low,num);
            high+=num;
        }
        int ans=-1;
        while(low<=high){
            int mid=(high-low)/2+low;
            if(check(nums,m,mid)){
                //go left
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums={12,34,67,90};
        System.out.println(findPages(nums, 2));
    }
}