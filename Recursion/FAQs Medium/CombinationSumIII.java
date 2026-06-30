import java.util.*;

public class CombinationSumIII{
    public static void findCombination(int k, int num, int target, List<Integer> t, List<List<Integer>> ans){
        if(target==0 && k==0){
            ans.add(new ArrayList<>(t));
            return;
        }
        for(int i=num;i<10;i++){
            if(i>target || k<=0) break;
            t.add(i);
            findCombination(k-1,i+1, target-i, t,ans);
            //backtrack
            t.remove(t.size()-1);
        }
    }

    @SuppressWarnings("UnnecessaryReturnStatement")
    private static void generate(List<List<Integer>> ans, List<Integer> t, int n, int k, int i){
        if((i>9) || (n<0) || (k<0)) return;
        if(k==0 && n==0){
            ans.add(new ArrayList<>(t));
            return;
        }
        else if(k==0 && n>0) return;
        //make recursive calls
        //include i
        t.add(i);
        generate(ans,t,n-i,k-1,i+1);
        //dont include i
        t.remove(t.size()-1);
        generate(ans, t, n, k, i+1);
        
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> t= new ArrayList<>();
        int i=1;
        findCombination(k, n, i, t, ans);
        return ans;
    }
    public static void main(String[] args) {
        int k=3,n=9;
        System.out.println(combinationSum3(k, n));

    }
}