package Shortest_Path_Algorithms;
import java.util.*;

public class DijkstraAlgoSet {
    static class Pair{
        int node;
        int distance;
        Pair(int node, int distance){
            this.node=node;
            this.distance=distance;
        }
    }
    public  int[] dijkstra(int V, ArrayList<ArrayList<Integer>> edges, int S){
        List<List<Pair>> adj= new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.size();i++){
            int u= edges.get(i).get(0);
            int v= edges.get(i).get(1);
            int wt= edges.get(i).get(2);
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        int[] dist= new int[V];
        for(int i=0;i<V;i++){
            dist[i]= (int)(1e9);
        }
        dist[S]=0;
        TreeSet<Pair> set= new TreeSet<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.distance>o2.distance) return 1;
                else if(o1.node>o2.node) return 1;
                return -1;
            }
        });
        set.add(new Pair(S,0));
        while(!set.isEmpty()){
            Pair top = set.pollFirst();
            int node= top.node;
            int distance= top.distance;
            for(Pair neighbourPair: adj.get(node)){
                int neighbour= neighbourPair.node;
                int newDistance= neighbourPair.distance+distance;
                if(newDistance<dist[neighbour]){
                    //remove the old entry
                    set.remove(new Pair(neighbour, dist[neighbour]));
                    dist[neighbour]= newDistance;
                    set.add(new Pair(neighbour,dist[neighbour]));
                }
            }
        }
        return dist;
    }
}
