//package FAQs;
//
//import java.util.*;
//class Node{
//    Node next, prev;
//    int freq, key, value;
//    public Node(int key, int value, int freq){
//        this.key = key;
//        this.value= value;
//        this.freq= freq;
//    }
//
//}
//
//class List{
//    int size;
//    Node head = new Node(-1, -1, -1);
//    Node tail = new Node(-1, -1, -1);
//
//    public  void addNode(Node node){
//        Node nextNode = head.next;
//        head.next= node;
//        node.next= nextNode;
//        node.prev= head;
//        nextNode.prev= node;
//        size++;
//    }
//
//    public void removeNode(Node node){
//        Node nextNode = node.next;
//        Node prevNode = node.prev;
//        prevNode.next= nextNode;
//        nextNode.prev = prevNode;
//        size--;
//    }
//
//}
//
//public class LFUCache {
//    int minFreq= 0;
//    int size = 0;
//    private int capacity;
//    HashMap<Integer, Node> hm;
//    HashMap<Integer, List> freqMap;
//    public LFUCache(int capacity) {
//        this.capacity = capacity;
//        hm = new HashMap<>();
//        freqMap= new HashMap<>();
//    }
//    private void updateFreqMap(Node node){
//        int count = node.freq;
//        // remove it from hash map
//        hm.remove(node.key);
//        // remove it from frequency map
//        freqMap.get(count).removeNode(node);
//
//        // if the node was the last node having its frequency
//        if(count == minFreq && freqMap.get(count).size==0){
//            minFreq++;
//        }
//
//
//    }
//
//    public int get(int key) {
//        // LFU change, when you get it, increase its frequency by 1, and remove it from the List
//
//        // go to the map to check if the key is present
//        if(!hm.containsKey(key)) return -1;
//        // otherwise, remove the Node from its position and use addNode to mark the MRU node
//        Node toBeRemoved= hm.get(key);
//        removeNode(toBeRemoved);
//        addNode(toBeRemoved);
//        return toBeRemoved.value;
//    }
//
//    public void put(int key, int value) {
//        // CASE 1: THE KEY ALREADY EXISTS IN THE MAP, THEN REMOVE IT FROM ITS POSITION AND UPDATE ITS VALUE AND addNode() to bring it to the front
//        if(hm.containsKey(key)){
//            Node curr= hm.get(key);
//            removeNode(curr);
//            curr.value= value;
//            addNode(curr);
//            // increase its frequency by 1
//
//        }
//        // CASE 2: THE SIZE IS EQUAL TO CAPACITY
//        else if(hm.size() == capacity){
//
//            // delete the LRU Node, which would be the tail.prev
//            Node lru = tail.prev;
//            removeNode(lru);
//            hm.remove(lru.key);
//            Node newNode = new Node(key, value);
//            addNode(newNode);
//            hm.put(key, newNode);
//        }
//        else{
//            // just add the new Node
//            Node newNode = new Node(key, value, 1);
//            addNode(newNode);
//            hm.put(key, newNode);
//            if(freqMap.containsKey(1)){
//                freqMap.get(1).add(newNode);
//                freqMap.put(1, freqMap.get(1));
//            }else{
//                freqMap.put(1, Arrays.asList(newNode));
//            }
//            minFreq = 1;
//
//        }
//    }
//    static void main() {
//        Stack<Integer> st = new Stack<>();
//        st.push(2);
//        st.push(1);
//        st.remove(0);
//        System.out.println(st.toString());
//    }
//
//}
