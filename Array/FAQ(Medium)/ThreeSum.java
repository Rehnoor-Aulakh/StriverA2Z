
import java.util.*;

public class ThreeSum{
    public static List<List<Integer>> threeSumOptimized(int[] nums){
        //we will first sort the nums
        Arrays.sort(nums);
        //then create a answer
        List<List<Integer>> ans = new ArrayList<>();
        int n= nums.length;
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k=n-1;

            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0){
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    //skip duplicates for j and k
                    while(j<k && nums[j]==nums[j+1]) j++;
                    while(j<k && nums[k]==nums[k-1]) k--;
                    //move to the new values
                    j++;
                    k--;
                }
                else if(sum<0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }

        return ans;
    }
    public static List<List<Integer>> threeSumBetter(int[] nums){
        Set<List<Integer>> tripletSet= new HashSet<>();
        int n=nums.length;
        //check all possible triplets
        for(int i=0;i<n;i++){
            //set of elements seen so far
            Set<Integer> hashSet= new HashSet<>();
            for(int j=i+1;j<n;j++){
                int third= -(nums[i]+nums[j]);
                if(hashSet.contains(third)){
                    List<Integer> temp= new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(third);

                    Collections.sort(temp);
                    tripletSet.add(temp);
                }
                //insert the jth element into hashset for future checks
                hashSet.add(nums[j]);
            }
        }
        //now convert the set to list
        List<List<Integer>> ans= new ArrayList<>(tripletSet);
        return ans;
    }
    public static void main(String[] args) {
        int nums[]={2, -2, 0, 3, -3, 5};
        System.out.println(threeSumOptimized(nums));

    }
}