package Additional_Algorithms;
import java.util.*;

public class KosarajuAlgorithm {
    private void dfs(int node, int[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        visited[node]= 1;
        // iterate over all the neighbours of this node
        for(int neighbour: adj.get(node)){
            if(visited[neighbour]==0){
                dfs(neighbour, visited, adj, st);
            }
        }
        // after the dfs is complete, you need to store the node in the stack, to tell that it is finished
        st.push(node);
    }
    private void dfsT(int node, int[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[node]=1;
        for(int neighbour: adj.get(node)){
            if(visited[neighbour]==0){
                dfsT(neighbour, visited, adj);
            }
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        // initially, all the nodes are unvisited
        int[] visited = new int[V];
        Stack<Integer> st = new Stack<>();
        // iterate over all the vertices
        for(int i=0; i<V; i++){
            if(visited[i]==0){
                dfs(i, visited, adj, st);
            }
        }
        //now our stack is ready, we need to reverse the edges of the graph
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjT.add(new ArrayList<>());
        }
        for(int node=0; node<V; node++){
            visited[node]=0;
            for(int neighbour: adj.get(node)){
                adjT.get(neighbour).add(node);
            }
        }
        int scc=0;
        while(!st.isEmpty()){
            int node= st.pop();
            if(visited[node]==0){
                scc++;
                dfsT(node, visited,adjT);
            }
        }
        return scc;
    }
}
