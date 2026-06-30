package Implementation;

class Node1 {
    private boolean flag;
    Node1[] links;
    Node1(){
        flag= false;
        links= new Node1[26];
    }
    public boolean containsKey(char ch){
        if(links[ch-'a']!=null){
            return true;
        }
        return false;
    }
    public void insertKey(char ch, Node1 node){
        links[ch-'a']= node;
    }
    public Node1 get(char ch){
        return links[ch-'a'];
    }
    public void markEnd(){
        flag=true;
    }
    public boolean isEnd(){
        return flag;
    }
}

public class ImplementTrie {
    private Node1 root;
    public ImplementTrie() {
        root= new Node1();
    }

    public void insert(String word) {
        Node1 node=root;
        for(int i=0;i<word.length();i++){
            char ch= word.charAt(i);
            if(!node.containsKey(ch)){
                node.insertKey(ch, new Node1());
            }
            //move to the next node
            node= node.get(ch);
        }
        //at the end, mark it as true
        node.markEnd();
    }

    public boolean search(String word) {
        Node1 node= root;
        for(int i=0;i<word.length();i++){
            char ch= word.charAt(i);
            if(!node.containsKey(ch)){
                return false;
            }
            node= node.get(ch);
        }
        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node1 node= root;
        for(int i=0;i<prefix.length();i++){
            char ch= prefix.charAt(i);
            if(!node.containsKey(ch)){
                return false;
            }
            node=node.get(ch);
        }
        return true;
    }
}
