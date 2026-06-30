package Traversals;

import java.util.*;

public class ConnectedComponents {
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        //I need to iterate the edges
        boolean[] visited= new boolean[V];
        //for all vertices in graph, perform bfs and go on marking visited
        int count=0;
        for(int i=0;i<V;i++){
            if(visited[i]){
                continue;
            }
            dfs(visited, edges, i);
            count++;
        }
        return count;

    }
    private void dfs(boolean[] visited, List<List<Integer>> edges, int node){
        //mark this node as visited
        if(visited[node]) return;
        visited[node]=true;

        //now find the edge where there is node, and go there
        for(List<Integer> edge: edges){
            int u= edge.get(0);
            int v= edge.get(1);
            if(u==node){
                dfs(visited, edges, v);
            }
            else if(v==node){
                dfs(visited, edges, u);
            }
        }
    }
}
