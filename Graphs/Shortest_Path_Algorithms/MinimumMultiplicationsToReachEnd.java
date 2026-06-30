package Shortest_Path_Algorithms;
import java.util.*;

public class MinimumMultiplicationsToReachEnd {
    class Pair{
        int node;
        int level;
        Pair(int node, int level){
            this.node=node;
            this.level=level;
        }
    }
    public int minimumMultiplications(int[] arr, int start, int end) {
        //this is a simple bfs problem
        Queue<Pair> queue= new LinkedList<>();
        queue.add(new Pair(start,0));
        int MOD=100000;
        int[] dist= new int[MOD];
        Arrays.fill(dist,(int)(1e9));
        dist[start]=0;

        while(!queue.isEmpty()){
            //add the neighbours of start, that is multiply by arr and put into array
            Pair top=queue.poll();
            int node= top.node;
            //add the neighbours
            for(int i=0;i<arr.length;i++){
                int num= (node*arr[i])%MOD;
                //store and add only if this is a better solution
                if(top.level+1< dist[num]){
                    dist[num]=top.level+1;
                    if(num==end) return top.level+1;
                    queue.add(new Pair(num, top.level+1 ));
                }
            }
        }
        return -1;
    }

}
