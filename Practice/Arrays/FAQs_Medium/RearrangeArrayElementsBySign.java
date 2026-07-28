package FAQs_Medium;

public class RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums){
        // the brute force that I can think of is, for the 0th index, go and find the first positive element,
        // [-1 -2 -3 0 1 2] -> the first positive element is 0 at index 3
        // if we create a new array, then operation is quite easy
        // even simpler -> create an element of the same size
        int size = nums.length;
        int[] ans = new int[size];
        int posIndex = 0;
        int negIndex = 1;
        for(int i=0;i<size; i++){
            if(nums[i]>=0){
                // insert it at the positive index
                ans[posIndex] = nums[i];
                posIndex+=2;
            }
            else{
                ans[negIndex] = nums[i];
                negIndex+=2;
            }
        }
        return ans;
    }
}
