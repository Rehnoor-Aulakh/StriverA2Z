import java.util.*;

public class NextPermutationBrute{
    @SuppressWarnings("Convert2Lambda")
    public static List<Integer> nextPermutation(int[] nums){
        List<List<Integer>> ans= GetPermutations.getPermutations(nums);
        //these permutations are unsorted, we need to sort the
        Collections.sort(ans, new Comparator<List<Integer>>(){
            @Override
            public int compare(List<Integer> e1, List<Integer> e2){
                //we have 2 lists of same size, we need to sort the list, by loop, we can calculate both the number
                int sum1=0;
                int sum2=0;
                for(int i=0;i<e1.size();i++){
                    sum1=sum1*10+e1.get(i);
                    sum2=sum2*10+e2.get(i);
                }
                if(sum1>sum2){
                    //then sorting is required
                    return 1;
                }
                else if(sum1<sum2){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        });

        System.out.println(ans);

        //now our only task remaining is to find the next permutation
        //we just need to match this current nums with ith index of list, and i+1 would be our answer, if i+1==list.length, return 0th

        int index=match(ans,nums);
        if(index==ans.size()-1){
            return ans.get(0);
        }
        else{
            return ans.get(index+1);
        }
        
    }

    private static int match(List<List<Integer>> list, int[] nums){
        //every list inside list is of same size as nums
        int n= nums.length;
        for(int j=0;j<list.size();j++){
            boolean flag=true;
            int i;
            for(i=0;i<n;i++){
                if(nums[i]!=list.get(j).get(i)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                return j;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int nums[]={1,2,3};
        System.out.println(nextPermutation(nums));
    }
}