package Shortest_Path_Algorithms;
import java.util.*;

class Solution{
    public int findCity(int n, int m, int edges[][],
                        int distanceThreshold) {
        //first do simple floyd warshall algorithm
        int dist[][]= new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    dist[i][j]=0;
                }
                else{
                    dist[i][j]= Integer.MAX_VALUE;
                }
            }
        }
        for(int i=0;i<edges.length;i++){
            int u= edges[i][0];
            int v= edges[i][1];
            int wt= edges[i][2];
            dist[u][v]=wt;
            dist[v][u]=wt;
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]==Integer.MAX_VALUE || dist[k][j]==Integer.MAX_VALUE) continue;
                    dist[i][j]= Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }
        int count=0, countMin=Integer.MAX_VALUE, city=-1;
        for(int i=0;i<n;i++){
            count=0;
            for(int j=0;j<n;j++){
                if(dist[i][j]<=distanceThreshold){
                    count++;
                }
            }
            if(count<countMin){
                countMin= count;
                city= i;
            }
        }
        return city;
    }
}

public class CityWithSmallestNumberOfNeighbours {
    static class Pair{
        int node;
        int distance;
        Pair(int node, int distance){
            this.node=node;
            this.distance=distance;
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u= edge[0];
            int v= edge[1];
            int wt= edge[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)-> a.distance-b.distance);
        int minimumTillNow=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int min=0;
            pq.add(new Pair(i, 0));
            int[] dist= new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i]=0;

            while(!pq.isEmpty()){
                Pair top = pq.poll();
                //add its neighbours to the pq only which are below the distanceThreshold
                int node= top.node;
                int distance= top.distance;
                if(distance>dist[node]) continue;
                for(Pair neighbourPair: adj.get(node)){
                    int neighbour= neighbourPair.node;
                    int newDist= neighbourPair.distance+ distance;
                    if(newDist <= distanceThreshold && newDist<dist[neighbour]){
                        dist[neighbour]= newDist;
                        //add it to pq, and add it to the valid neighboursList
                        pq.add(new Pair(newDist, neighbour));
                        min++;
                    }
                }
                minimumTillNow= Math.min(minimumTillNow, min);
            }
            pq.clear();
        }
        return minimumTillNow;
    }
}
