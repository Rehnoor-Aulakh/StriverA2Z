import java.util.Arrays;

public class DetermineIf2EventsConflict {
//    private int[][] convertToString(String[] event) {
//        // one int for hh one int for mm
//        int[][] ans = new int[2][2];
//        int row = 0, col = 0;
//        for(String e: event) {
//            String[] thisRow = e.split(":");
//            for(String number: thisRow) {
//                ans[row][col++] = Integer.parseInt(number);
//            }
//            col = 0;
//            row++;
//        }
//        return ans;
//    }
    private int[] convertToString(String[] event) {
        // one int for hh one int for mm
        int[] ans = new int[2];
        int row = 0;
        for(String e: event) {
            String[] thisRow = e.split(":");
            ans[row] = Integer.parseInt(thisRow[0]) + (Integer.parseInt(thisRow[1])/100);
            row++;
        }
        return ans;
    }

    public boolean haveConflict(String[] ev1, String[] ev2) {
        // event 1: ["01:15", "02:00"]
        // e1: [[1,15],[2,0]]
        int[] event1 = convertToString(ev1);
        int[] event2 = convertToString(ev2);
        // now check for conflict
        // if(s1<=e2 && s2<=e1)
        int s1 = event1[0],s2= event2[0], e1 = event1[1], e2 = event2[1];
        System.out.println(s1 + " " + e1 + " " + s2 + "  " + e2);
        return s1<=e2 && s2<=e1;
    }
    public static void main() {
        String[] event = new String[]{"01:15", "02:00"};
        for(String e: event) {
            System.out.println(Arrays.toString(e.split(":")));
        }
    }
}
