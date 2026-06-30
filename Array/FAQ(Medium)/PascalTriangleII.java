import java.util.*;

public class PascalTriangleII{
    public static int[] pascalTriangleIIOptimized(int r){
        int ans[]= new int[r];
        int t=1;
        ans[0]=1;
        for(int i=1;i<r;i++){
            t*=(r-i);
            t/=i;
            ans[i]=t;
        }
        return ans;
    }
    public static int findNCR(int N, int R){
        int ans=1;
        for(int r=0;r<R;r++){
            ans*=(N-r);
            ans/=(r+1);
        }
        return ans;
    }
    public static int[] pascalTriangleIIBruteForce(int r){
        int ans[]= new int[r];
        for(int i=1;i<=r;i++){
            ans[i-1]=findNCR(r-1,i-1);
        }
        return ans;
    }
    
     public static void main(String[] args) {
        System.out.println(Arrays.toString(pascalTriangleIIOptimized(6)));

    }
}