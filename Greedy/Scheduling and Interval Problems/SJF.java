
import java.util.Arrays;

public class SJF{
    public long solve(int[] bt) {
        //given an array of burst times, return the average waiting time in SJF
        Arrays.sort(bt);
        int wt=0;
        int t=0;
        for(int i=0;i<bt.length;i++){
            //first process started at startTime=0
            wt+=t;
            //update the startTime to next process's startTime
            t+=bt[i];
        }
        return wt/bt.length;
    }
    public static void main(String[] args) {
        
    }
}