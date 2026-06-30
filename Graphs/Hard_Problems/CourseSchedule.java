package Hard_Problems;
import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        //make indegree
        int[] indegree= new int[numCourses];
        // [u,v], add an edge from u to v
        for(int[] arr: prerequisites){
            indegree[arr[0]]++;
            adj.get(arr[1]).add(arr[0]);
        }

        int count=0;
        Queue<Integer> queue= new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(adj.get(i).size()==0){
                count++;
                queue.add(i);
            }
        }
        //Kahn's algo
        while(!queue.isEmpty()){
            int node= queue.poll();
            for(int neighbour: adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    count++;
                    queue.add(neighbour);
                }
            }
        }
        return(count==numCourses);
    }
}
