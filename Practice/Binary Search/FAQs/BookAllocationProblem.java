package FAQs;

public class BookAllocationProblem {
    private static boolean feasible(int[] nums, int m, int noOfPages) {
        // this function checks if noOfPages can be allocated to m students where every student's pages must not exceed noOfPages
        // since the allocation is contiguous so this becomes easy
        int currentStudentPages = 0;
        int numOfStudents = 1;
        // every element of num has to be allocated
        for(int num: nums) {
            if(currentStudentPages + num <= noOfPages) {
                currentStudentPages += num;
            } else{
                currentStudentPages = num;
                numOfStudents ++ ;
            }
        }
        return numOfStudents <= m;
    }
    public static int findPages(int[] nums, int m) {
        // minimum number of pages that can be allocated is 1
        int low = 1;
        // maximum number of pages will be the sum of pages
        int sum = 0;
        for(int num: nums) {
            low = Math.max(low, num);
            sum+=num;
        }
        int high = sum;
        while(low<=high) {
            int mid = low + (high-low)/2;
            // check if mid number of pages can be allocated in such a way that every student gets maximum mid number of pages
            if(feasible(nums, m, mid)) {
                // go left and check if less number of pages can become the global maxinum
                high = mid-1;
            } else{
                low= mid+1;
            }
        }
        return low;
    }

    static void main() {

    }
}
