package Hard_Problems;
import java.util.*;

public class ShortestPathDAG {
    static class Pair{
        int v;
        int wt;
        Pair(int v, int wt){
            this.v=v;
            this.wt=wt;
        }
    }
    public int[] shortestPath(int N, int M, int[][] edges) {
        // start node is 0
        //first make the toposort using dfs
        List<List<Pair>> adj= new ArrayList<>();
        for(int i=0;i<N;i++){
            List<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }
        //build the adj list
        for(int i=0;i<M;i++){
            int u=edges[i][0];
            int v= edges[i][1];
            int wt= edges[i][2];
            adj.get(u).add(new Pair(v,wt));
        }
        int[] visited= new int[N];
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<N;i++){
            if(visited[i]==0){
                topoSort(i, adj, visited, st);
            }
        }
        //now the stack contains the topological order
        int[] dist= new int[N];
        for(int i=1;i<N;i++){
            dist[i]= Integer.MAX_VALUE;
        }
        //now start the logic of popping from the stack, and updating the distance of neighbours
        while(!st.isEmpty()){
            int node= st.pop();
            //go to its neighbours
            for(Pair neighbour: adj.get(node)){
                if(dist[node] != Integer.MAX_VALUE &&
                        dist[node] + neighbour.wt < dist[neighbour.v]){
                    dist[neighbour.v] = dist[node] + neighbour.wt;
                }
            }
        }
        for(int i=0;i<N;i++){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i]=-1;
            }
        }
        return dist;
    }
    private void topoSort(int node, List<List<Pair>> adj, int[] visited, Stack<Integer> st){
        if(visited[node]==1) return;
        visited[node]=1;
        //for all the neighbours
        //keep on putting the elements onto the stack and at the end put the node
        for(Pair neighbour: adj.get(node)){
            if(visited[neighbour.v]==0){
                topoSort(neighbour.v, adj, visited, st);
            }
        }
        //when this ends, push it onto the stack
        st.push(node);
    }
}
