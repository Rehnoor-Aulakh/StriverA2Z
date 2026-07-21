package LogicBuilding;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int i = 0, j= 1;
        if(nums.length==0) return 0;
        int count=1;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                j++;
            }
            else{
                // it is distinct, so the i+1 should be j
                nums[++i]= nums[j++];
                count++;
            }
        }
        return count;
    }

    static void main() {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,2,2}));
    }
}
