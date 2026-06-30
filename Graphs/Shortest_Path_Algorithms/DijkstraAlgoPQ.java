package Shortest_Path_Algorithms;
import java.util.*;

public class DijkstraAlgoPQ {
    static class Pair{
        int node;
        int distance;
        Pair(int node, int distance){
            this.node=node;
            this.distance=distance;
        }
    }
    public  int[] dijkstra(int V, ArrayList<ArrayList<Integer>> edges, int S){
        //first let us build the adjacency list
        List<List<Pair>> adj= new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.size();i++){
            int u= edges.get(i).get(0);
            int v= edges.get(i).get(1);
            int wt= edges.get(i).get(2);
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u,wt));
        }

        PriorityQueue<Pair> pq= new PriorityQueue<>((x,y)-> x.distance-y.distance);

        pq.add(new Pair(S,0));

        int[] dist= new int[V];
        for(int i=0;i<V;i++){
            dist[i]=(int)(1e9);
        }
        dist[S]=0;
        //now while the priority queue is not empty
        while(!pq.isEmpty()){
            Pair top= pq.poll();
            int node= top.node;
            int distance= top.distance;
            if(distance>dist[node]) continue;
            //now for all the neighbours of this node
            for(Pair neighbourPair: adj.get(node)){
                int neighbour= neighbourPair.node;
                int newDistance= neighbourPair.distance+distance;
                if(newDistance<dist[neighbour]){
                    dist[neighbour]= newDistance;
                    pq.add(new Pair(neighbour, newDistance));
                }
            }

        }

        return dist;
    }
}
