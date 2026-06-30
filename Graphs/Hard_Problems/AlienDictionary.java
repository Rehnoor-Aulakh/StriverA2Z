package Hard_Problems;

import java.util.*;

public class AlienDictionary {
    public String findOrder(String [] dict, int N, int K) {
        StringBuilder ans= new StringBuilder();
        // we have an array of strings, pick 2 strings at a time, and figure out the edge of the graph
        // so I have k nodes in the graph, create an adjacency list for it, and then perform topo sort
        //2 pointers over 2 strings in dict
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<K;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=1;i<dict.length;i++){
            //one pointer over i-1 string and one over ith
            int i1=0, i2=0;
            String s1= dict[i-1];
            String s2= dict[i];
            while(i1<s1.length() && i2<s2.length() && s1.charAt(i1)==s2.charAt(i2)){
                i1++;
                i2++;
            }
            //if it is the end, we cannot figure out anything
            if(i1==s1.length() || i2==s2.length()) continue;
            //the moment they are different
            //s1.charAt(i1) edge s2.charAt(i2)
            adj.get(s1.charAt(i1)-'a').add(s2.charAt(i2)-'a');

        }
        //now that adjacency list is ready, time to build indegree array
        int[] indegree= new int[K];
        for(List<Integer> list: adj){
            for(int l: list){
                indegree[l]++;
            }
        }
        //first add indegree 0 to the ans
        Queue<Integer> queue= new LinkedList<>();
        for(int i=0;i<K;i++){
            if(indegree[i]==0){
                queue.add(i);
                ans.append(i+'a');
            }
        }
        while(!queue.isEmpty()){
            int node= queue.poll();
            for(int neighbour: adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    queue.add(neighbour);
                    ans.append(neighbour+'a');
                }
            }
        }
        return ans.toString();
    }
}
