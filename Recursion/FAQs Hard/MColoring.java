
import java.util.*;

class Solution{
    boolean graphColoring(int[][] edges, int m, int n) {
        //Create adjacency list to prevent extra time of iterating over all edges when checking
        List<List<Integer>> adj= new ArrayList<>();
        //for every node, add a new array list
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        //Build the graph from edges
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] colors = new int[n];
        return backtrack(adj, colors, m, n, 0);
    }
    boolean backtrack(List<List<Integer>> adj, int[] colors, int m, int n, int index){
        if(index==n) return true;
        for(int i=1;i<=m;i++){
            if(check(adj,colors,i,index)){
                //assign it the color
                colors[index]=i;
                //recursive call
                if(backtrack(adj, colors, m, n, index+1)){
                    return true;
                }
                //otherwise backtrack
                colors[index]=0;
            }
        }
        return false;
    }
    boolean check(List<List<Integer>> adj, int[] colors, int i, int index){
        //need to check if for all adjacent nodes adj.get(index) do not have assigned color as i
        for(int neighbour: adj.get(index)){
            if(colors[neighbour]==i) return false;
        }
        return true;
    }
}


public class MColoring{
    static boolean graphColoring(int[][] edges, int m, int n) {
        //create an array of size n to store which color is allocated to ith node
        int colors[]=new int[n];
        return color(edges, colors, m, n, 0);
    }
    static boolean color(int[][] edges, int[] colors, int m, int n, int index){
        if(index==n) return true;   //it was possible to color all nodes
        //we need to color the index'th node
        int i;
        for(i=1;i<=m;i++){
            //need to check if coloring with color i is possible on index'th node
            if(check(edges, colors, i, index)){
                colors[index]=i;
                //recurse
                if(color(edges,colors,m,n,index+1)){
                    return true;
                }
                //backtrack
                colors[index]=0;
            }
        }
        return false;
    }
    static boolean check(int[][] edges, int[] colors, int i, int index){
        //now we need to check if we can color index'th node with color i
        //for this I need to check the color of adjacent nodes of index, and make sure that they do not have color i
        //iterate on edges
        for (int[] edge : edges) {
            //now I need to get the adjacent node
            int adjNode;
            if(edge[0]==index){
                adjNode=edge[1];
            }
            else if(edge[1]==index){
                adjNode=edge[0];
            }
            else continue;  //because this does not contain index node

            //now I need to check if it has color i
            if(colors[adjNode]==i){
                return false;
            } 
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] edges={{0, 1},{1, 2},{2, 3},{3, 0},{0, 2}};
        int m=3;
        int n=4;
        System.out.println(graphColoring(edges, m, n));
        Solution s = new Solution();
        System.out.println(s.graphColoring(edges, m,n));
    }
    
}