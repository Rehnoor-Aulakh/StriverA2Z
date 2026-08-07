package SweepLine;

import java.util.*;

public class MyCalendarTwo {
    List<int[]> bookings = new ArrayList<>();
    List<int[]> overlappedIntervals = new ArrayList<>();
    // bookings list
    // overlapping list
    // fn: whether they are overlapping or not
    // fn: overlap part
    public boolean isOverlapping(int s1, int e1, int s2, int e2) {
        return (s1<e2 && s2<e1);
    }
    public int[] getOverlapInterval(int s1, int e1, int s2, int e2) {
        return new int[]{Math.max(s1,s2), Math.min(e1,e2)};
    }
    public MyCalendarTwo() {

    }

    public boolean book(int startTime, int endTime) {
        // check if the booking intersects with any of the overlapped intervals
        // return false if it does
        for(int[] i: overlappedIntervals) {
            if(isOverlapping(startTime, endTime, i[0], i[1])) {
                return false;
            }
        }
        // find the overlapped part with the rest of the bookings
        for(int[] b: bookings) {
            if(isOverlapping(startTime, endTime, b[0], b[1])){
                overlappedIntervals.add(getOverlapInterval(startTime, endTime, b[0], b[1]));
            }
        }
        bookings.add(new int[]{startTime, endTime});
        return  true;
    }
}
