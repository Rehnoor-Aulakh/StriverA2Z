
import java.util.Collections;
import java.util.HashMap;

public class SecondHighestOccuring{
    
    public static int secondMostFrequentElement(int[] nums) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        //push the elements
        for(int i: nums){
            mpp.put(i, mpp.getOrDefault(i, 0)+1);
        }
        //in one pass only find the largest and the smallest element
        int maxEle=-1;
        int maxFreq=0;
        int secEle=-1;
        int secFreq=0;
        for(Integer k: mpp.keySet()){
            int freq = mpp.get(k);
            if(freq>maxFreq){
                //then this would become the second one
                secEle=maxEle;
                secFreq=maxFreq;
                maxFreq=freq;
                maxEle=k;
            }
            else if(freq==maxFreq){
                //choose the smaller k
                if(k<maxEle){
                    maxEle=k;
                }
            }
            //frequency in between maxFreq and secFreq
            else if(freq>secFreq && freq<maxFreq){
                //update the secFreq
                secFreq=mpp.get(k);
                secEle= k;
            }
            //equals case, for second
            else if(freq==secFreq){
                //choose the smallest k
                 if (secEle == -1 || k < secEle) {
                    secEle = k;
                    secFreq=freq;
                }
            }
            
        }
        System.out.println(Collections.max(mpp.values()));
        return secEle;
    }

    public static void main(String[] args) {
        int[] arr={4,4,5,5,6,7};
        System.out.println(secondMostFrequentElement(arr));
        
    }
}