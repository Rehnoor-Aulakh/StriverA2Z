package Cycles;
import java.util.*;

public class Topological_Kahn {
    public int[] topoSort(int V, List<List<Integer>> adj) {
        int[] indegree= new int[V];
        //traverse the adj list
        for(List<Integer> list: adj){
            for(int neighbour: list){
                indegree[neighbour]++;
            }
        }
        Queue<Integer> queue= new LinkedList<>();
        int[] ans= new int[V];
        int k=0;
        //push the one's with indegree 0
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                queue.add(i);
                ans[k++]=i;
            }
        }

        //start bfs from here
        while(!queue.isEmpty()){
            int node = queue.poll();
            //decrement indegree by 1 of its neighbours
            for(int neighbour: adj.get(node)){
                    indegree[neighbour]--;
                    if(indegree[neighbour]==0){
                        queue.add(neighbour);
                        ans[k++]=neighbour;
                    }


            }
        }
        return ans;
    }

}
