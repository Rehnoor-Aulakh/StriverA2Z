package Cycles;
import java.util.*;

public class DetectCycleUndirectedGraph {
    static class Pair{
        int node;
        int parent;
        Pair(int node, int parent){
            this.node= node;
            this.parent= parent;
        }
    }
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] visited= new boolean[V];
        Queue<Pair> queue= new LinkedList<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                queue.add(new Pair(i,-1));
                visited[i]= true;
                int parent=0;
                while(!queue.isEmpty()){
                    Pair top = queue.poll();
                    //add all its children to the queue
                    for(Integer neighbour: adj[top.node]){
                        if(top.parent==neighbour) continue;
                        if(visited[neighbour]) return true;
                        visited[neighbour]= true;
                        queue.add(new Pair(neighbour, top.node));

                    }
                }
            }
        }

        return false;
    }
}
