import java.util.*;

public class MinimumPlatforms{
    public int findPlatform(int[] Arrival, int[] Departure) {
        Arrays.sort(Arrival);
        Arrays.sort(Departure);

        //iterate over the arrays, by keeping 2 pointers
        int i=0;
        int j=0;
        int count=0;
        int maxcount=0;
        int n=Arrival.length;
        while(i<n && j<n){
            if(Arrival[i]<=Departure[j]){
                //pichli depart nhi hui aur ek aur aa gyi
                count++;
                i++;
            }
            else{
                count--;
                j++;
            }
            maxcount=Math.max(maxcount,count);
        }
        
        return maxcount;
    }
    public static void main(String[] args) {
        
    }
}