package Cycles;
import java.util.*;

public class DetectCycleDirectedGraph {
    public boolean isCyclicBFS(int N, List<List<Integer>> adj) {
        int[] indegree= new int[N];
        Queue<Integer> queue= new LinkedList<>();
        for(List<Integer> list: adj){
            for(int neighbour: list){
                indegree[neighbour]++;
            }
        }
        int count=0;
        //push all indegree 0 to queue
        for(int i=0;i<N;i++){
            if(indegree[i]==0){
                queue.add(i);
                count++;
            }
        }
        //kahn's algo
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
        return (count==N);
    }
    public boolean isCyclicDFS(int N, List<List<Integer>> adj){
        boolean[] visited= new boolean[N];
        boolean[] pathVisited= new boolean[N];
        for(int i=0;i<N;i++){
            if(!visited[i]){
                if(dfs(i, adj, visited, pathVisited)) return true;
            }
        }
        return false;
    }
    private boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited){
        if(pathVisited[node]) return false;
        visited[node]=true;
        pathVisited[node]= true;
        //add the neighbours
        for(int neighbour: adj.get(node)){
            //base case, if the same path is visited, there is a directed cycle
            if(pathVisited[neighbour]) return true;
            else if(!visited[neighbour]){
                //if visited, dont call dfs
                //go in depth and check if there is a directed cycle
                if(dfs(neighbour, adj, visited, pathVisited)) return true;
            }
        }
        //backtrack
        pathVisited[node]= false;
        return false;
    }
}
