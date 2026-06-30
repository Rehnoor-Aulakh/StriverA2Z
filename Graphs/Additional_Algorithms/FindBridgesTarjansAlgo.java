package Additional_Algorithms;
import java.util.*;

public class FindBridgesTarjansAlgo {
    private int timer=1;
    public void dfs(List<List<Integer>> adj, int[] visited, int node, int parent, int[] time, int[] low , List<List<Integer>> bridges ){
        visited[node]= 1;
        // dfs on all the neighbours
        time[node]=timer;
        low[node] = timer;
        timer++;
        // but this will change when we return from the neighbouring dfs calls
        for(int neighbour: adj.get(node)){
            if(neighbour== parent) continue;
            if(visited[neighbour]==0){
                dfs(adj, visited, neighbour, node, time, low, bridges);
                // now when you return from the call, update the low of node to be the low of neighbour if it is smaller
                low[node]= Math.min(low[node], low[neighbour]);
                // CHECK THE CONDITION FOR BRIDGE
                if(low[neighbour]>time[node]){
                    bridges.add(Arrays.asList(neighbour, node));
                }
            }
            else{
                low[node] = Math.min(low[node], low[neighbour]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> edges) {
        List<List<Integer>> bridges= new ArrayList<>();
        int[] visited= new int[n];
        int[] time = new int[n];
        int[] low = new int[n];
        List<List<Integer>> adj= new ArrayList<>();
        // create the adjacency list from the edges
        for(int i=0; i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> edge: edges){
            int u= edge.get(0);
            int v= edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dfs(adj, visited, 0, -1, time, low, bridges);
        return bridges;
    }

}
