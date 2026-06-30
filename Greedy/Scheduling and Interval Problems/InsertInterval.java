import java.util.*;

public class InsertInterval{
    public int[][] insert(int[][] intervals, int[] newInterval){
        List<int[]> list = new ArrayList<>();
        int i=0;
        int n= intervals.length;
        //safe case and all intervals are before this interval
        while(i<n && intervals[i][1]<newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        //merge all overlapping intervals
        while(i<n && intervals[i][0]<=newInterval[1]){
            //if newIntervals's end is greater than start of current interval,
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);
        while(i<n){
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][]);
        
    }
}