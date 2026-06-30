package Hard_Problems;
import java.util.*;

public class FindEventualSafeStatesBFS {
    public List<Integer> eventualSafeNodes(int[][] graph){
        //we need outdegree=0 and connected nodes
        //so reverse means indegree=0 and connected nodes
        //first of all reverse the graph
        int V= graph.length;
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree= new int[V];
        for(int i=0;i<V;i++){
            //iterate the ith vertex of graph
            // edge becomes neighbour-> i
            for(int neighbour: graph[i]){
                //for every neighbour's adjacency list, add ith vertex
                adj.get(neighbour).add(i);
                indegree[i]++;
            }
        }
        //now adj has the reversed graph
        //Kahn's algo
        //queue has all nodes with indegree = 0
        Queue<Integer> queue= new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            safeNodes.add(node);
            for(int neighbour: adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    queue.add(neighbour);
                }
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;

    }
}
