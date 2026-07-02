import java.util.*;

public class FindDifferenceOf2Arrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // basic solution
        HashSet<Integer> set1= new HashSet<>();
        HashSet<Integer> set2= new HashSet<>();
        for(int num: nums1){
            set1.add(num);
        }
        for(int num: nums2){
            set2.add(num);
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        // better way is to iterate the set and find the set difference
        for(int s1: set1){
            if(!set2.contains(s1)){
                // this is not there in nums2, so push it in ans.get(0)
                ans.get(0).add(s1);
            }
        }
        for(int s2: set2){
            if(!set1.contains(s2)){
                ans.get(1).add(s2);
            }
        }
        return ans;
    }
}
