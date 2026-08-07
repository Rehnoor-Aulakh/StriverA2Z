package Cycles;
import java.util.*;

public class IsBipartite {

    private boolean check(int start, int V, List<List<Integer>> adj, int[] color){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start]=0;
        while(!queue.isEmpty()){
            int node= queue.poll();
            for(int i: adj.get(node)){
                if(color[i]==color[node]) return false;
                if(color[i]==-1){
                    // 0 of node will become 1 of i, and vice versa
                    color[i]=1-color[node];
                    queue.add(i);
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int V, List<List<Integer>> adj) {
        int color[] = new int[V];
        for(int i=0;i<V;i++) color[i]=-1;
        //traverse all the vertices
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(check(i,V, adj, color)==false) return false;

            }
        }
        return true;
    }
}