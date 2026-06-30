package Shortest_Path_Algorithms;
import java.util.*;

public class BellmanFordAlgorithm {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        //we need to perform V-1 iterations of relaxing the edges
        //if it contains a negative cycle, then we have to return -1 in the list
        int[] dist= new int[V];
        for(int i=0;i<V;i++){
            dist[i]=(int)(1e9);
        }
        dist[S]=0;
        //now start the iterations
        // V-1 Iterations
        for(int i=0;i<V-1;i++){
            //relax the edges
            for(ArrayList<Integer> edge: edges){
                int u= edge.get(0);
                int v= edge.get(1);
                int wt= edge.get(2);
                if(dist[u]==(int)(1e9)) continue;
                if(dist[u]+wt<dist[v]){
                    dist[v]= dist[u]+wt;
                }
            }
        }
        //now the n th iteration- reality check of negative cycle
        for(ArrayList<Integer> edge: edges){
            int u= edge.get(0);
            int v= edge.get(1);
            int wt= edge.get(2);
            if(dist[u]==(int)(1e9)) continue;
            if(dist[u]+wt<dist[v]){
                return new int[]{-1};
            }
        }
        return dist;
    }
}
