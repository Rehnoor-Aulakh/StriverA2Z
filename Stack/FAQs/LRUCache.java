package FAQs;
import java.util.*;

class Node1{
    int key, value;
    public Node1 prev;
    public Node1 next;
    public Node1(int key, int value){
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    // INITIALIZE DUMMY HEAD AND TAIL Node1S TO AVOID EDGE CASES
    Node1 head = new Node1(-1, -1);
    Node1 tail = new Node1(-1, -1);
    private int capacity;
    HashMap<Integer, Node1> hm;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        hm = new HashMap<>();
        // INITIALISE THE DUMMY BOUNDARIES
        head.next= tail;
        tail.prev= head;
    }

    // HELPER FUNCTIONS FOR DOUBLY LINKEDLIST OPERATIONS
    private void addNode1(Node1 Node1){
        Node1 nextNode1 = head.next;
        head.next= Node1;
        Node1.next= nextNode1;
        Node1.prev= head;
        nextNode1.prev= Node1;
    }

    private void removeNode1(Node1 Node1){
        Node1 nextNode1 = Node1.next;
        Node1 prevNode1 = Node1.prev;
        prevNode1.next= nextNode1;
        nextNode1.prev = prevNode1;
    }

    public int get(int key) {
        // go to the map to check if the key is present
        if(!hm.containsKey(key)) return -1;
        // otherwise, remove the Node1 from its position and use addNode1 to mark the MRU Node1
        Node1 toBeRemoved= hm.get(key);
        removeNode1(toBeRemoved);
        addNode1(toBeRemoved);
        return toBeRemoved.value;
    }

    public void put(int key, int value) {
        // CASE 1: THE KEY ALREADY EXISTS IN THE MAP, THEN REMOVE IT FROM ITS POSITION AND UPDATE ITS VALUE AND addNode1() to bring it to the front
        if(hm.containsKey(key)){
            Node1 curr= hm.get(key);
            removeNode1(curr);
            curr.value= value;
            addNode1(curr);
        }
        // CASE 2: THE SIZE IS EQUAL TO CAPACITY
        else if(hm.size() == capacity){
            // delete the LRU Node1, which would be the tail.prev
            Node1 lru = tail.prev;
            removeNode1(lru);
            hm.remove(lru.key);
            Node1 newNode1 = new Node1(key, value);
            addNode1(newNode1);
            hm.put(key, newNode1);
        }
        else{
            // just add the new Node1
            Node1 newNode1 = new Node1(key, value);
            addNode1(newNode1);
            hm.put(key, newNode1);
        }
    }
    static void main() {
        Stack<Integer> st = new Stack<>();
        st.push(2);
        st.push(1);
        st.remove(0);
        System.out.println(st.toString());
    }

}
