import java.util.*;

public class Print_prime_numbers_till_N {
    public static ArrayList<Integer> printPrimesTillNOptimal(int n){
        //create an n sized array
        int prime[]= new int[n+1];
        prime[0]=0;
        prime[1]=0;
        for(int i=2;i<=n;i++){
            prime[i]=1;
        }
        for(int i=2; i*i<=n;i++){
            if(prime[i]==1){
                for(int j=i*i;j<=n;j+=i){
                    prime[j]=0;
                }
            }
        }
        ArrayList<Integer> ans= new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(prime[i]==1)
            {
                ans.add(i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        printPrimesTillNOptimal(30);
    }
}
