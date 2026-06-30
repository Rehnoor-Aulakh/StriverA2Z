public class Pow_x_n{
    public static double myPow(double x, int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            x=1/x;
            n=-n;
        }
        if(n%2!=0){
            return x*myPow(x,n-1);
        }
        else{
            return myPow(x*x,n/2);
        }
    }
    public static double myPowItr(double x, int n) {
        double ans=1;
        if(n<0){
            x=1/x;
            n=-1*n;
        }
        while(n!=0){
            //when n is odd
            if(n%2!=0){
                //reduce power by 1
                ans=ans*x;
                n--;
            }
            else{
                //when n is even
                x=x*x;
                n=n/2;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(myPow(2, 49));
    }
}