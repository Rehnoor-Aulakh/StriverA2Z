
import java.util.*;

public class NumberOfTimesArrayRotated{
    public static int findKRotation(ArrayList<Integer> nums){
        int min=Integer.MAX_VALUE;
        int index=-1;
        int low=0;
        int high=nums.size()-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums.get(low)<=nums.get(mid)){
                //LEFT HALF SORTED
                if(nums.get(low)<min){
                    min=nums.get(low);
                    index=low;
                }
                //might be in the right
                low=mid+1;
            }
            else{
                if(nums.get(mid)<min){
                    min=nums.get(mid);
                    index=mid;
                }
                //might be on the left
                high=mid-1;
            }
        }
        return index;
    }

    public static int findKRotationBrute(ArrayList<Integer> nums) {
        int min= Integer.MAX_VALUE;
        int index=-1;
        for(int i=0;i<nums.size();i++){
            if(nums.get(i)<min){
                min=nums.get(i);
                index=i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(List.of(4, 5, 6, 7, 0, 1, 2, 3));
        System.out.println(findKRotation(al));
    }
}