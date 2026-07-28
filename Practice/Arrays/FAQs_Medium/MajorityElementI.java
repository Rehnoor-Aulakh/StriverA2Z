package FAQs_Medium;

public class MajorityElementI {
    public int majorityElement(int[] nums){
        // find the element that occurs more than n/2 times
        // target : O(n) time and O(1) space
        // lets say we have an array [3,1,2,1,1,2] -> the first time the element becomes 3, and freq is 1
        // then 1 comes, it will decrease freq of 3 to 0, since freq is 0, start a new element
        int element = 0;
        int count = 0;
        for(int i=0; i<nums.length;i++){
            if(count==0){
                element = nums[i];
                count=1;
            }
            else if(nums[i]==element){
                count++;
            }
            else{
                count--;
            }
        }
        return element;
    }
}
