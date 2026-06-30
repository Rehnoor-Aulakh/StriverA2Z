import java.util.HashMap;

public class MaximumNumberOfElementInSubset {
    public int maximumLength(int[] nums) {
        int ans = 0;
        if(nums.length>=1) ans=1;
        else return 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num:nums){
            if(freqMap.containsKey(num)){
                freqMap.put(num, freqMap.get(num)+1);
            }else{
                freqMap.put(num,1);
            }
        }

        // --- FIX 1: Handle '1' edge case separately to avoid infinite loop ---
        if (freqMap.containsKey(1)) {
            int count1 = freqMap.get(1);
            ans = Math.max(ans, count1 % 2 == 0 ? count1 - 1 : count1);
        }

        for(int num: nums){
            if (num == 1) continue; // --- FIX 2: Skip 1 in the main loop ---

            // --- FIX 3: Start checking if the baseline 'num' has at least 2 elements to begin a mountain ---
            if (freqMap.get(num) < 2) continue;

            int i=2, count=2; // --- FIX 4: Set initial count to 2 (outermost pair) ---
            boolean flag= true;

            // --- FIX 5: Stop tracking power if it overflows regular integer limits ---
            while(Math.pow(num, i) <= 1e9 && freqMap.containsKey((int)Math.pow(num,i)) && freqMap.get((int)Math.pow(num,i))>1){
                count += 2; // --- FIX 6: Add 2 for every valid layer (left and right elements) ---
                i*=2;
            }
            //and one element should be alone
            if(Math.pow(num, i) <= 1e9 && freqMap.containsKey((int)Math.pow(num,i))){
                count++;
            }
            else{
                // --- FIX 7: If there is no single peak element, the top pair is incomplete.
                // We must subtract 2 to make the previous complete layer the final peak.
                count -= 2;
            }
            if(flag){
                ans= Math.max(ans,count);
            }
        }
        return ans;
    }
}