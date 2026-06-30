package Shortest_Path_Algorithms;
import java.util.*;

public class CheapestFlightWithinKStops {
    static class Tuple{
        int price;
        int stops;
        int node;
        Tuple(int node, int price, int stops){
            this.node=node;
            this.price=price;
            this.stops=stops;
        }
    }
    static class Pair{
        int price;
        int node;
        Pair(int node, int price){
            this.node=node;
            this.price=price;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //build the adjacency list
        List<List<Pair>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int u= flights[i][0];
            int v= flights[i][1];
            int price= flights[i][2];
            adj.get(u).add(new Pair(v,price));
        }
        Queue<Tuple> queue= new LinkedList<>();
        queue.add(new Tuple(src, 0,0));
        int[] dist= new int[n];
        for(int i=0;i<n;i++){
            dist[i]=(int)(1e9);
        }
        dist[src]= 0;
        while(!queue.isEmpty()){
            Tuple top = queue.poll();
            int stops= top.stops;
            int node= top.node;
            int cost= top.price;
            if(stops>k) continue;
            for(Pair neighbourPair: adj.get(node)){
                int neighbour= neighbourPair.node;
                int neighbourPrice= neighbourPair.price;
                if(cost+neighbourPrice<dist[neighbour] && stops<=k){
                    dist[neighbour]= cost+neighbourPrice;
                    queue.add(new Tuple(neighbour,dist[neighbour], stops+1));
                }
            }
        }
        if(dist[dst]==(int)(1e9))  return -1;
        return dist[dst];
    }
}
