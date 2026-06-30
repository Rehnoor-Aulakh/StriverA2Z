import java.util.*;

public class AmountOfNewAreaPaintedEachDay {
    public static List<Integer> amountPainted(int[][] paint) {
        int[] track = new int[5*10000];
        List<Integer> result = new ArrayList<>();
        // initially everything is marked as 0, we have to iterate the paint array
        for(int[] curr : paint){
            int ans = 0;
            int start= curr[0];
            int end= curr[1];
            while(start<end){
                if(track[start]==0){
                    // this is unvisited
                    ans++;
                    track[start]= end;
                    start++;
                }
                else{
                    // this is already visited, so just move it to the end marked in the track
                    start = track[start];
                }
            }
            result.add(ans);
        }
        return result;
    }

}
