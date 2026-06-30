package Hard_Problems;
import java.util.*;
public class ShortestPathUndirectedUnitWeight {
    static class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int[] shortestPath(int[][] edges, int N, int M) {
        //first build the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u= edges[i][0];
            int v= edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        //we have to do simple bfs
        int[] dist= new int[N];
        for(int i=1;i<N;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        Queue<Pair> queue= new LinkedList<>();
        queue.add(new Pair(0,0));
        while(!queue.isEmpty()){
            Pair top= queue.poll();
            int node=top.node;
            int nodeDist=top.dist;
            for(int neighbour: adj.get(node)){
                if(dist[neighbour]>nodeDist+1){
                    dist[neighbour]= nodeDist+1;
                    queue.add(new Pair(neighbour, nodeDist+1));
                }
            }

        }
        for(int i=0;i<N;i++){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i]=-1;
            }
        }
        return dist;
    }
}
