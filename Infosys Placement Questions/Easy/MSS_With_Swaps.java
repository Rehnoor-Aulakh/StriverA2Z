package Easy;
import java.util.*;

public class MSS_With_Swaps {
    // O(N^2 logN)
    public static int mssWithSwapsOptimized(int n, int k, int[] arr){
        int maxSum = Integer.MIN_VALUE;

        for(int l=0;  l<n; l++){
            // OPTIMIZATION- REBUILD FRESH FOR EACH LEFT BOUNDARY BASELINE
            PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> (a.value-b.value));
            PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) -> (b.value-a.value));

            boolean[] insideWindow = new boolean[n];
            int runningSum = 0;

            // initially the window is empty, so it is outside the maxHeap
            for(int i=0;i<n;i++){
                maxHeap.add(new Pair(arr[i],i));
            }
//            [l..r]
            for(int r = l; r<n; r++){
                // expanding the right boundary step by step
                runningSum+=arr[r];
                insideWindow[r] = true;
                minHeap.add(new Pair(arr[r], r));

                PriorityQueue<Pair> tempMin = new PriorityQueue<>(minHeap);
                PriorityQueue<Pair> tempMax = new PriorityQueue<>(maxHeap);

                int currentSum = runningSum;

                for(int i=0; i<k; i++){
                    // using lazy deletion optimization
                    // if there is any element that belongs to both the window and in the tempMax, remove it from the tempMax - and we do this locally
                    // so this does not change the outer loop's state
                    while(!tempMax.isEmpty() && insideWindow[tempMax.peek().index]){
                        tempMax.poll();
                    }

                    if(tempMin.isEmpty() || tempMax.isEmpty()) break;

                    Pair mini = tempMin.peek();
                    Pair maxi = tempMax.peek();

                    if(mini.value>=maxi.value) break;

                    tempMax.poll();
                    tempMin.poll();

                    currentSum -= mini.value;
                    currentSum +=maxi.value;

                }
                maxSum = Math.max(maxSum, currentSum);

            }

        }
        return maxSum;
    }
    // O(N^3 logN)
    public static int mssWithSwaps(int n, int k, int[] arr){


        // l..r numbers from l to r, keep a track of maxSum and runningSum
        int maxSum = Integer.MIN_VALUE;
        // first push every thing into the maxHeap because I want bigger numbers outside so that I can simulate swaps
        // outer loop from 0 to n-1
        for(int l=0; l<n;l++){
            for(int r = l; r<n; r++){
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
                int runningSum = 0;
                for(int i=0;i<n; i++){
                    if(i>=l && i<=r){
                        runningSum+=arr[i];
                        minHeap.add(new Pair(arr[i],i));
                    }else{
                        maxHeap.add(new Pair(arr[i], i));
                    }
                }

                for(int i=0;i<k;i++){
                    if(minHeap.isEmpty() || maxHeap.isEmpty()) break;

                    Pair mini = minHeap.poll();
                    Pair maxi = maxHeap.poll();

                    if(mini.value>=maxi.value) break;

                    runningSum-=mini.value;
                    runningSum+=maxi.value;
                }

                    maxSum = Math.max(maxSum, runningSum);
                }
            }

        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, -5, 2};
        System.out.println(mssWithSwapsOptimized(arr.length, 1, arr));
    }
}
