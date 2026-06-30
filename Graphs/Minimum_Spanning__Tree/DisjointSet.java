package Minimum_Spanning__Tree;
import java.util.*;

public class DisjointSet {
    List<Integer> parent= new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size= new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }
    public int findUPar(int node){
        //base case
        if(node==parent.get(node)) return node;
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }
    public boolean find(int u, int v) {
        return findUPar(u)==findUPar(v);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u == ulp_v){
            //if the ultimate parent is same, then just return
            return;
        }
        // find the one which has the smaller rank
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            //then ulp_u will get attached to ulp_v
            parent.set(ulp_u, ulp_v);
        }
        else if(rank.get(ulp_v)< rank.get(ulp_u)){
            parent.set(ulp_v, ulp_u);
        }
        else{
            //if they have equal ranks,  attach anyone to anyone
            parent.set(ulp_v, ulp_u);
            // u will grow in size
            rank.set(ulp_u, rank.get(ulp_u)+1);
        }
    }

    public void unionBySize(int u, int v) {
        //first find the ultimate parent
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if(ulp_u==ulp_v) return;
        if(size.get(ulp_u)<size.get(ulp_v)){
            // u will get attached to ulp of v
            size.set(ulp_v, size.get(ulp_u)+size.get(ulp_v));
            parent.set(ulp_u, ulp_v);
        }
        else {
            size.set(ulp_u, size.get(ulp_u)+size.get(ulp_v));
            parent.set(ulp_v, ulp_u);
        }
    }
}
