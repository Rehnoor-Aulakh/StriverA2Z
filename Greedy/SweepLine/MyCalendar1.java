package SweepLine;
import java.util.Map;
import java.util.TreeMap;
class MyCalendar {
    // we want it sorted by the end time
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    public MyCalendar() {

    }

    public boolean book(int startTime, int endTime) {
        if(treeMap.size()==0) {
            // just add it to tree map
            treeMap.put(endTime, startTime);
            return true;
        }
        else{
            // you need to iterate the tree map and find the first occurrence where Snew < E'
            for(Map.Entry<Integer, Integer> entry: treeMap.entrySet()) {
                int e_dash = entry.getKey();
                int s_dash = entry.getValue();
                if(startTime < e_dash) {
                    // this is the just next interval
                    // check the overlap condition
                    if(s_dash < endTime) {
                        return false;
                    }
                    break;
                }
            }
            treeMap.put(endTime, startTime);
            return true;
        }
    }
}

public class MyCalendar1 {

}
