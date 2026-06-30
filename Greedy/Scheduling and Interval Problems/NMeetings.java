import java.util.*;

public class NMeetings{
    public int maxMeetings(int[] start, int[] end) {
       List<int[]> meetings = new ArrayList<>();
       int size=start.length;
       for(int i=0;i<size;i++){
        meetings.add(new int[]{start[i],end[i]});
       }
       //now sort the arraylist based upon the difference
        Collections.sort(meetings, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[1]>b[1]){
                    return 1;
                }
                return -1;
            }
        });
        //then we need to go on allocating the meetings
        int maxMeetings= 0;
        int limit=-1;
        for(int[] meeting: meetings){
            if(meeting[0]>limit){
                maxMeetings++;
                limit=meeting[1];
            }
        }
        return maxMeetings;

    }
    public static void main(String[] args) {
        
    }
}