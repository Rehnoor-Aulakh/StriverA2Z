package Minimum_Spanning__Tree;
import java.sql.Array;
import java.util.*;

public class KruskalAlgorithm {
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;
        Edge(int src, int dest, int wt){
            this.src= src;
            this.dest= dest;
            this.wt= wt;
        }
        @Override
        public int compareTo(Edge o) {
            return this.wt-o.wt;
        }
    }

    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        List<Edge> edges= new ArrayList<>();
        //add all the edges from the adj
        for(int i=0;i<V;i++){
            for(int j=0; j<adj.get(i).size();j++){
                int adjNode= adj.get(i).get(j).get(0);
                int wt= adj.get(i).get(j).get(1);
                edges.add(new Edge(i, adjNode, wt));
            }
        }
        Collections.sort(edges);
        DisjointSet ds= new DisjointSet(V);
        int sum= 0;
        // iterate all the edges
        for(int i=0;i<edges.size();i++){
            int wt= edges.get(i).wt;
            int u= edges.get(i).src;
            int v= edges.get(i).dest;

            if(ds.findUPar(u) != ds.findUPar(v)){
                sum+=wt;
                ds.unionBySize(u,v);
            }
        }
        return sum;
    }
}
