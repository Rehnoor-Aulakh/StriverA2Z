import java.util.Arrays;

public class MergeSort {
    private int[] merge(int[] arr1, int[] arr2){
        int i=0, j=0;
        int size1= arr1.length, size2 = arr2.length;
        int k=0;
        int[] ans= new int[size1+size2];
        while(i<size1 && j<size2){
            if(arr1[i]<arr2[j]){
                ans[k] = arr1[i++];
            }
            else{
                ans[k] = arr2[j++];
            }
            k++;
        }
        while(i<size1){
            ans[k++] = arr1[i++];
        }
        while(j<size2){
            ans[k++] = arr2[j++];
        }
        return ans;
    }
    private int[] split(int[] arr, int low, int high){
        if(low==high) return new int[]{arr[low]};
        int mid = (low+high)/2;
        return merge( split(arr, low, mid) , split(arr, mid+1, high));
    }
    public int[] mergeSort(int[] arr) {
        return split(arr, 0, arr.length-1);
    }

    static void main() {
        MergeSort obj = new MergeSort();
        System.out.println(Arrays.toString(obj.mergeSort(new int[]{7,1, 5, 4,2})));
    }
}
