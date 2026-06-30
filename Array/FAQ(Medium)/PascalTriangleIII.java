import java.util.*;

public class PascalTriangleIII{
    //DP Solution
    public static List<List<Integer>> pascalTriangleIII(int n) {
        List<List<Integer>> triangle=new ArrayList<>();
        List<Integer> firstRow= new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);
        for(int i=1;i<n;i++){
            List<Integer> row= new ArrayList<>();
            row.add(1);
            List<Integer> prevRow=triangle.get(i-1);
            for(int j=1;j<i;j++){
                row.add(prevRow.get(j)+prevRow.get(j-1));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
    public static void main(String[] args) {
        List<List<Integer>> ans=pascalTriangleIII(6);
        System.out.println(ans);
    }
}