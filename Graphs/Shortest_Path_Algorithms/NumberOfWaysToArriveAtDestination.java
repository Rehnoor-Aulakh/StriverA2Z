package Shortest_Path_Algorithms;
import java.util.*;

public class NumberOfWaysToArriveAtDestination {
    static class Pair{
        int node;
        long cost;
        Pair(int node, long cost){
            this.node= node;
            this.cost= cost;
        }
    }
    public int countPaths(int n, int[][] roads) {
        int MOD= (int)(1e9+7);
        //first create adjacency list
        List<List<Pair>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road: roads){
            adj.get(road[0]).add(new Pair(road[1], (long)road[2]));
            adj.get(road[1]).add(new Pair(road[0], (long)road[2]));
        }
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)-> Long.compare(a.cost, b.cost));
        long[] dist= new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0]=0;
        int[] count= new int[n];
        count[0]=1;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            int node=top.node;
            long cost= top.cost;
            if(cost>dist[node]) continue;
            for(Pair neighbourPair: adj.get(node)){
                int neighbour= neighbourPair.node;
                long newCost= (long) neighbourPair.cost + cost;
                //better path
                if(newCost<dist[neighbour]){
                    dist[neighbour]= newCost;
                    count[neighbour]= count[node];
                    pq.add(new Pair(neighbour, newCost));
                }
                //same shortest path
                else if(newCost==dist[neighbour]){
                    count[neighbour]= (count[neighbour]+ count[node])%MOD;
                }
            }
        }
        return count[n-1];
    }
}
