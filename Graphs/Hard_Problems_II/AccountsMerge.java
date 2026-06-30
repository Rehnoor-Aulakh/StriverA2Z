package Hard_Problems_II;
import java.util.*;
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //how many accounts are there?
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        // now we need to map the integer index to an account
        Map<String, Integer> mapMailNode = new HashMap<>();
        // iterate all accounts
        for(int i=0;i<n;i++){
            //first one is the name
            for(int j=1;j< accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(!mapMailNode.containsKey(mail)){
                    mapMailNode.put(mail, i);
                }
                else{
                    // if it is already mapped to some index, that means that mail is repeated
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }
        // after this, we need to iterate on mapMailNode's entrySet to classify which Mail belongs to which node
        ArrayList<String>[] mergedMail = new ArrayList[n];
        for(int i=0;i<n;i++){
            mergedMail[i]= new ArrayList<>();
        }
        for(Map.Entry<String, Integer> entry: mapMailNode.entrySet()){
            String mail = entry.getKey();
            int node= entry.getValue();
            int ulp = ds.findUPar(node);
            mergedMail[ulp].add(mail);
        }
        //now create ans
        List<List<String>> ans = new ArrayList<>();
        // now iterate mergedMail
        for(int i=0;i<n;i++){
            if(mergedMail[i].isEmpty()) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            //get the name from the
            temp.add(accounts.get(i).get(0));
            for(String s: mergedMail[i]){
                temp.add(s);
            }
            ans.add(temp);
        }
        return ans;
    }
}
