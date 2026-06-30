package Hard_Problems;
import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int ans[]= new int[numCourses];
        int k=0;
        //build the adjacency list
        int[] indegree= new int[numCourses];
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        //add all the edges
        for(int[] edge: prerequisites){
            indegree[edge[0]]++;
            //edge from v to u
            adj.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue= new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                ans[k]= i;
                k++;
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int node= queue.poll();
            for(int neighbour: adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    queue.add(neighbour);
                    ans[k]=neighbour;
                    k++;
                }
            }
        }
        if(k==numCourses) return ans;
        return new int[0];
    }
}
