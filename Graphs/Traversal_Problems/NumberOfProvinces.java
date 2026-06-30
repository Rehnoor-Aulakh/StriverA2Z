package Traversal_Problems;

public class NumberOfProvinces {
    public int numProvinces(int[][] adj) {
        //I have been given an adjacency list, where in one row, the edge is marked
        //so every row is indicator of that node
        int size= adj.length;
        boolean[] visited= new boolean[size];
        //indexing is 1 based
        int count=0;
        for(int i=0;i<size;i++){
            if(visited[i]){
                continue;
            }
            dfs(i, visited, adj);
            count++;
        }
        return count;
    }
    private void dfs(int node, boolean[] visited, int[][] adj){
        visited[node]=true;
        //go to the row of i, and iterate wherever column is 1
        for(int col=0;col<adj[0].length;col++){
            if(adj[node][col]==1 && !visited[col]){
                dfs(col, visited, adj);
            }
        }
    }
}
