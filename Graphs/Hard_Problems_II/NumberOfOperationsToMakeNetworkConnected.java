package Hard_Problems_II;
import java.util.*;

class DisjointSet{
    public List<Integer> parent = new ArrayList<>();
    public List<Integer> size= new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    public int findUPar(int node){
        if(node== parent.get(node)){
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }
    public void unionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        //they are already connected
        if(ulp_u == ulp_v) return;
        // otherwise find the smaller one
        if(size.get(u)<size.get(v)){
            //attach it to v
            size.set(v, size.get(u)+size.get(v));
            parent.set(ulp_u,ulp_v);
        }
        else{
            size.set(u, size.get(u) + size.get(v));
            parent.set(ulp_v, ulp_u);
        }
    }
}

public class NumberOfOperationsToMakeNetworkConnected {
    public int solve(int n, int[][] Edge) {
        DisjointSet ds = new DisjointSet(n);
        int extraEdges=0;
        for(int[] edge: Edge){
            int u = edge[0];
            int v = edge[1];
            if(ds.findUPar(u) == ds.findUPar(v)){
                //then they are already connected, so it is an extra edge
                extraEdges++;
            }
            //otherwise do unionBYSize
            ds.unionBySize(u,v);
        }
        int nc=0;
        for(int i=0;i<n;i++){
            if(ds.parent.get(i)==i) nc++;
        }
        if(extraEdges>= nc-1) return nc-1;
        return -1;
    }

}
