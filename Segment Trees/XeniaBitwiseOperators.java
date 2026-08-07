import java.util.Arrays;

public class XeniaBitwiseOperators {
    static class SegmentTree{
        int n;
        int levels;
        int[] seg;
        int size;
        SegmentTree(int[] nums) {
            this.n = nums.length;
            this.seg = new int[2 * n-1];

            // In Codeforces "Xenia and Bitwise Operations":
            // Height/levels determine if the bottom operation is OR (level % 2 != 0) or XOR.
            int levels = (int) (Math.log(n) / Math.log(2));
            boolean isOr = (levels % 2 != 0);

            build(0, 0, n - 1, isOr, nums);
            System.out.println(Arrays.toString(seg));
        }
        // build method-> start from root, gather left and right
        public void build(int ind, int low, int high, boolean isOr, int[] nums) {
            // base case
            if(low==high) {
                seg[ind] = nums[low];
                return;
            }
            int mid = (low+high)/2;
            build(2*ind+1, low, mid, !isOr, nums);
            build(2*ind+2, mid+1, high, !isOr, nums);
            if(isOr) {
                seg[ind] = (seg[2*ind+1] | seg[2*ind+2]);
            } else{
                seg[ind] = (seg[2*ind+1] ^ seg[2*ind+2]);

            }
        }

    }
    public static void main() {
        int[] nums= {1,2,3,4,1,2,3,4};
        SegmentTree tree = new SegmentTree(nums);
    }
}
