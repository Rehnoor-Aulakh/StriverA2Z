package Hard_Problems_II;

import java.util.HashMap;
import java.util.Map;

public class MostStonesRemovedWithSameRowOrCol {
    public int maxRemove(int[][] stones, int n) {
        //now you have to iterate the stones array
        int maxRow = 0;
        int maxCol = 0;
        for(int i=0;i<n;i++){
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
        HashMap<Integer, Integer> stoneNode= new HashMap<>();
        // hashmap to track which rows and columns are present as ultimate parents
        for(int[] stone: stones){
            int nodeRow = stone[0];
            int nodeCol = stone[1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            stoneNode.put(nodeRow,1);
            stoneNode.put(nodeCol,1);
        }
        int count=0;
        // track the ultimate parents
        for(Map.Entry<Integer, Integer> it: stoneNode.entrySet()){
            if(ds.findUPar(it.getKey()) == it.getKey()){
                count++;
            }
        }
        return n- count;

    }
}
