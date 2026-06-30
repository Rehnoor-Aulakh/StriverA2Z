import java.util.*;

public class SumOfSubarrayMinimums {
    public static int[] findPSEE(int[] arr){
        //I want the previous smaller or equal element
        //So I want info of the front
        Stack<Integer> st= new Stack<>();
        int n=arr.length;
        int[] psee= new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && st.peek()>arr[i]){
                st.pop();
            }
            psee[i]=st.isEmpty()?-1: st.peek();
            st.push(arr[i]);
        }
        return psee;
    }
    public static int[] findNSE(int[] arr){
        //I want to find the next smaller element
        Stack<Integer> st = new Stack<>();
        //I want info of the end first, so start from the end
        int n= arr.length;
        int[] nse= new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()>= arr[i]){
                st.pop();
            }
            nse[i]= st.isEmpty()?n:st.peek();
            st.push(arr[i]);
        }
        return nse;
    }
    public static int sumSubarrayMins(int[] arr){
        int[] nse= findNSE(arr);
        int[] psee= findPSEE(arr);
        double mod= Math.pow(10,9)+7;
        double total=0;
        for(int i=0;i<arr.length;i++){
            total=(total+ ((i-psee[i])*(nse[i]-i))%mod)%mod;
        }
        return (int) total;
    }
    public static int sumSubarrayMinsBruteForce(int[] arr) {
        double mod= Math.pow(10,9)+7;
        int n=arr.length;
        double sum=0;
        for(int i=0;i<n;i++){
            int min= arr[i];
            for(int j=i;j<n;j++){
                min=Math.min(min,arr[j]);
                sum= ((sum+min)%mod);
            }
        }
        return (int)sum;
    }
    public static void main() {
        System.out.println(sumSubarrayMins(new int[]{1,4,6,7,3,7,8,1}));
    }
}
