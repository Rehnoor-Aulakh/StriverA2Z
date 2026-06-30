package Hard_Problems;
import java.util.*;

class FindEventualSafeStatesBest{
    public List<Integer> eventualSafeNodes(int[][] adj){
        int n= adj.length;
        int visited[] = new int[n];
        int pathVisited[]= new int[n];
        int check[]= new int[n];
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfsCheck(i, adj, visited, pathVisited, check);
            }
        }
        List<Integer> ans= new ArrayList<>();
        for(int i=0;i<n;i++){
            if(check[i]==1){
                ans.add(i);
            }
        }
        return ans;
    }
    private boolean dfsCheck(int node, int[][] adj, int[] visited, int[] pathVisited, int[] check){
        visited[node]=1;
        pathVisited[node]=1;
        check[node]=0;
        for(int neighbour: adj[node]){
            if(visited[neighbour]==0){
                if(dfsCheck(neighbour, adj,visited,pathVisited, check)) return true;

            }
            else if(pathVisited[neighbour]==1){
                //there is a cycle
                return true;
            }
        }
        //if safe till now
        check[node]=1;
        pathVisited[node]=0;
        return false;
    }
}

public class FindEventualSafeStatesDFS {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n= graph.length;
        Set<Integer> ans= new HashSet<>();
        boolean[] visited= new boolean[n];
        //now iterate the graph nodes, and do dfs to check safe
        for(int i=0;i<n;i++){
            if(!visited[i] && !ans.contains(i)){
                dfs(i, visited, ans, graph);
            }
        }
        return ans.stream().sorted().toList();
    }
    private boolean dfs(int node, boolean[] visited, Set<Integer> ans, int[][] graph){
        //base case
        if(graph[node].length==0) {
            ans.add(node);
            visited[node]=true;
            return true;
        }
        if(visited[node]) return ans.contains(node);
        visited[node]= true;
        //call it for the neighbours, all the neighbours must return true
        for(int neighbour: graph[node]){
            //if any one neighbour returns false, return false
            if(!dfs(neighbour, visited, ans, graph)){
                return false;
            }
        }
        ans.add(node);
        return true;
    }
}
