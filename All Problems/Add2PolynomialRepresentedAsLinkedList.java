// Definition for polynomial singly-linked list.
class PolyNode {
      int coefficient, power;
      PolyNode next = null;
      PolyNode() {}
      PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
      PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
}

class Solution22 {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode t1 = poly1, t2 = poly2;
        //initialize ans with dummy node
        PolyNode ans = new PolyNode();
        PolyNode head = ans;
        while(t1!=null && t2!=null){
            // check if both t1 and t2 have equal coefficients
            if(t1.power == t2.power){
                int coeff = t1.coefficient + t2.coefficient;
                if(coeff!=0){
                    head.next = new PolyNode(coeff, t1.power);
                    head = head.next;

                }
                t1 =t1.next;
                t2 = t2.next;
            }
            else if(t1.power<t2.power){
                head.next = new PolyNode(t2.coefficient, t2.power);
                head = head.next;
                t2 = t2.next;
            }
            else{
                head.next = new PolyNode(t1.coefficient, t1.power);
                head = head.next;
                t1 = t1.next;
            }
        }
        // still possible that the other one is alive
        while(t1!=null){
            if(t1.coefficient!=0){
                head.next = new PolyNode(t1.coefficient, t1.power);
                head= head.next;
            }
            t1 = t1.next;
        }
        while(t2!=null){
            if(t2.coefficient!=0){
                head.next = new PolyNode(t2.coefficient, t2.power);
                head= head.next;
            }
            t2 = t2.next;
        }
        return ans.next;
    }
}