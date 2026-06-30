import java.util.*;

public class SumOfSubarrayRanges {
    private  int[] findNGE(int[] arr){
        //next greater element, we need info about the end
        int n=arr.length;
        int nge[]= new int[n];
        Stack<Integer> st= new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                st.pop();
            }
            nge[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nge;
    }

    private  int[] findPGE(int[] arr){
        Stack<Integer> st= new Stack<>();
        int n=arr.length;
        int pge[]= new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            pge[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pge;
    }

    private  long findSubarrayMaximumSum(int[] arr){
        long ans=0;
        int[] nge= findNGE(arr);
        int[] pge= findPGE(arr);
        for(int i=0;i<arr.length;i++){
            ans += (long)(nge[i] - i) * (i - pge[i]) * arr[i];

        }
        return ans;
    }
    public  int[] findPSEE(int[] arr){
        //I want the previous smaller or equal element
        //So I want info of the front
        Stack<Integer> st= new Stack<>();
        int n=arr.length;
        int[] psee= new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            psee[i]=st.isEmpty()?-1: st.peek();
            st.push(i);
        }
        return psee;
    }
    public  int[] findNSE(int[] arr){
        //I want to find the next smaller element
        Stack<Integer> st = new Stack<>();
        //I want info of the end first, so start from the end
        int n= arr.length;
        int[] nse= new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>= arr[i]){
                st.pop();
            }
            nse[i]= st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nse;
    }
    public  long sumSubarrayMins(int[] arr){
        int[] nse= findNSE(arr);
        int[] psee= findPSEE(arr);
        long total=0;
        for(int i=0;i<arr.length;i++){
            total+=(long)(nse[i]-i)*(i-psee[i])*arr[i];
        }
        return total;
    }
    public  long subArrayRanges(int[] arr) {
        return findSubarrayMaximumSum(arr)-sumSubarrayMins(arr);
    }
}
