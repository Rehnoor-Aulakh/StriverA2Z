import java.util.*;

//Always sort by end time in maximum meeting and interval scheduling problems
public class NonOverlappingIntervals{
    public int eraseOverlapIntervals(int[][] intervals) {
        //sort by end time
        Arrays.sort(intervals, (a,b)-> a[1]-b[1]);
        int lastEndTime= intervals[0][1];
        int count=0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<lastEndTime){
                count++;
            }
            else{
                lastEndTime=intervals[i][1];    
            }
                
        }
        return count;
    }
    public static void main(String[] args) {
        
    }
}