package Problems;

class Node{
    Node[] links = new Node[2];
    boolean containsKey(int bit){
        return (links[bit]!=null);
    }
    Node get(int bit){
        return links[bit];
    }
    void put(int bit, Node node){
        links[bit]= node;
    }
}

class Trie{
    Node root= new Node();

    void insert(int num){
        Node node =root;
        for(int i= 31; i>=0 ;i--){
            // is the ith bit set or not
            int bit = (num >> i) & 1;
            if(!node.containsKey(bit)){
                node.put(bit, new Node());
            }
            node= node.get(bit);
        }
    }

    int getMax(int num){
        Node node = root;
        int maxNum=0;
        for(int i=31; i>=0 ; i--){
            int bit = (num >> i) & 1;
            //if it contains the opposite bit, which will increase the maximum, move there
            if(node.containsKey(1-bit)){
                //add this to your maxNum
                maxNum = maxNum | (1<<i);
                node= node.get(1-bit);
            }
            else{
                //there is no option, you have to continue
                node= node.get(bit);
            }
        }
        return maxNum;
    }
}

public class MaximumXOR {
    public int findMaximumXOR(int[] nums) {
        //insert all nums in the array
        Trie trie= new Trie();
        for(int num: nums){
            trie.insert(num);
        }
        //then find the max for every number
        // O(N) + O(N)
        int maxi=0;
        for(int num: nums){
            maxi = Math.max(maxi, trie.getMax(num));
        }
        return maxi;
    }
}
