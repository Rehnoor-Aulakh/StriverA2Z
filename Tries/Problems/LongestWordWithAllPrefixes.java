//package Problems;
//import java.util.*;
//
//class Node{
//    private Node[] links= new Node[26];
//    private boolean flag=false;
//
//    boolean containsKey(char ch){
//        return (links[ch-'a']!=null);
//    }
//    void put(char ch, Node node){
//        links[ch-'a']= node;
//    }
//    Node get(char ch){
//        return links[ch-'a'];
//    }
//    void setEnd(){
//        flag= true;
//    }
//    boolean getFlag(){
//        return flag;
//    }
//}
//
//class Trie{
//    Node root= new Node();
//    void insert(String word){
//        Node node= root;
//        for(int i=0;i<word.length();i++){
//            char ch= word.charAt(i);
//            if(!node.containsKey(ch)){
//                node.put(ch, new Node());
//            }
//            node= node.get(ch);
//        }
//        node.setEnd();
//    }
//    boolean isComplete(String word){
//        Node node= root;
//        for(int i=0; i<word.length() ; i++){
//            char ch= word.charAt(i);
//            if(!node.containsKey(ch)) return false;
//            node = node.get(ch);
//            if(!node.getFlag()) return false;
//        }
//        return true;
//    }
//}
//class Solution {
//    public String completeString(List<String> nums) {
//        //insert all the strings into the trie
//        Trie trie = new Trie();
//        for (String s : nums) {
//            trie.insert(s);
//        }
//        //now which one is the complete one, we need to iterate the strings one by one, and store the
//        //complete ones based on the size, and if size is same, store the lexicographically smaller one
//        String candidate = "";
//
//        for (String s : nums) {
//            if (trie.isComplete(s)) {
//                if (s.length() > candidate.length()) {
//                    candidate=s;
//                }
//                else if (s.length()==candidate.length() && s.compareTo(candidate) < 0) {
//                        candidate = s;
//                    }
//                }
//
//        }
//            return candidate;
//    }
//}
