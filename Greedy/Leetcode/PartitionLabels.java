import java.util.*;

public class PartitionLabels{
    public List<Integer> partitionLabelsOptimal(String s){
        List<Integer> ans = new ArrayList<>();

        //Track the last occurrence of each character
        int[] lastIndex= new int[26];
        for(int i=0;i<s.length();i++){
            lastIndex[s.charAt(i)-'a']=i;
        }
        //Partition
        int start=0, end=0;
        //start iterating from the start to the end of string
        for(int i=0;i<s.length();i++){
            end = Math.max(end,lastIndex[s.charAt(i)-'a']);
            if(i==end){
                ans.add(end-start+1);
                start=i+1;
            }
        }
        return ans;
    }
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Character,Integer> start= new HashMap<>();
        HashMap<Character,Integer> end= new HashMap<>();
        //iterate the string
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            //if c is not in start, push it, if c is in end, update it
            if(!start.containsKey(c)){
                start.put(c, i+1);
            }
            end.put(c, i+1);
        }
        //now our hash maps are ready, we need to sort end 
        //we can create intervals [start,end] for each character
        List<int[]> intervals= new ArrayList<>();
        for(char c: start.keySet()){
            intervals.add(new int[]{start.get(c),end.get(c)});
        }
        Collections.sort(intervals, (a,b)-> a[0]-b[0]);
        //now we need to iterate 
        int partitionStart= intervals.get(0)[0];
        int partitionEnd= intervals.get(0)[1];
        for(int i=1;i<intervals.size();i++){
            int curr[]= intervals.get(i);
            if(curr[0] <= partitionEnd){
                //start of current is inside the previous's end
                //current is inside the previous one
                //extend
                partitionEnd= Math.max(partitionEnd, curr[1]);
            }
            else{
                ans.add(partitionEnd-partitionStart+1);
                partitionStart=curr[0];
                partitionEnd=curr[1];
            }
        }
        //add the last partition
        ans.add(partitionEnd-partitionStart+1);
        return ans;
    }
    public static void main(String[] args) {
        
    }
}