public class SquareRoot{
    public static int floorSqrt(int n){
        if(n==0) return 0;
        int low=1;
        int high=n;
        int ans=1;
        while(low<=high){
            int mid=(high-low)/2+low;
            //because mid*mid can overflow
            if(mid<=n/mid){
                ans=mid;
                //IT IS A POSSIBLE CANDIDATE
                //go right
                //because we need the largest
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(floorSqrt(28));
    }
}