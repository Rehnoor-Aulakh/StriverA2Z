class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}

public class SortALinkedList {
    // findMiddle(ListNode head)
    // mergeTwoSorted(ListNode head1, ListNode head2)

    private ListNode findMiddle(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode slow = head, fast = head.next;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow= slow.next;
        }
        return slow;
    }

    private ListNode mergeTwoSorted(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode t1 = head1, t2= head2;
        while(t1!=null && t2!=null){
            if(t1.val< t2.val){
                curr.next = new ListNode(t1.val);
                curr= curr.next;
                t1= t1.next;
            }
            else{
                curr.next = new ListNode(t2.val);
                curr = curr.next;
                t2 = t2.next;
            }
        }
        if(t1!=null){
            curr.next = t1;
        }
        if(t2!=null){
            curr.next = t2;
        }
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        // base case
        if(head==null || head.next==null) return head;

        ListNode middle = findMiddle(head);
        // merge these 2
        // head --- middle --- null
        // middle->next --- null
        ListNode middleNext = middle.next;
        middle.next = null;
        return mergeTwoSorted(sortList(head), sortList(middleNext));
    }
}
