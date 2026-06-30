import java.util.*;

public class CountOfSmallerNumbersAfterSelf {
    public static  List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>((k1, k2) -> Integer.compare(k2,k1));
        for(int i=nums.length-1; i>=0; i--){
            int count = 0;
            // get the elements that are smaller than the current number
            for(Map.Entry entry: map.tailMap(nums[i]-1).entrySet()){
                count+= (int)entry.getValue();
            }
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            ans.add(count);
        }
        return ans.reversed();
    }

    static void main() {
        System.out.println(countSmaller(new int[]{5,2,6,1}));
    }
}
