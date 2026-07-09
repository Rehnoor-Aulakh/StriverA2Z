package Easy;
import java.util.*;

public class MSS_With_Swaps {
    public static int mssWithSwaps(int n, int k, int[] arr){
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.value-p2.value;
            }
        });
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p2.value-p1.value;
            }
        });

        // l..r numbers from l to r, keep a track of maxSum and runningSum
        int maxSum = 0;
        int runningSum = 0;
        // first push every thing into the maxHeap because I want bigger numbers outside so that I can simulate swaps
        // and I also need to push the indices in the min heap to facilitate the swapping
        for(int i=0; i<n; i++){
            minHeap.add(new Pair(arr[i],i));
        }
        // outer loop from 0 to n-1
        for(int l=0; l<n;l++){
            for(int r = l; r<n; r++){

            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, -8, 2, 5, -1, 5, 10, -1};
        System.out.println(mssWithSwaps(arr.length, 2, arr));
    }
}
