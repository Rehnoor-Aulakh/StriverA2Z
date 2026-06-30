package Implementation;// Leetcode Premium Problem
// Contains Advanced Trie Operations

class Node{
    private Node[] links;
    private int countEndWith=0;
    private int countPrefix=0;
    Node(){
        links= new Node[26];
    }

    boolean containsKey(char ch){
        return (links[ch-'a']!=null);
    }

    Node get(char ch){
        return links[ch-'a'];
    }

    void put(char ch, Node node){
        links[ch-'a'] = node;
    }
    void increaseEnd(){
        countEndWith++;
    }
    void increasePrefix(){
        countPrefix++;
    }
    void deleteEnd(){
        countEndWith--;
    }
    void reducePrefix(){
        countPrefix--;
    }
    int getCountEndWith(){
        return countEndWith;
    }
    int getCountPrefix(){
        return countPrefix;
    }
}
class Trie {
    private Node root;
    Trie(){
        root= new Node();
    }
    void insert(String word){
        Node node= root;
        for(int i=0;i<word.length();i++){
            char ch= word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch, new Node());
            }
            node=node.get(ch);
            node.increasePrefix();
        }
        node.increaseEnd();
    }
    public int countWordsEqualTo(String word) {
        //return countEndWith after iteration
        Node node = root;
        for(int i=0;i<word.length();i++){
            char ch= word.charAt(i);
            if(!node.containsKey(ch)){
                return 0;
            }
            node=node.get(ch);
        }
        return node.getCountEndWith();
    }

    public int countWordsStartingWith(String prefix) {
        Node node= root;
        for(int i=0;i<prefix.length();i++){
            char ch= prefix.charAt(i);
            if(!node.containsKey(ch)){
                return 0;
            }
            node=node.get(ch);
        }
        return node.getCountPrefix();
    }

    public void erase(String word) {
        //it is a guarantee that the complete "word" exists in the trie, so just reach their and decrement countEndsWith
        Node node= root;
        for(int i=0;i<word.length();i++){
            char ch= word.charAt(i);
            if(!node.containsKey(ch)){
                return;
            }
            node.reducePrefix();
            node=node.get(ch);
        }
        node.deleteEnd();
    }
}

public class ImplementTrieII {
    public static void main(String[] args) {
        Trie trie= new Trie();
        trie.insert("apple");
        System.out.println(trie.countWordsEqualTo("apple"));
        trie.insert("app");
        System.out.println(trie.countWordsStartingWith("app"));
        trie.erase("apple");
        System.out.println(trie.countWordsStartingWith("app"));
    }
}