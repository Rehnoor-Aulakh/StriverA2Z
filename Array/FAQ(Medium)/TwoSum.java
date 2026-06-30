import java.util.*;

class MyArray implements Comparator<MyArray>{
    int index;
    int data;

    public MyArray(int index, int data) {
        this.index=index;
        this.data=data;
    }
    @Override
    public int compare(MyArray a, MyArray b){
        //we need to sort 
        if(a.data>b.data){
            return 1;
        }
        else if(a.data<b.data){
            return -1;
        }else{
            return 0;
        }
    }

}

public class TwoSum{
    public static int[] twoSumOptimized(int[] nums, int target){
        int ans[]= new int[2];
        MyArray[] arr= new MyArray[nums.length];

        for(int i=0;i<nums.length;i++){
            arr[i]= new MyArray(i, nums[i]);
        }
        //this is a normal array only, not a collection
        //sort the array
        Arrays.sort(arr, new MyArray(0,0));
        //now let us build the solution of TwoSum
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int sum=arr[left].data+arr[right].data;
            if(sum==target){
                if(arr[left].index<arr[right].index){
                    ans[0]=arr[left].index;
                    ans[1]=arr[right].index;
                }
                else{
                    ans[0]=arr[right].index;
                    ans[1]=arr[left].index;
                }
                
                break;
            }
            else if(sum < target){
                //we need to move left forward
                left++;
            }
            else{
                right--;
            }
        }
        return ans;
    }
    public static int[] twoSumBetter(int[] nums, int target){
        //for every element store it in the hash map,
        //key is the element, value is the index
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ans[]=new int[2];
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(target-nums[i])){
                ans[0]=hm.get(target-nums[i]);
                ans[1]=i;
            }
            else{
                hm.put(nums[i], i);
            }
        }
        return ans;
    }
    public static int[] twoSumBrute(int[] nums, int target) {
        //for every element we will check if its counter is available
        int ans[]= new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    ans[0]=i;
                    ans[1]=j;
                    break;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[]={1, 3, 5, -7, 6, -3};
        int target=0;
        System.out.println(Arrays.toString(twoSumOptimized(nums, target)));
    }
}