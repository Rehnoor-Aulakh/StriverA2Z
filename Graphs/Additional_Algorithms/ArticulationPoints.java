package Additional_Algorithms;
import java.util.*;

public class ArticulationPoints {
    private int timer= 0;
    private void dfs(int node, int parent, int[] visited, int[] tin, int[] low, int[] mark, ArrayList<ArrayList<Integer>> adj){
        visited[node]= 1;
        tin[node]= timer;
        low[node] = timer;
        timer++;
        int child = 0;
        // go to the adjacent nodes
        for(Integer it: adj.get(node)){
            if(it == parent) continue;
            if(visited[it]==0){
                // call the dfs
                dfs(it, node, visited, tin, low, mark, adj);
                low[node] = Math.min(low[node], low[it]);
                if(low[it] >= tin[node] && parent !=-1){
                    mark[node]=1;
                }
                child++;
            }
            else{
                low[node] = Math.min(low[node], tin[it]);
            }
            if(child>1 && parent==-1){
                mark[node]=1;
            }
        }

    }
    public ArrayList<Integer> articulationPoints(int n,
                                                 ArrayList<ArrayList<Integer>> adj) {
        int[] visited= new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        int[] mark = new int[n];
        for(int i=0;i<n;i++){
            if(visited[i] == 0){
                dfs(i, -1, visited, tin, low, mark, adj);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(mark[i]==1){
                ans.add(i);
            }
        }
        if(ans.isEmpty()){
            ans.add(-1);
        }
        return ans;
    }
}
