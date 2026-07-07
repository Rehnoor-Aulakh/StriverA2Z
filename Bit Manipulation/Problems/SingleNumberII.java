package Problems;

public class SingleNumberII {
    public int singleNumberOptimal(int[] nums){
        int ones = 0, twos = 0;
        for(int num: nums){
            // if it is not in twos, then add it to ones

            // if it is
        }
    }
    public int singleNumberBetter(int[] nums) {
        int ans = 0;
        for(int i = 0; i<=31; i++){
            int count = 0;
            for(int num: nums){
                // check if ith bit is set in how many numbers
                if((num & (1<<i))!=0){
                    count++;
                }
            }
            if(count%3!=0){
                ans = ans | (1<<i);
            }
        }
        return ans;
    }
}
