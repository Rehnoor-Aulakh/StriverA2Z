package Traversals;

import java.util.*;

public class DepthFirstSearch {
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> ans= new ArrayList<>();
        boolean visited[] = new boolean[V];
        visited[0]=true;
        dfs(adj, ans, 0,visited);
        return ans;
    }
    private void dfs(List<List<Integer>> adj, List<Integer> ans, int i, boolean[] visited){
        //add one neighbour of i in the recursion stack and go to its neighbour
        visited[i]=true;
        ans.add(i);
        for(int neighbour: adj.get(i)){
            if(!visited[neighbour]){
                visited[neighbour]=true;
                dfs(adj,ans,neighbour,visited);
            }
        }

    }
}
