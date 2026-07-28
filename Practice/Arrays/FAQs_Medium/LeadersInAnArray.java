package FAQs_Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LeadersInAnArray {
    public List<Integer> leaders(int[] nums) {
        // most optimal approach
        List<Integer> ans = new ArrayList<>();
        if(nums.length==0) return ans;
        // the element should be greater than all the elements on its right, then it is a leader, easy question
        // the last element is already a leader, after than all the elements that are larger than the last added element will be a leader
        ans.add(nums[nums.length-1]);
        int currMax = nums[nums.length-1];
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i]>currMax){
                ans.add(nums[i]);
                currMax = nums[i];
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
