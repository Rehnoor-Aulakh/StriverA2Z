package Cycles;
import java.util.*;

public class TopologicalSortDFS {
    public int[] topoSort(int V, List<List<Integer>> adj) {
        int[] topo= new int[V];
        boolean[] visited= new boolean[V];
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,visited, adj, st);
                st.push(i);
            }
        }
        int i=0;
        while(!st.isEmpty()){
            topo[i++]=st.pop();
        }
        return topo;
    }
    private void dfs(int node, boolean[] visited, List<List<Integer>> adj, Stack<Integer> st){
        if(visited[node]) return;
        visited[node]=true;
        //otherwise find its neighbours
        for(int neighbour: adj.get(node)){
            //call dfs if not visited
            if(!visited[neighbour]){
                dfs(neighbour, visited, adj, st);
                //after this call, add to stack
                st.push(neighbour);
            }
        }
    }
}
