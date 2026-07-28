package FAQs_Medium;
import java.util.*;

public class PascalTriangleIII {
    public List<List<Integer>> pascalTriangleIII(int n) {
        List<List<Integer>> triangle = new ArrayList<>();
        // add the first row's first 1
        triangle.add(new ArrayList<>(List.of(1)));
        // the rest of those we can loop
        for(int i=1; i<n; i++){
            List<Integer> currentRow = new ArrayList<>();
            List<Integer> prevRow = triangle.get(triangle.size()-1);
            currentRow.add(1);
            // leave the last 1 , we will handle that at the end
            for(int j=1; j<i; j++){
                // sum of j and j-1
                currentRow.add(prevRow.get(j)+prevRow.get(j-1));
            }
            currentRow.add(1);
            triangle.add(currentRow);
        }
        return triangle;
    }

    static void main() {
        PascalTriangleIII obj = new PascalTriangleIII();
        System.out.println(obj.pascalTriangleIII(4));
    }
}
