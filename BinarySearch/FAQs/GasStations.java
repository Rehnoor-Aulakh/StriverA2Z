
import java.util.PriorityQueue;

public class GasStations{
    private static int countOfGasStations(int[] arr, double mid){
        int count=0;
        for(int i=1;i<arr.length;i++){
            if((arr[i]-arr[i-1])%mid==0){
                //if it is properly divisible
                count+=((arr[i]-arr[i-1])/mid)-1;
            }
            else{
                count+=((arr[i]-arr[i-1])/mid);
            }
        }
        return count;
    }
    public static double minimiseMaxDistance(int[] arr, int k){
        double low=0;
        double high= Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++){
            high=Math.max(high,arr[i]-arr[i-1]);
        }
        while(high-low>Math.pow(10,-6)){
            double mid=(low+high)/2.0;
            int count=countOfGasStations(arr,mid);
            if(count>k) low=mid;
            else high=mid;
        }
        return high;
    }
    public static double minimiseMaxDistancePQ(int[] arr, int k) {
        int n=arr.length;
        int[] howMany= new int[n-1];
        //MaxHeap of double[]: [distance,sectionIndex]
        PriorityQueue<double[]> maxHeap= new PriorityQueue<>((a,b)->Double.compare(b[0], a[0]));
        for(int i=0;i<n-1;i++){
            double dist= arr[i+1]-arr[i];
            maxHeap.add(new double[]{dist,i});
        }
        for(int gasStation=1;gasStation<=k;gasStation++){
            double[] top= maxHeap.poll();
            int sectionIndex= (int)top[1];
            howMany[sectionIndex]++;
            double initialDistance=arr[sectionIndex+1]-arr[sectionIndex];
            double newSectionLen= initialDistance/(howMany[sectionIndex]+1);
            maxHeap.add(new double[]{newSectionLen,sectionIndex});
        }
        return maxHeap.peek()[0];
    }
    public static void main(String[] args) {
        int arr[]={1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k=1;
        System.out.println(minimiseMaxDistance(arr, k));
    }
}