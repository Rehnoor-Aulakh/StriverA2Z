package FAQs_Hard;
import java.util.*;

public class MajorityElementII {
    public List<Integer> majorityElementTwo(int[] nums) {
        int count1= 0, count2 = 0, ele1 = 0, ele2 = 0;
        for(int ele: nums) {
            // if the element is not ele1 or ele2
            if(ele == ele1){
                count1++;
            }
            else if(ele==ele2) count2++;
            else if(count1==0) ele1 = ele;
            else if(count2==0) ele2 = ele;
            // there is an element that is not ele1 and not ele2, so we can decrement both the counts because their probability of being a majority element is very less
            else{
                count1--;
                count2--;
            }
        }
        // verify if the ele1 and ele2 are the actual answers
        int actual_count1 = 0, actual_count2= 0;
        List<Integer> ans = new ArrayList<>();
        for(int ele: nums) {
            if(ele==ele1) {
                actual_count1++;
            }
            else if(ele==ele2) {
                actual_count2++;
            }
        }
        int n = nums.length;
        if(actual_count1> (n / 3)){
            ans.add(ele1);
        }
        if(actual_count2 > (n/3)){
            ans.add(ele2);
        }
        return ans;
    }
}
