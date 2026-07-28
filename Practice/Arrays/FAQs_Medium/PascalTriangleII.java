package FAQs_Medium;

public class PascalTriangleII {
    public int[] pascalTriangleII(int r) {
        int[] ans = new int[r];
        ans[0] = 1;
        int t = 1;
        // r is the row, and i is the column
        //
        for(int i=1; i<r; i++){
            t *= (r-i);
            ans[i]=t;
            t/=i;

        }
        return ans;
    }
}
