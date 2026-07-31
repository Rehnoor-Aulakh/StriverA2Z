package LogicBuilding;

public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int low =0, high = nums.length -1;
        int size= nums.length;
        while(low<=high) {
            int mid = low + (high-low)/2;
            // base case
            if((mid==0 || mid>0 && nums[mid]!=nums[mid-1]) && (mid==(size-1) || mid<size-1 && nums[mid]!=nums[mid+1])){
                return nums[mid];
            }
            // otherwise we need to do this by counting
            // it is guaranteed now that either mid is same as mid + 1 or mid - 1
            if(mid>0 && nums[mid]==nums[mid-1]){
                // mid-1 and mid are duplicates
                // check count till mid
                // if mid is odd, then it lies on right
                if(mid%2!=0){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
                continue;
            }
            if(mid<size-1 && nums[mid]==nums[mid+1]) {
                // mid+1 and mid are same, check for mid+1 now
                if((mid+1)%2!=0){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }

            }

        }
        return 0;
    }
}
