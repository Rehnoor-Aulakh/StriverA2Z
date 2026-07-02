import java.util.Arrays;
import java.util.HashSet;

public class AltTabSimulation {
    public static int[] simulationResult(int[] windows, int[] queries) {
        int size = windows.length;
        int[] ans = new int[size];
        int querySize = queries.length;
        int k=0;
        HashSet<Integer> visited = new HashSet<>();
        for(int i=querySize-1;i>=0;i--){
            if(!visited.contains(queries[i])){
                ans[k++] = queries[i];
                visited.add(queries[i]);
            }
        }
        for(int i=0;i<size;i++){
            if(!visited.contains(windows[i])){
                ans[k++] = windows[i];
            }
        }
        return ans;
    }

    static void main() {
        System.out.println(Arrays.toString(simulationResult(new int[]{5, 3, 1, 2, 4}, new int[]{2,5,3})));
    }
}
