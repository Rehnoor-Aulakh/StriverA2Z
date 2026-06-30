import java.util.*;

public class AllPathsFromSourceLeadToDestination {
    private boolean dfs(List<List<Integer>> adj, int[] state, int source, int destination){
        // base case-the source is equal to the destination and check that it should not have any neighbours
        if(state[source]==1) return false;
        // if the node is already fully verified, return true
        if(state[source]==2) return true;
        if(adj.get(source).isEmpty()){
            return(source==destination);
        }
        // mark the current source as visiting
        state[source] = 1;
        for(int neighbour: adj.get(source)){
            // if any branch fails, then entire source fails
            if(!dfs(adj, state, neighbour, destination)){
                return false;
            }
        }
        // all the neighbours have been processed, mark this path as all visited
        state[source]= 2;
        return true;
    }
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            // this is a directed edge
            int u= edge[0];
            int v= edge[1];
            adj.get(u).add(v);
        }
        if(!adj.get(destination).isEmpty()) return false;
        // after this the adjacency list is ready
        int[] visited = new int[n];
        return dfs(adj, visited,source, destination);
    }
}
