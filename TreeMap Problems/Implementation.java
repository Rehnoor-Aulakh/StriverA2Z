import java.util.Map;
import java.util.TreeMap;

public class Implementation {

    static void main() {
        TreeMap<Integer, String> channelStudents = new TreeMap<>();
        channelStudents.put(5, "Dipti");
        channelStudents.put(2, "Mansi");
        channelStudents.put(1, "Sahil");
        channelStudents.put(6, "Krish");
        channelStudents.put(10, "Anuj");
        channelStudents.put(0, "Noor");
        channelStudents.put(12, "VijayNegi");

        // containsKey
        System.out.println(channelStudents.get(10));

        // update
        channelStudents.put(10, "CTO Bhaiya");

        System.out.println(channelStudents.get(10));

        System.out.println(channelStudents.firstKey());

        System.out.println(channelStudents.lastEntry());

        ///  VERY VERY IMPORTANT FOR QUESTIONS
        // ceiling key
        System.out.println(channelStudents);

        System.out.println(channelStudents.ceilingKey(11));

        // floor key
        System.out.println(channelStudents.floorEntry(11));

        // Iterator
        for(Integer k: channelStudents.keySet()) {
            System.out.print(k+ " ");
        }

        for(Map.Entry<Integer, String> e: channelStudents.entrySet()) {
            System.out.println(e.getKey() + " -> "+ e.getValue());
        }

    }
}
