package Implementation;

public class Pow {
    public double myPow(double x, long n) {
        if(n==0) return 1;
        if(n==1) return x;
        if(x==0 || x==1) return x;
        if(n%2==0) return myPow(x*x , n/2);
        else return x* myPow(x, n-1);
    }
    public double myPow(double x, int n) {
        long num = n;
        if(num<0) {
            return myPow(1/x, -num);
        }
        return myPow(x,num);
    }
}
