package Minimum_Spanning__Tree;
import java.util.*;

public class PrimsAlgorithm {
    static class Tuple{
        int wt;
        int Node;
        int parent;
        Tuple(int wt, int Node, int parent){
            this.wt= wt;
            this.Node = Node;
            // for storing the edges of tree, we would need the parent
            this.parent= parent;
        }
    }
    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        // adjacency list is given
        boolean[] visited= new boolean[V];
        int sum=0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                if(o1.wt> o2.wt){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        });
        pq.add(new Tuple(0,0,-1));
        while(!pq.isEmpty()){
            Tuple top = pq.poll();
            int node= top.Node;
            if(visited[node]) continue;
            int parent= top.parent;
            int wt= top.wt;
            //go on to the neighbours of this node
            sum+=wt;
            visited[node]= true;
            for(List<Integer> neighbourPair: adj.get(node)){
                int neighbour= neighbourPair.get(0);
                int neighbourWt= neighbourPair.get(1);
                if(!visited[neighbour]){
                    //add it to priority queue
                    pq.add(new Tuple(neighbourWt, neighbour, node));
                }
            }
        }
        return sum;
    }
}
