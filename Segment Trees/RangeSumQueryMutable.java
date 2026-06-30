public class RangeSumQueryMutable {
    int n;
    int[] arr;
    int[] seg;
    public RangeSumQueryMutable(int[] arr) {
        this.arr= arr;
        this.n = arr.length;
        this.seg = new int[4*n];
        build(0,0,n-1);
    }

    public void update(int i, int value) {
        update(0, 0, n-1, value, i);
    }
    void update(int ind, int low, int high, int value, int i){
        if(low==high){
            // update this now
            seg[ind]= value;
            return;
        }
        int mid = (low+high) >> 1;
        if(i<=mid){
            update(2*ind+1, low, mid, value, i);
        }
        else {
            update(2*ind+2, mid+1, high, value, i);
        }
        seg[ind] = seg[2*ind+1] + seg[2*ind+2];
    }
    public int sumRange(int left, int right) {
        return query(0, 0, n-1, left, right);
    }
    int query(int ind, int low, int high, int l, int r){
        // NO OVERLAP
        if(r<low || l>high){
            return 0;
        }
        // COMPLETE OVERLAP
        // [ l low high r ]
        if(low>=l && high<=r) return seg[ind];

        int mid = (low+high) >> 1;
        int left = query(2*ind+1, low, mid, l, r);
        int right = query(2*ind+2, mid+1, high, l, r);
        return left + right;
    }
    private void build(int ind, int low, int high){
        if(low==high){
            seg[ind]= arr[low];
            return;
        }
        int mid = (low+high)/2;
        build(2*ind+1, low, mid);
        build(2*ind+2, mid+1, high);
        seg[ind] = seg[2*ind+1] + seg[2*ind+2];

    }
}
