
import java.util.*;

public class MaxProfitJobScheduling{
    private static void printArray(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int maxTime=-1;
        for(int time: endTime){
            maxTime=Math.max(maxTime,time);
        }
        //I can create a hashmap of endTime, so that if I have to check if endTime is available, I can get that, value will be startTime
        int size=profit.length;
        int[][] map = new int[size][2];
        int mapIndex=0;
        //map[i][0],[1] means ith row of map's startTime and endTime 
        //we need to sort by profit
        int[][] indexedProfit= new int[size][2];
        for(int i=0;i<size;i++){
            indexedProfit[i][0]=i;
            indexedProfit[i][1]=profit[i];
        }
        Arrays.sort(indexedProfit, (a,b)-> b[1]-a[1]);
        //once I have sorted profits in descending order, the next task is to build my solution based on this
        //algo: what I do is I pick out every index in indexedProfit, end its endTime to hashmap key and value will be startTime, first I need to check that the endTime of this index should not be in the range of already allocated, and how do I check that, simply iterate the hashmap key,value pairs and check if the range is unsatisfied
        int maxProfit=0;
        boolean first=true;
        for(int[] row: indexedProfit){
            int index=row[0];
            int prof= row[1];
            //we need to allocate this if available
            //I need to iterate all the map
            //for the first one, just allocate it as it is
            if(first){
                //allocate
                maxProfit+=prof;
                map[mapIndex][0]=startTime[index];
                map[mapIndex][1]=endTime[index];
                mapIndex++;
                first=false;
            }
            else{
                for(int i=0;i<mapIndex;i++){
                    //start time and end time-1 should not overlap of r
                    if((map[i][0]<startTime[index] && map[i][1]<=endTime[index]) ||( map[i][0]>=endTime[index] && map[i][1]>endTime[index])){
                        maxProfit+=prof;
                        map[mapIndex][0]=startTime[index];
                        map[mapIndex][1]=endTime[index];
                        mapIndex++;
                        break;
                    }
                }
            }
            
        }
        return maxProfit;
        
    }
    public static void main(String[] args) {
        System.out.println(jobScheduling(new int[]{1,2,3,3}, new int[]{3,4,5,6}, new int[]{50,10,40,70}));
    }
}