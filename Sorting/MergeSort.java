import java.util.*;

public class MergeSort{
    public static int[] merge(int[] arr1, int[] arr2){
        //this function will merge the given 2 arrays into one single array
        int[] arr= new int[arr1.length+arr2.length];
        int i=0,j=0;
        int k=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                arr[k]=arr1[i];
                i++;
            }
            else if(arr2[j]<arr1[i]){
                arr[k]=arr2[j];
                j++;
            }
            else{
                arr[k]=arr1[i];
                k++;
                arr[k]=arr2[j];
                i++;
                j++;
            }
            k++;
        }
        //at the end, one of them would have data left, copy it as it is
            while(i!=arr1.length){
                arr[k]=arr1[i];
                i++;
                k++;
            }
        
            while(j!=arr2.length){
                arr[k]=arr2[j];
                j++;
                k++;
            }
        
        return arr;
    }
    public static int[] mergeSort(int[] arr, int low, int high){
        //you are at just one element
        if(low==high){
            return new int[]{arr[low]};
        }
        //this function would divide the array into 2 halves
        //recursive function
        int mid=(low+high)/2;
        return merge(mergeSort(arr,low,mid),mergeSort(arr,mid+1,high));
    }
    public static int[] mergeSort(int[] arr){
        return mergeSort(arr,0,arr.length-1);
        
    }
     public static void main(String[] args) {
        int arr[]={5,2,3,6,1,4};
        System.out.println(Arrays.toString(mergeSort(arr)));

    }
}