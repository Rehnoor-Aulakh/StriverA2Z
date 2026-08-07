import java.util.ArrayList;
import java.util.List;

public class VersionCycleBSQuestion {
    private static boolean canSort(List<Integer> versions, int m, int k) {
        int prev = 0;
        for(int i=0; i<versions.size(); i++) {
            int value = versions.get(i);
            if(value <= prev && prev<=value+k) {
                continue;
            }
            // check if it can wrap around
            if(value+k >=m) {
                int wrappedMax = (value+k)%m;
                // still the minimum is prev
                if(prev<=wrappedMax) {
                    continue;
                }
            }
            if(value>prev) {
                prev = value;
            }else{
                return false;
            }
        }
        return true;
    }
    public static int minCycles(List<Integer> versions, int m) {
        int n = versions.size();
        int low= 0, high = m-1;
        int candidateAns = 0;
        while(low<=high ) {
            int mid = low + (high-low)/2;
            if(canSort(versions, m, mid)) {
                candidateAns = mid;
                // go left to see if you can find a better answer
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return candidateAns;
    }
    public static void main() {
        System.out.println(minCycles(new ArrayList<>(List.of(0,6,1,3,2)),7));
    }
}
