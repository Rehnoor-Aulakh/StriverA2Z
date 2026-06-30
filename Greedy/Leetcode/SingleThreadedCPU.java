import java.util.*;
public class SingleThreadedCPU{
    public int[] getOrder(int[][] tasks) {
        //first sort the tasks according to enque time
        int size=tasks.length;
        int[][] indexedTasks= new int[size][3];
        for(int i=0;i<size;i++){
            indexedTasks[i][0]=tasks[i][0];
            indexedTasks[i][1]=tasks[i][1];
            indexedTasks[i][2]=i;
        }
        Arrays.sort(indexedTasks, (a,b) -> a[0]-b[0]);
        PriorityQueue<int[]> pq= new PriorityQueue<>((int[] a, int[] b) -> {
            if(a[1]!=b[1]) return a[1]-b[1];
            return a[2]-b[2];
        });
        //now that array is sorted correctly
        int[] ans= new int[size];
        int ansIndex=0;
        int taskIndex=0;
        long t=0;
        while(ansIndex<size){
            //add all available tasks to pq
            while(taskIndex<size && indexedTasks[taskIndex][0]<=t){
                pq.add(indexedTasks[taskIndex]);
                taskIndex++;
            }
            //no available task, just move to next task's enque time
            if(pq.isEmpty()){
                t= indexedTasks[taskIndex][0];
            }
            else{
                //process task from pq
                int[] task= pq.poll();
                ans[ansIndex++]=task[2];
                t+=task[1];
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        
    }
}