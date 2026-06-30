public class NthRoot{
    private static int func(int mid, int N, int n){
        long ans=1;
        for(int i=1;i<=N;i++){
            ans=ans*mid;
            if(ans>n) return 2;
        }
        if(ans==n) return 1;
        else return 0;
    }
    public static int NthRoot(int N, int n) {
        if(n==0) return 0;
        int low=1;
        int high=n;
        while(low<=high){
            int mid=(high-low)/2+low;
            int pow=func(mid, N, n);
            if(pow==1){
                return mid;
            }
            else if(pow==2){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(NthRoot(10, 100000000));
    }
}