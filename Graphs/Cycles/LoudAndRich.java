package Cycles;
import java.util.*;

public class LoudAndRich {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n= quiet.length;
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree= new int[n];
        //build the graph
        for(int[] r: richer){
            int u= r[0];
            int v= r[1];
            // u is richer than v
            adj.get(u).add(v);
            indegree[v]++;
        }
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i]=i;
        }
        Queue<Integer> queue= new LinkedList<>();
        //push indegree 0
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        //kahn's algorithm
        while(!queue.isEmpty()){
            int node= queue.poll();
            for(int neighbour: adj.get(node)){
                //propagate quitest person
                if(quiet[ans[node]]<quiet[ans[neighbour]]){
                    quiet[ans[neighbour]]=quiet[ans[node]];
                }
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    queue.add(neighbour);
                }
            }
        }
        return ans;
    }
}
