//package Easy;
//
//import java.util.Comparator;
//import java.util.PriorityQueue;
//
//public class FoodStamps {
//    static class Pair{
//        int value;
//        int time;
//        int index;
//
//        public Pair(int value, int time, int index) {
//            this.value = value;
//            this.time = time;
//            this.index = index;
//        }
//    }
//    public static int maxTastePoints(int n, int m, int[] v, int[] d){
//        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
//            @Override
//            public int compare(Pair t1, Pair t2) {
//                // if t2>t1, then we need to sort
//                return (t2.value-t1.value);
//            }
//        });
//        for(int i=0; i<n ;i++){
//            // add to the priority queue
//            Pair p = new Pair(v[i], 1, i);
//            pq.add(p);
//        }
//        // once all are there in the priority queue, begin removing
//        int count = 0;
//        int ans = 0;
//        while(!pq.isEmpty() && count<m){
//            Pair top = pq.poll();
//            count++;
//            ans+= top.value;
//            int index = top.index;
//            int value = top.value;
//            int newTime = top.time+1;
//            int newValue = v[index] - (d[index]*(newTime-1));
//            if(newValue>0){
//                pq.add(new Pair(newValue, newTime, index));
//            }
//
//        }
//        return ans;
//
//    }
//    public static void main(String[] args) {
//        int[] v= new int[]{5,7,9};
//        int[] d = new int[]{2,4,6};
//        int n = 3;
//        int m = 5;
//        System.out.println( maxTastePoints(n,m, v, d) );
//    }
//}
