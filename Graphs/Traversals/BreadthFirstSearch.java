package Traversals;

import java.util.*;

public class BreadthFirstSearch {
    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> ans = new ArrayList<>();
        //0 based indexing
        boolean[] visited= new boolean[V];
        Queue<Integer> queue= new LinkedList<>();
        queue.add(0);
        visited[0]=true;
        while(!queue.isEmpty()){
            int top = queue.poll();
            ans.add(top);
            //get all the neighbours of top in the queue
            for(int neighbour: adj.get(top)){
                if(visited[neighbour]==false){
                    visited[neighbour]=true;
                    queue.add(neighbour);
                }
            }

        }
        return ans;
    }
}
