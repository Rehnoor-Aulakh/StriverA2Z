import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int size= nums.length;
        int ans[]= new int[size-k+1];
        int j=0;
        Deque<Integer> dq= new LinkedList<>();
        for(int i=0;i<size;i++){
            // I also need to remove the i-k th occurance
            // like when i=3, I need to remove the 0th one first
            //scan from the front
            if(!dq.isEmpty() && dq.getFirst()== i-k){
                dq.removeFirst();
            }
                while(!dq.isEmpty() && nums[dq.getLast()]<nums[i]){
                    dq.removeLast();
                }
                dq.addLast(i);

            if(i+1>=k){
                ans[j++]=nums[dq.getFirst()];
            }
        }
        return ans;
    }

    static void main() {

    }
}
