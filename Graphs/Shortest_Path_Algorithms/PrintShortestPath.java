package Shortest_Path_Algorithms;
import java.util.*;

public class PrintShortestPath {
    static class Pair{
        int node;
        int distance;
        Pair(int node, int distance){
            this.node=node;
            this.distance=distance;
        }
    }
    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        //first build the adjacency list
        List<List<Pair>> adj= new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt= edges[i][2];
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        int[] dist= new int[n+1];
        int[] parent= new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }
        //now Dijkstra's Algorithm
        PriorityQueue<Pair> pq= new PriorityQueue<>(Comparator.comparingInt(p -> p.distance));

        for(int i=0;i<=n;i++){
            dist[i]=(int)(1e9);
        }
        dist[1]=0;
        pq.add(new Pair(1, 0));
        List<Integer> ans= new ArrayList<>();
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            int node= top.node;
            int distance= top.distance;
            if(distance>dist[node]) continue;
            //add the neighbours to pq
            for(Pair neighbourPair: adj.get(node)){
                int newDistance= neighbourPair.distance+ dist[node];
                if(newDistance< dist[neighbourPair.node]){
                    //update this
                    dist[neighbourPair.node]=newDistance;
                    parent[neighbourPair.node]=node;
                    pq.add(new Pair(neighbourPair.node, newDistance));
                }
            }
        }
        if(dist[n]==(int)(1e9)){
            ans.add(-1);
            return ans;
        }
        //backtrack
        int node=n;
        while(parent[node]!=node){
            ans.add(node);
            node=parent[node];
        }
        ans.add(1);
        ans.add(dist[n]);
        Collections.reverse(ans);
        return ans;
    }
}
