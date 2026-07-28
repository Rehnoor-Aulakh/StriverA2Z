package FAQs_Medium;

public class KadanesAlgorithm {
    public static void printBeginAndEndOfMaximumSubarray(int[] nums){
        int sum = 0;
        int maxi = 0;
        int beginIndex = -1;
        int endIndex = 0;
        for(int i=0 ;i<nums.length; i++) {
            sum += nums[i];
            if(sum<=0) {
                sum = 0;
                beginIndex = i+1;
            }
            if(sum>maxi) {
                maxi = sum;
                endIndex = i;
            }
        }
        System.out.println(beginIndex);
        System.out.println(endIndex);
    }

    static void main() {
        printBeginAndEndOfMaximumSubarray(new int[] {-2, -3, 4, -1, -2, 1, 5, -3});
    }
}
