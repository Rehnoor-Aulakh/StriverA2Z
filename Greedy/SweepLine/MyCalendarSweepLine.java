package SweepLine;
import java.util.*;

public class MyCalendarSweepLine {
    TreeMap<Integer,Integer> map = new TreeMap<>();
    int numberMeetingsAllowed=2;

    public boolean book(int startTime, int endTime) {
        map.put(startTime, map.getOrDefault(startTime, 0) +1);
        map.put(endTime, map.getOrDefault(endTime, 0)-1);

        int numBookings = 0;
        for(Integer key: map.keySet()) {
            numBookings += map.get(key);
            if(numBookings > numberMeetingsAllowed) {
                // dont allow this
                map.put(startTime, map.get(startTime)-1);
                map.put(endTime, map.get(endTime)+1);
                return false;
            }
        }
        return true;
    }
}
