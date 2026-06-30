
import java.util.HashMap;

public class HighestOccuring{
    public static int mostFrequentElement(int[] nums){
        HashMap<Integer,Integer> mpp= new HashMap<>();
        for(int i: nums){
            mpp.put(i, mpp.getOrDefault(i, 0)+1);
        }
        int maxEle=0;
        int maxFreq=0;
        //now get the key with the maximum frequency
        for(Integer k: mpp.keySet()){
            if(mpp.get(k) > maxFreq){
                maxFreq=mpp.get(k);
                maxEle=k;
            }
        }
        return maxEle;

    }
    public static void main(String[] args) {
        int[] arr={1, 2, 2, 3, 3, 3};
        System.out.println(mostFrequentElement(arr));
    }
}