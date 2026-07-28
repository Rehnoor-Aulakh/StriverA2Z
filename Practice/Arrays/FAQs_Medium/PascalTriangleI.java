package FAQs_Medium;

public class PascalTriangleI {
    private int ncr(int n, int r){
        if(r>n-r){
            r=n-r;
        }
        long ans = 1;
        for(int i=0; i<r; i++){
            ans*= (n-i);
            ans/= (i+1);
        }
        return (int) ans;
    }
    public int pascalTriangleI(int r, int c) {
        return ncr(r-1, c-1) ;
    }
    static void main() {
        PascalTriangleI obj = new PascalTriangleI();
        // we have to follow 1 based indexing
        System.out.println(obj.pascalTriangleI(5,3));
    }
}
