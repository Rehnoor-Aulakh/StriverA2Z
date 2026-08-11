import java.io.*;
import java.util.*;

public class Question2 {
    public static List<Integer> getMinCost(List<Integer> capacity, List<Integer> fromServer, List<Integer> toServer) {
        int n = capacity.size();

        if (n <= 1) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < fromServer.size(); i++) {
                ans.add(0);
            }
            return ans;
        }

        // Step 1: Find the closest server for each server i
        int[] closest = new int[n];
        closest[0] = 1;
        closest[n - 1] = n - 2;

        for (int i = 1; i < n - 1; i++) {
            long distLeft = (long) capacity.get(i) - capacity.get(i - 1);
            long distRight = (long) capacity.get(i + 1) - capacity.get(i);

            if (distLeft < distRight) {
                closest[i] = i - 1;
            } else {
                closest[i] = i + 1;
            }
        }

        // Step 2: Build Prefix Sum for moving Right (0 to n-1)
        long[] rightPref = new long[n];
        for (int i = 0; i < n - 1; i++) {
            long cost = (closest[i] == i + 1) ? 1L : ((long) capacity.get(i + 1) - capacity.get(i));
            rightPref[i + 1] = rightPref[i] + cost;
        }

        // Step 3: Build Prefix Sum for moving Left (n-1 to 0)
        long[] leftPref = new long[n];
        for (int i = n - 1; i > 0; i--) {
            long cost = (closest[i] == i - 1) ? 1L : ((long) capacity.get(i) - capacity.get(i - 1));
            leftPref[i - 1] = leftPref[i] + cost;
        }

        // Step 4: Answer each query in O(1)
        int m = fromServer.size();
        List<Integer> ans = new ArrayList<>(m);

        for (int i = 0; i < m; i++) {
            int u = fromServer.get(i);
            int v = toServer.get(i);

            if (u == v) {
                ans.add(0);
            } else if (u < v) {
                // Moving Right
                ans.add((int) (rightPref[v] - rightPref[u]));
            } else {
                // Moving Left
                ans.add((int) (leftPref[v] - leftPref[u]));
            }
        }

        return ans;
    }
    static void main() {
        System.out.println( getMinCost(List.of(2,7,10), List.of(0,1,2), List.of(2,2,1)));
    }
}
