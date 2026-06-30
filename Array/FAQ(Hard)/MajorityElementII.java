import java.util.*;

public class MajorityElementII{
    public static List<Integer> majorityElementMooreAlgo(int[] nums){
        //we know there will be 2 elements that can be greater than n/3
        int n= nums.length;
        int count1=0;
        int count2=0;
        int ele1=-1;
        int ele2=-1;
        for(int num: nums){
            if(num==ele1){
                count1++;
            }
            else if(num==ele2){
                count2++;
            }
            else if(count1==0){
                count1=1;
                ele1=num;
            }
            else if(count2==0){
                count2=1;
                ele2=num;
            }
            else{
                count1--;
                count2--;
            }
            
        }
        //verify
        List<Integer> ans= new ArrayList<>();
        count1=0;
        count2=0;
        for(int i=0;i<n;i++){
            if(nums[i]==ele1){
                count1++;
            }
            else if(nums[i]==ele2){
                count2++;
            }
        }
        if(count1>Math.floor(n/3)){
            ans.add(ele1);
        }
        if(count2>Math.floor(n/3)){
            ans.add(ele2);
        }
        return ans;
    }
    public static List<Integer> majorityElementBetter(int[] nums){
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=nums.length;
        List<Integer> ans= new ArrayList<>();
        for(int num: nums){
            if(!ans.isEmpty() && ans.contains(num)) continue;
            hm.put(num, hm.getOrDefault(num, 0)+1);
            if(hm.get(num)>Math.floor(n/3)){
                ans.add(num);
                if(ans.size()==2){
                    return ans;
                }
            }
        }
        return ans;
    }
    public static List<Integer> majorityElementBrute(int[] nums){
        List<Integer> ans= new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(!ans.isEmpty() && ans.contains(nums[i]) )continue;
            int count=0;
            for(int j=0;j<n;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
            
            if(count>Math.floor(n/3)){
                ans.add(nums[i]);
            }
            if(ans.size()==2){
                return ans;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums={1,2,1,1,2,3,3,2};
        System.out.println(majorityElementMooreAlgo(nums));
    }
}