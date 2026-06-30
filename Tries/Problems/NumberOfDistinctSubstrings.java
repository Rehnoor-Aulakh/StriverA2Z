//package Problems;
//
////Leetcode Premium
//class Node{
//    private Node[] links = new Node[26];
//    public boolean containsKey(char ch){
//        return (links[ch-'a']!=null);
//    }
//    void put(char ch, Node node){
//        links[ch-'a']= node;
//    }
//    Node get(char ch){
//        return links[ch-'a'];
//    }
//}
//
//public class NumberOfDistinctSubstrings {
//    public int countDistinctSubstring(String s) {
//        Node root= new Node();
//        int n= s.length();
//        int count=0;
//        for(int i=0;i<n;i++){
//            Node node = root;
//            for(int j=i;j<n;j++){
//                if(!node.containsKey(s.charAt(j))){
//                    count++;
//                    node.put(s.charAt(j), new Node());
//                }
//                node= node.get(s.charAt(j));
//            }
//        }
//        return count+1;
//
//    }
//
//    public static void main(String[] args) {
//        NumberOfDistinctSubstrings obj = new NumberOfDistinctSubstrings();
//        System.out.println(obj.countDistinctSubstring("abab"));
//    }
//
//}
