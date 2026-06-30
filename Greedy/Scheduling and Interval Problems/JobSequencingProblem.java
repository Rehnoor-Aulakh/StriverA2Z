import java.util.*;

public class JobSequencingProblem{
    public int[] JobScheduling(int[][] Jobs) {
    // sort the array in descending order of profit
    Arrays.sort(Jobs, (a, b) -> b[2] - a[2]);
    //find the maxDeadline
    int maxDeadline=-1;
    for(int[] job:Jobs){
        maxDeadline=Math.max(maxDeadline,job[1]);
    }
    // create an array of size len
    int count = 0;
    int maxProfit = 0;
    int[] ans = new int[maxDeadline + 1];
    Arrays.fill(ans, -1);
    // to start indexing with 0
    for (int[] job : Jobs) {
      // check by loop if we get some previous deadline
      // loop starts from this deadline, goes till 0
      int deadline = job[1];
      while (deadline >= 1) {
        if (ans[deadline] == 0) {
          ans[deadline] = job[0];
          maxProfit += job[2];
          count++;
          break;
        }
        deadline--;
      }
    }
    int[] t = {count, maxProfit};
    return t;
  }
    public static void main(String[] args) {
        
    }
}